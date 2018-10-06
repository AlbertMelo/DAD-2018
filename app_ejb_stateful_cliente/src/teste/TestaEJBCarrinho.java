/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.rmi.RemoteException;
import java.util.List;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import modelo.ICarrinho;
import modelo.Item;


/**
 *
 * @author Albert Lima de Melo
 */
public class TestaEJBCarrinho {
    
    public static void main(String[] args) throws RemoteException, NamingException {
        
        InitialContext contexto = new InitialContext();
        Item novo1 = new Item("Produt 1", 10, 5);
        Item novo2 = new Item("Produt 2", 20, 15);
        Item novo3 = new Item("Produt 3", 30, 25);
        
        ICarrinho carrinhoBean = (ICarrinho) contexto.lookup("ejb:/dad_ejb_stateful/CarrinhoBean!modelo.ICarrinho?stateful");
        
        carrinhoBean.inserirItem(novo1);
        carrinhoBean.inserirItem(novo2);
        carrinhoBean.inserirItem(novo3);
        
        List<Item> itens = carrinhoBean.listarItem();
        
        for( Item item : itens){
            System.out.println(item.getProduto());
        }
        
    }
    
}