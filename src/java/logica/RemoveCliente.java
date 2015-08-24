package logica;

import dao.ClienteDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;

public class RemoveCliente implements Logica{

  @Override
  public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
    long id = Long.parseLong(req.getParameter("id"));
    Cliente cliente = new Cliente();
    cliente.setId(id);
    ClienteDao dao = new ClienteDao();
    dao.remove(cliente);
    System.out.println("Excluindo Cliente");
    return "mvc?logica=ListaClientes";
  }
  
}
