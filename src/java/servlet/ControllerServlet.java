package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Logica;

@WebServlet("/mvc")
public class ControllerServlet extends HttpServlet {

  protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String param = request.getParameter("logica");
    String nomeDaClasse = "logica." + param;
    try{
      Class classe = Class.forName(nomeDaClasse);
      Logica logica = (Logica) classe.newInstance();
      String pagina = logica.executa(request, response);
      request.getRequestDispatcher(pagina).forward(request, response);
    }catch(Exception e){
      throw new ServletException("A lógica de negócios causou uma exceção", e);
    }
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
