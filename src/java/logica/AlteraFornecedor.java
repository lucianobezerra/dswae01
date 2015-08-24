package logica;

import dao.FornecedorDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Fornecedor;

public class AlteraFornecedor implements Logica{

  @Override
  public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
    int id = Integer.parseInt(req.getParameter("id"));
    Fornecedor fornecedor = new FornecedorDao().getFornecedor(id);
    req.setAttribute("fornecedor", fornecedor);
    return "altera-fornecedor.jsp";
  }
  
}
