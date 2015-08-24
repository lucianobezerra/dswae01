package logica;

import dao.ClienteDao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;

@WebServlet(name = "GravaCliente", urlPatterns = {"/gravaCliente"})
public class GravaCliente extends HttpServlet {

  protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    String id     = request.getParameter("id");
    String nome   = request.getParameter("nome").toUpperCase();
    String cpf   = request.getParameter("cpf");
    String uf     = request.getParameter("uf").toUpperCase();
    String cidade = request.getParameter("cidade").toUpperCase();
    Cliente cliente = new Cliente();
    cliente.setNome(nome);
    cliente.setCpf(cpf);
    cliente.setUf(uf);
    cliente.setCidade(cidade);
    ClienteDao dao = new ClienteDao();
    if (id == null) {
      dao.adiciona(cliente);
    } else {
      cliente.setId(Integer.valueOf(id));
      dao.altera(cliente);
    }
    RequestDispatcher rd = request.getRequestDispatcher("mvc?logica=ListaClientes");
    rd.forward(request, response);
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  @Override
  public String getServletInfo() {
    return "Short description";
  }

}
