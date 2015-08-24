package test;

import dao.VendaDao;
import java.util.List;
import model.Item;
import model.Venda;

/**
 *
 * @author luciano
 */
public class TestaItens {

  public static void main(String[] args) {
    Venda venda = new VendaDao().getVenda(1);
    List<Item> itens = new VendaDao().listItens(venda);
    System.out.println(itens.size());
    for (Item item : itens) {
      System.out.println(item.getProduto().getDescricao());
    }
  }
}
