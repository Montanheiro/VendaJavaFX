package empresafxtotal.controller;

import empresafxtotal.model.ClienteDAO;
import empresafxtotal.model.FuncionarioDAO;
import empresafxtotal.model.ProdutoDAO;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class FXMLMantemVendaController implements Initializable {
    
    Venda v;
    VendaItem vi;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextField textFieldPreco;

    @FXML
    private ComboBox<Produto> comboBoxProdutos;

    @FXML
    private TextField textFieldQuantidade;

    @FXML
    private ComboBox<Funcionario> comboBoxVendedor;

    @FXML
    private ComboBox<Cliente> comboBoxCliente;
    
    @FXML
    private TableView tabela;

    @FXML
    private TableColumn<VendaItem, Float> colunaPreco;

    @FXML
    private TableColumn<VendaItem, Integer> colunaQtd;

    @FXML
    private TableColumn<VendaItem, String> colunaProduto;
    
    final ObservableList<VendaItem> listaProdutos = FXCollections.observableArrayList(); 
        
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("ABRIU VENDA");
        
        //FORÇANDO A ACEITAR SOMENTE NUMEROS EM QTD E PREÇO
        textFieldQuantidade.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*/.?")) {
                    textFieldQuantidade.setText(newValue.replaceAll("[^\\d/.?]", ""));
                }
            }
        });
        textFieldPreco.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*/.?")) {
                    textFieldPreco.setText(newValue.replaceAll("[^\\d/.?]", ""));
                }
            }
        });
               
        //PUXANDO VENDEDORES PRA TELA
        try {
            List<Funcionario> vendedores = FuncionarioDAO.retreaveAllVendedores();
            comboBoxVendedor.getItems().addAll(vendedores);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLMantemVendaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //PUXANDO CLIENTES PRA TELA
        try {
            List<Cliente> clientes = ClienteDAO.retreaveAll();
            comboBoxCliente.getItems().addAll(clientes);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLMantemVendaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //PUXANDO PRODUTOS PRA TELA
        try {
            List<Produto> produtos = ProdutoDAO.retreaveAll();
            comboBoxProdutos.getItems().addAll(produtos);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLMantemVendaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //CRIANDO TABELA DE PRODUTOS
        colunaQtd.setCellValueFactory(new PropertyValueFactory<>("qtd"));
        colunaPreco.setCellValueFactory(new PropertyValueFactory<>("valorUnitario"));
        colunaProduto.setCellValueFactory(new PropertyValueFactory<>("produto"));
        
        tabela.setItems(null);
        tabela.setItems(listaProdutos);
    }
    
    @FXML
    void lancar() {
        //Envia para a lista de produtos
        vi = new VendaItem(Integer.parseInt(textFieldQuantidade.getText()),Float.parseFloat(textFieldPreco.getText()),comboBoxProdutos.getValue());
        listaProdutos.add(vi);
        
        //Limpa os campos usados para inserir um novo produto
        comboBoxProdutos.valueProperty().set(null);
        textFieldQuantidade.clear();
        textFieldPreco.clear();
        
        System.out.println("Lançou: " + vi);
    }

    @FXML
    void salvar() {
        System.out.println("salvou");
    }

    @FXML
    void limpaTela() {
        
        comboBoxVendedor.valueProperty().set(null);
        comboBoxCliente.valueProperty().set(null);
        comboBoxProdutos.valueProperty().set(null);
        textFieldQuantidade.clear();
        textFieldPreco.clear();
        tabela.setItems(null);
        vi = null;
        
        System.out.println("Cancelou a venda");
    }

}
