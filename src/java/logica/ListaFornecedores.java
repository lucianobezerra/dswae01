package logica;

import dao.FornecedorDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Fornecedor;

/**
 *
 * @author Luciano
 */
public class ListaFornecedores implements Logica{

  @Override
  public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
    List<Fornecedor> fornecedores = new FornecedorDao().getFornecedores();
    req.setAttribute("fornecedores", fornecedores);
    return "lista-fornecedores.jsp";
  }
  
}
