package logica;

import dao.VendaDao;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Venda;

/**
 *
 * @author luciano
 */
@WebServlet(name = "ListaProdutoVendido", urlPatterns = {"/listaProdutoVendido"})
public class ListaProdutoVendido extends HttpServlet {

  private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
   String data1 = request.getParameter("data_inicial");
   String data2 = request.getParameter("data_final");
   List<Venda> vendas = new VendaDao().getVendas(data1, data2);
   request.setAttribute("vendas", vendas);
   request.setAttribute("data1", data1);
   request.setAttribute("data2", data2);
   RequestDispatcher rd = request.getRequestDispatcher("lista-produtos-vendidos.jsp");
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
