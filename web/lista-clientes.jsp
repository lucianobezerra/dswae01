<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Listagem de Clientes</title>
    <link rel="stylesheet" type="text/css" href="dswae01.css">
    <link rel="stylesheet" type="text/css" href="css_menu.css">
    <script src="jquery.js"></script>
    <script type="text/javascript">
      $(document).ready(function(){
        $('#cssmenu').load('menu.html');
      });
    </script>
  </head>
  <body>
    <div id="cssmenu"></div>
    <h3>Listagem de Clientes</h3>
    <table>
      <tr>
        <th>Cod</th>
        <th>Nome</th>
        <th>Cpf</th>
        <th>Uf</th>
        <th>Cidade</th>
        <th colspan="2" style="text-align: center">Ação</th>
      </tr>
      <c:forEach var="cliente" items="${clientes}">
        <tr>
          <td>${cliente.id}</td>
          <td>${cliente.nome}</td>
          <td>${cliente.cpf}</td>
          <td>${cliente.uf}</td>
          <td>${cliente.cidade}</td>
          <td><a href="mvc?logica=AlteraCliente&id=${cliente.id}">Editar</a></td>
          <td><a href="mvc?logica=RemoveCliente&id=${cliente.id}">Excluir</a></td>
        </tr>
      </c:forEach>
    </table>
    <a href="mvc?logica=AdicionaCliente">Novo Cliente</a><br/>
</html>
