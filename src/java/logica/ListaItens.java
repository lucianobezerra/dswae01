package logica;

import dao.VendaDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Item;
import model.Venda;

/**
 *
 * @author Luciano
 */
public class ListaItens implements Logica{

  @Override
  public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
    Venda venda = new VendaDao().getVenda(Integer.valueOf(req.getParameter("venda_id")));
    List<Item> itens = new VendaDao().listItens(venda);
    req.setAttribute("venda", venda);
    req.setAttribute("itens", itens);
    return "lista-itens.jsp";
  }
  
}
