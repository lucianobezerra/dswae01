<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Listagem de Fornecedores</title>
    <link rel="stylesheet" type="text/css" href="dswae01.css">
    <link rel="stylesheet" type="text/css" href="css_menu.css">
    <script src="jquery.js"></script>
    <script type="text/javascript">
      $(document).ready(function () {
        $('#cssmenu').load('menu.html');
        $('.delete').click(function () {
          if (confirm('Are you sure?')) {
            alert('excluir');
          }
          return false;
        });
      });
    </script>
  </head>
  <body>
    <div id="cssmenu"></div>
    <h3>Listagem de Fornecedores</h3>
    <table>
      <tr>
        <th>Cod</th>
        <th>Razão</th>
        <th>Cnpj</th>
        <th>Uf</th>
        <th>Cidade</th>
        <th colspan="2" style="text-align: center">Ação</th>
      </tr>
      <c:forEach var="fornecedor" items="${fornecedores}">
        <tr>
          <td>${fornecedor.id}</td>
          <td>${fornecedor.razao}</td>
          <td>${fornecedor.cnpj}</td>
          <td>${fornecedor.uf}</td>
          <td>${fornecedor.cidade}</td>
          <td><a href="mvc?logica=AlteraFornecedor&id=${fornecedor.id}">Editar</a></td>
          <td><a class="delete" href="mvc?logica=RemoveFornecedor&id=${fornecedor.id}">Excluir</a></td>
        </tr>
      </c:forEach>
    </table>
    <a href="mvc?logica=AdicionaFornecedor">Novo Fornecedor</a><br/>
</html>