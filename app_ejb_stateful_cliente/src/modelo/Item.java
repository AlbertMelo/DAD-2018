/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author Albert Lima de Melo
 */
public class Item implements Serializable{
    private static final long serialVersion = 1L;
       
    private String produto;
    private double valor;
    private int qtde;

    public Item() {
    }

    
    public Item(String produto, double valor, int qtde) {
        this.produto = produto;
        this.valor = valor;
        this.qtde = qtde;
    }

    
    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }
    
    
}
