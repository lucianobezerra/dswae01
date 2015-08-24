package logica;

import dao.ItemDao;
import dao.VendaDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Item;
import model.Venda;

public class RemoveItem implements Logica{

  @Override
  public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
    int id = Integer.parseInt(req.getParameter("id"));
    //int venda_id = Integer.parseInt(req.getParameter("venda_id"));
    Item item = new Item();
    item.setId(id);
    ItemDao dao = new ItemDao();
    dao.remove(item);
    atualizaVenda(item);
    System.out.println("Excluindo Produto");
    return "mvc?logica=ListaItens";
  }
  private void atualizaVenda(Item item) {
    Venda venda = item.getVenda();
    venda.setQuantidade(venda.getQuantidade() - item.getQuantidade());
    venda.setValor(venda.getValor() - item.getTotal());
    
    VendaDao dao = new VendaDao();
    dao.altera(venda);
  }
  
}
