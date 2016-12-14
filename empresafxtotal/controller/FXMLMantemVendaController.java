/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresafxtotal.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
/**
 *
 * @author lucas
 */
public class FXMLMantemVendaController {
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

    @FXML
    void lancar(ActionEvent event) {
        System.out.println("Lançou");
    }

    @FXML
    void salvar(ActionEvent event) {
        System.out.println("Salvou");
    }

    @FXML
    void limpaTela(ActionEvent event) {
        System.out.println("Limpou");
    }
}
