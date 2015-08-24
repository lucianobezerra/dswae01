package logica;

import dao.ClienteDao;
import dao.VendaDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Venda;

@WebServlet(name = "GravaVenda", urlPatterns = {"/gravaVenda"})
public class GravaVenda extends HttpServlet {

  protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    String id         = request.getParameter("id");
    String cliente_id = request.getParameter("cliente_id").toUpperCase();
    String dataTexto  = request.getParameter("data");
    Calendar data = null;
    try {
      Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataTexto);
      data = Calendar.getInstance();
      data.setTime(date);
    } catch (ParseException e) {
      out.println("Erro na conversão da data");
      return;
    }

    Venda venda = new Venda();
    
    venda.setData(data);
    venda.setCliente(new ClienteDao().getCliente(Integer.valueOf(cliente_id)));
    venda.setQuantidade(0);
    venda.setValor(0.00);
    VendaDao dao = new VendaDao();
    if (id == null) {
      dao.adiciona(venda);
    } else {
      venda.setId(Integer.valueOf(id));
      dao.altera(venda);
    }
    RequestDispatcher rd = request.getRequestDispatcher("mvc?logica=ListaVendas");
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
