<%@page import="model.Usuario"%>
<%@page import="dao.UsuarioDao"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Sistema de Login :: JSP</title>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
  </head> 
  <body>
    <%
      String login_form = request.getParameter("login");
      String senha_form = request.getParameter("senha");
      Usuario usuario = new UsuarioDao().getUsuario(login_form, senha_form);
      if (usuario != null) {
        out.println("Logado com sucesso.");
        session.putValue("usuario", usuario);
        out.println("<script>document.location.href='index.jsp';</script>");
      } else {
        out.println("Login ou senha inválidos. <a href='login.html'>Voltar</a>");
      }
    %>
  </body>
</html>