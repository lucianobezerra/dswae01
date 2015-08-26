<%@page import="model.Usuario"%>
<!DOCTYPE html>
<html>
  <head>
    <title>A SOELETROS - Sistema de Vendas</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="dswae01.css">
    <link rel="stylesheet" type="text/css" href="css_menu.css">
    <script src="jquery.js"></script>
    <script type="text/javascript">
      $(document).ready(function () {
        $('#cssmenu').load('menu.html');
      });
    </script>
  </head>
  
    <%
      if (session.getValue("usuario") != null) {
        out.print("<div id='cssmenu'></div>");
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        String user = usuario.getUsuario();
        out.print("Bem vindo " + user);
      } else{
        out.println("<script>document.location.href='login.html';</script>");
      }
    %>
    
  
</html>
