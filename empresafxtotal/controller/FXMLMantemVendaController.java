package empresafxtotal.controller;

import empresafxtotal.model.ClienteDAO;
import empresafxtotal.model.FuncionarioDAO;
import empresafxtotal.model.ProdutoDAO;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        System.out.println("ABRIU CARARIO");
        
        try {
            List<Cliente> clientes = ClienteDAO.retreaveAll();
            comboBoxCliente.getItems().addAll(clientes);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLMantemVendaController.class.getName()).log(Level.SEVERE, null, ex);
        }
             
        try {
            List<Funcionario> vendedores = FuncionarioDAO.retreaveAllVendedores();
            comboBoxVendedor.getItems().addAll(vendedores);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLMantemVendaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
