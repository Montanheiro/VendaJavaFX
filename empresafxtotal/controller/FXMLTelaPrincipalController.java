/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresafxtotal.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Usuario-PC
 */
public class FXMLTelaPrincipalController implements Initializable {

    @FXML
    private AnchorPane anchorPaneTelas;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void abraTelaMantemCliente() throws IOException{
        AnchorPane a = FXMLLoader.load(getClass().getResource("/empresafxtotal/view/FXMLMantemCliente.fxml"));
        anchorPaneTelas.getChildren().setAll(a);
    }
    public void abraTelaMantemFornecedor() throws IOException{
        AnchorPane b = FXMLLoader.load(getClass().getResource("/empresafxtotal/view/FXMLMantemFornecedor.fxml"));
        anchorPaneTelas.getChildren().setAll(b);
    }
    public void abraTelaMantemCargo() throws IOException{
        AnchorPane c = FXMLLoader.load(getClass().getResource("/empresafxtotal/view/FXMLMantemCargo.fxml"));
        anchorPaneTelas.getChildren().setAll(c);
    } 
    public void abraTelaMantemFuncionario() throws IOException{
        AnchorPane d = FXMLLoader.load(getClass().getResource("/empresafxtotal/view/FXMLMantemFuncionario.fxml"));
        anchorPaneTelas.getChildren().setAll(d);
    }
    public void abraTelaMantemProduto() throws IOException{
        AnchorPane e = FXMLLoader.load(getClass().getResource("/empresafxtotal/view/FXMLMantemProduto.fxml"));
        anchorPaneTelas.getChildren().setAll(e);
    }
    public void abraTelaMantemVenda() throws IOException{
        AnchorPane f = FXMLLoader.load(getClass().getResource("/empresafxtotal/view/FXMLMantemVenda.fxml"));
        anchorPaneTelas.getChildren().setAll(f);
    }
}
