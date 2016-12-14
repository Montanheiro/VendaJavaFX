/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresafxtotal;

import empresafxtotal.controller.Cliente;
import empresafxtotal.controller.Funcionario;
import empresafxtotal.controller.Venda;
import empresafxtotal.controller.VendaItem;
import empresafxtotal.model.FuncionarioDAO;
import empresafxtotal.model.VendaDAO;
import empresafxtotal.model.VendaItemDAO;
import java.util.ArrayList;
import java.util.Date;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Usuario-PC
 */
public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
//        Cliente c = new Cliente();
//        Funcionario f = new Funcionario();
//        Venda v = new Venda(44, new Date(), c, f);
//        v.addItem(new VendaItem(5, 3.5, new Produto()));
        

//        Cliente c = new Cliente("Nome", "CPF");
//        Funcionario vendedor = FuncionarioDAO.retreave(10);
//        ArrayList<VendaItem> teste = VendaItemDAO.retreaveAll();
//        for (VendaItem e : teste) {
//            System.out.println(e);
//        }
//        Venda v = new Venda(1, new Date(), c, vendedor, teste);
//        VendaDAO.create(v);
        
        
        
        
        
        Parent root = FXMLLoader.load(getClass().getResource("view/FXMLTelaPrincipal.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        
        stage.setTitle("EmpresaFX-TOTAL 1.0");
        Image icone = new Image(getClass().getResourceAsStream("resources/icon.png"));
        stage.getIcons().add(icone);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
