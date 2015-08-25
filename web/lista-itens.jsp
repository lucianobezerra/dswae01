<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Listagem de Items</title>
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
    <h4>Dados da Venda</h4>
    <table>
      <tr>
        <td>Cód</td>
        <td>Cliente</td>
        <td>Data</td>
        <td>Qtde Itens</td>
        <td>Valor Total</td>
      </tr>
      <tr>
        <td>${venda.id}</td>
        <td>${venda.cliente.getNome()}</td>
        <td><fmt:formatDate value="${venda.data.time}" pattern="dd/MM/yyyy" /></td>
        <td>${venda.quantidade}</td>
        <td><fmt:formatNumber type="currency" maxFractionDigits="2" value="${venda.valor}" /></td>
      </tr>
    </table>
    <table>
      <tr>
        <th>Item</th>
        <th>Descrição</th>
        <th>Quantidade</th>
        <th>Valor Unitário</th>
        <th>Valor Total</th>
        <th colspan="2" style="text-align: center">Ação</th>
      </tr>
      <c:forEach var="item" items="${itens}" varStatus="line">
        <tr>
          <td>${line.count}</td>
          <td>${item.produto.getDescricao()}</td>
          <td style="text-align: center">${item.quantidade}</td>
          <td style="text-align: right"><fmt:formatNumber type="currency" maxFractionDigits="2" value="${item.valor}" /></td>
          <td style="text-align: right"><fmt:formatNumber type="currency" maxFractionDigits="2" value="${item.total}" /></td>
          <td><a href="mvc?logica=AlteraItem&id&=${item.id}">Editar</a></td>
          <td><a href="mvc?logica=RemoveItem&id=${item.id}&venda_id=${venda.id}">Excluir</a></td>
        </tr>
      </c:forEach>
    </table>
    <a href="mvc?logica=AdicionaItem&venda_id=${venda.id}">Novo Item</a><br/>
</html>
