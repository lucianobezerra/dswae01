<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <%
    //Destroi as sessions
      session.invalidate();
      out.println("<script>document.location.href='index.jsp';</script>");
    %>
  </body>
</html>
