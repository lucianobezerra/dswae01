package logica;

import dao.FornecedorDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Fornecedor;

public class RemoveFornecedor implements Logica{

  @Override
  public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
    long id = Long.parseLong(req.getParameter("id"));
    Fornecedor fornecedor = new Fornecedor();
    fornecedor.setId(id);
    FornecedorDao dao = new FornecedorDao();
    dao.remove(fornecedor);
    System.out.println("Excluindo Fornecedor");
    return "mvc?logica=ListaFornecedores";
  }
  
}
