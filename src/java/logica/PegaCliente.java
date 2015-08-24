package logica;

import dao.ClienteDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;

/**
 *
 * @author Luciano
 */
public class PegaCliente implements Logica{

  @Override
  public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
    int id = Integer.parseInt(req.getParameter("id"));
    Cliente cliente = new ClienteDao().getCliente(id);
    req.setAttribute("cliente", cliente);
    return "pega_cliente.jsp";
  }
  
}
