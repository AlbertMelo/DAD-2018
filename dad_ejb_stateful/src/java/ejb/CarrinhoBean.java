/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import modelo.Item;
import modelo.ICarrinho;

/**
 *
 * @author Albert Lima de Melo
 */
@Remote(ICarrinho.class)
@Stateful
public class CarrinhoBean implements ICarrinho {
    
    private List<Item> carrinho = new ArrayList<Item>();

    @Override
    public void inserirItem(Item item) {
        carrinho.add(item);
        System.out.println("Item adicionado!");
    }

    @Override
    public void removerItem(Item item) {
        carrinho.remove(item);
        System.out.println("Item removido!");
    }

    @Override
    public List<Item> listarItem() {
    
        return carrinho;

    }

}
