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
    int item_id  = Integer.parseInt(req.getParameter("id"));
    int venda_id = Integer.parseInt(req.getParameter("venda_id"));
    
    Item item = new ItemDao().getItem(item_id);
    atualizaVenda(item);
    new ItemDao().remove(item.getId());
    return "mvc?logica=ListaItens&venda_id="+venda_id;
  }
  private void atualizaVenda(Item item) {
    Venda venda = item.getVenda();
    venda.setQuantidade(venda.getQuantidade() - item.getQuantidade());
    venda.setValor(venda.getValor() - item.getTotal());
    new VendaDao().altera(venda);
  }
  
}
