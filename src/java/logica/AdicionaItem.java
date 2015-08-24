package logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdicionaItem implements Logica {

  @Override
  public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
    String venda_id = req.getParameter("venda_id");
    req.setAttribute("venda_id", venda_id);
    return "adiciona-item.jsp";
  }

}
