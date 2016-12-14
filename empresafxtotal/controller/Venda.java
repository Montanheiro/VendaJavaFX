/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresafxtotal.controller;

import java.util.ArrayList;

/**
 *
 * @author dione
 */
public class Venda {
    private int numero;
    private String data;
    private Cliente cliente;
    private Funcionario vendedor;
    private ArrayList<VendaItem> itens;
    
    private int pkVenda;

    public Venda() {
    }

    public Venda(int numero, String data, Cliente cliente, Funcionario vendedor) {
        this.numero = numero;
        this.data = data;
        this.cliente = cliente;
        this.vendedor = vendedor;
    }

     public Venda(int pkVenda, int numero, String data, Cliente cliente, Funcionario vendedor, ArrayList<VendaItem> itens) {
        this.pkVenda = pkVenda;
        this.numero = numero;
        this.data = data;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.itens = itens;
    }
     
    public Venda(int numero, String data, Cliente cliente, Funcionario vendedor, ArrayList<VendaItem> itens) {
        this.numero = numero;
        this.data = data;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.itens = itens;
    }

    public Venda(int pkVenda, int numero, String data, Funcionario vendedor, ArrayList<VendaItem> itens) {
        this.numero = numero;
        this.data = data;
        this.vendedor = vendedor;
        this.itens = itens;
        this.pkVenda = pkVenda;
    }
    
    public void addItem(VendaItem vi){
        if (itens ==null) {
            itens = new ArrayList<>();
        }
        itens.add(vi);
    }

    public int getNumero() {
        return numero;
    }

    public String getData() {
        return data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Funcionario getVendedor() {
        return vendedor;
    }

    public ArrayList<VendaItem> getItens() {
        return itens;
    }

    public int getPkVenda() {
        return pkVenda;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setVendedor(Funcionario vendedor) {
        this.vendedor = vendedor;
    }

    public void setItens(ArrayList<VendaItem> itens) {
        this.itens = itens;
    }

    public void setPkVenda(int pkVenda) {
        this.pkVenda = pkVenda;
    }

    @Override
    public String toString() {
        return "Venda{" + "numero=" + numero + ", data=" + data + ", cliente=" + cliente + ", vendedor=" + vendedor + ", itens=" + itens + ", pkVenda=" + pkVenda + '}';
    }
    
    
    
}