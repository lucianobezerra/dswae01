package logica;

import dao.ProdutoDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Produto;

/**
 *
 * @author Luciano
 */
public class ListaProdutos implements Logica{

  @Override
  public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
    List<Produto> produtos = new ProdutoDao().getProdutos();
    req.setAttribute("produtos", produtos);
    return "lista-produtos.jsp";
  }
  
}
