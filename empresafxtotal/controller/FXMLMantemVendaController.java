package empresafxtotal.controller;

import java.net.URL;
import java.util.ResourceBundle;
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
    private ComboBox<?> comboBoxProdutos;

    @FXML
    private TextField textFieldQuantidade;

    @FXML
    private ComboBox<?> comboBoxVendedor;

    @FXML
    private ComboBox<?> comboBoxCliente;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("ABRIU CARARIO");
        
        
        
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
