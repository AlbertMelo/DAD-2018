/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.rmi.Remote;
import java.util.List;

/**
 *
 * @author Albert Lima de Melo
 */
public interface ICarrinho extends Remote {
    
    
    public void inserirItem(Item item);
    public void removerItem(Item item);
    public List<Item> listarItem();
    
}
