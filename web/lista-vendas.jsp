<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Listagem de Vendas</title>
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
    <h3>Listagem de Vendas</h3>
    <table>
      <tr>
        <th>Cod</th>
        <th>Cliente</th>
        <th>Data</th>
        <th>Qtde itens</th>
        <th>Valor Total</th>
        <th colspan="3" style="text-align: center">Ação</th>
      </tr>
      <c:forEach var="venda" items="${vendas}">
        <tr>
          <td>${venda.id}</td>
          <td>${venda.cliente.getNome()}</td>
          <td><fmt:formatDate value="${venda.data.time}" pattern="dd/MM/yyyy" /></td>
          <td>${venda.quantidade}</td>
          <td>${venda.valor}</td>
          <td><a href="#">Editar</a></td>
          <td><a href="mvc?logica=RemoveVenda&id=${venda.id}">Excluir</a></td>
          <td><a href="mvc?logica=ListaItens&venda_id=${venda.id}"><img src="btn_items.jpg" title="Ver Itens" /></a></td>
        </tr>
      </c:forEach>
    </table>
    <a href="mvc?logica=AdicionaVenda">Nova Venda</a><br/>
</html>
