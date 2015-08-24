package logica;

import dao.ItemDao;
import dao.ProdutoDao;
import dao.VendaDao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Item;
import model.Venda;

@WebServlet(name = "GravaItem", urlPatterns = {"/gravaItem"})
public class GravaItem extends HttpServlet {

  protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    String id         = request.getParameter("id");
    String venda_id   = request.getParameter("venda_id");
    String produto_id = request.getParameter("produto_id");
    int quantidade    = Integer.valueOf(request.getParameter("quantidade"));
    double valor      = Double.parseDouble(request.getParameter("valor"));

    Venda venda = new VendaDao().getVenda(Integer.valueOf(venda_id));
    Item item = new Item();
    item.setVenda(venda);
    item.setProduto(new ProdutoDao().getProduto(Integer.valueOf(produto_id)));
    item.setQuantidade(quantidade);
    item.setValor(valor);
    item.setTotal(quantidade * valor);

    ItemDao dao = new ItemDao();
    if (id == null) {
      dao.adiciona(item);
      atualizaVenda(item);
    } else {
      item.setId(Integer.valueOf(id));
      dao.altera(item);
      atualizaVenda(item);
    }
    RequestDispatcher rd = request.getRequestDispatcher("mvc?logica=ListaItens");
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

  private void atualizaVenda(Item item) {
    Venda venda = item.getVenda();
    venda.setQuantidade(venda.getQuantidade() + item.getQuantidade());
    venda.setValor(venda.getValor() + item.getTotal());
    
    VendaDao dao = new VendaDao();
    dao.altera(venda);
  }

}
