package logica;

import dao.ClienteDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;

/**
 *
 * @author Luciano
 */
public class ListaClientes implements Logica{

  @Override
  public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
    List<Cliente> clientes = new ClienteDao().getClientes();
    req.setAttribute("clientes", clientes);
    return "lista-clientes.jsp";
  }
  
}
