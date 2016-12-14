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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class FXMLMantemVendaController implements Initializable {

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

        
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("ABRIU VENDA");
        
        //FORÇANDO A ACEITAR SOMENTE NUMEROS
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
    }
    
    @FXML
    void lancar() {
        System.out.println("lançou");
    }

    @FXML
    void salvar() {
        System.out.println("salvou");
    }

    @FXML
    void limpaTela() {
        System.out.println("limpou");
    }

}
