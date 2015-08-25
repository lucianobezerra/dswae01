package logica;

import dao.ItemDao;
import dao.VendaDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Item;
import model.Venda;

public class RemoveVenda implements Logica{

  @Override
  public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
    int id  = Integer.parseInt(req.getParameter("id"));
    Venda venda = new VendaDao().getVenda(id);
    List<Item> items = new VendaDao().listItens(venda);
    System.out.println("Itens da Venda:" + items.size());
    for (Item item : items) {
      System.out.println("Excluindo o Item " + item.getId());
      new ItemDao().remove(item.getId());
    }
    new VendaDao().remove(venda);
    System.out.println("Excluindo Venda");
    return "mvc?logica=ListaVendas";
  }
  
}
