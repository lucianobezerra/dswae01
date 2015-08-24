package logica;

import dao.VendaDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Venda;

/**
 *
 * @author Luciano
 */
public class ListaVendas implements Logica{

  @Override
  public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
    List<Venda> vendas = new VendaDao().getVendas();
    req.setAttribute("vendas", vendas);
    return "lista-vendas.jsp";
  }
  
}
