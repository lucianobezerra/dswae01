package logica;

import dao.FornecedorDao;
import dao.ProdutoDao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Produto;

@WebServlet(name = "GravaProduto", urlPatterns = {"/gravaProduto"})
public class GravaProduto extends HttpServlet {

  protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    String id        = request.getParameter("id");
    String fornecedo = request.getParameter("fornecedor_id");
    String descricao = request.getParameter("descricao").toUpperCase();
    String unidade   = request.getParameter("unidade").toUpperCase();
    String valor     = request.getParameter("valor");
    Produto produto = new Produto();
    produto.setFornecedor(new FornecedorDao().getFornecedor(Integer.valueOf(fornecedo)));
    produto.setDescricao(descricao);
    produto.setUnidade(unidade);
    produto.setValor(Double.parseDouble(valor));
    ProdutoDao dao = new ProdutoDao();
    if (id == null) {
      dao.adiciona(produto);
    } else {
      produto.setId(Integer.valueOf(id));
      dao.altera(produto);
    }
    RequestDispatcher rd = request.getRequestDispatcher("mvc?logica=ListaProdutos");
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
