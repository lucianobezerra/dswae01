package logica;

import dao.FornecedorDao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Fornecedor;

@WebServlet(name = "GravaFornecedor", urlPatterns = {"/gravaFornecedor"})
public class GravaFornecedor extends HttpServlet {

  protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    String id     = request.getParameter("id");
    String razao  = request.getParameter("razao").toUpperCase();
    String cnpj   = request.getParameter("cnpj");
    String uf     = request.getParameter("uf").toUpperCase();
    String cidade = request.getParameter("cidade").toUpperCase();
    Fornecedor fornecedor = new Fornecedor();
    fornecedor.setRazao(razao);
    fornecedor.setCnpj(cnpj);
    fornecedor.setUf(uf);
    fornecedor.setCidade(cidade);
    FornecedorDao dao = new FornecedorDao();
    if (id == null) {
      dao.adiciona(fornecedor);
    } else {
      fornecedor.setId(Integer.valueOf(id));
      dao.altera(fornecedor);
    }
    RequestDispatcher rd = request.getRequestDispatcher("mvc?logica=ListaFornecedores");
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
