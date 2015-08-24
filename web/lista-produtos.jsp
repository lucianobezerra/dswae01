<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Listagem de Produtos</title>
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
    <h3>Listagem de Produtos</h3>
    <table>
      <tr>
        <th>Cod</th>
        <th>Fornecedor</th>
        <th>Descrição</th>
        <th>Unidade</th>
        <th>Valor</th>
        <th colspan="2" style="text-align: center">Ação</th>
      </tr>
      <c:forEach var="produto" items="${produtos}">
        <tr>
          <td>${produto.id}</td>
          <td>${produto.fornecedor.getRazao()}</td>
          <td>${produto.descricao}</td>
          <td>${produto.unidade}</td>
          <td>${produto.valor}</td>
          <td><a href="mvc?logica=AlteraProduto&id=${produto.id}">Editar</a></td>
          <td><a href="mvc?logica=RemoveProduto&id=${produto.id}">Excluir</a></td>
        </tr>
      </c:forEach>
    </table>
    <a href="mvc?logica=AdicionaProduto">Novo Produto</a><br/>
</html>
