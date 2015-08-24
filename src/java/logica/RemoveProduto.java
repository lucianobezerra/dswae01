package logica;

import dao.ProdutoDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Produto;

public class RemoveProduto implements Logica{

  @Override
  public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
    int id = Integer.parseInt(req.getParameter("id"));
    Produto produto = new Produto();
    produto.setId(id);
    ProdutoDao dao = new ProdutoDao();
    dao.remove(produto);
    System.out.println("Excluindo Produto");
    return "mvc?logica=ListaProdutos";
  }
  
}
