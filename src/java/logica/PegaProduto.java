package logica;

import dao.ProdutoDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import model.Produto;

/**
 *
 * @author Luciano
 */
public class PegaProduto implements Logica{

  @Override
  public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
    res.setContentType("application/json");
    int id = Integer.parseInt(req.getParameter("id"));
    JSONObject json = new JSONObject();
    ProdutoDao dao = new ProdutoDao();
    Produto produto = dao.getProduto(id);
    if(produto.getId() > 0){
      json.put("nome_produto", produto.getDescricao());
      json.put("valor", produto.getValor());
    }
    req.setAttribute("produto", json);
    return "pega_produto.jsp";
  }
  
}
