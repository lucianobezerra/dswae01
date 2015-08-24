package logica;

import dao.ProdutoDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Produto;

public class AlteraProduto implements Logica{

  @Override
  public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
    int id = Integer.parseInt(req.getParameter("id"));
    Produto produto = new ProdutoDao().getProduto(id);
    req.setAttribute("produto", produto);
    return "altera-produto.jsp";
  }
  
}
