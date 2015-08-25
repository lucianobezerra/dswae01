<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
  <head>
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
    <h3>Listagem de Vendas por Periodo</h3>
    <h4>Periodo: ${data1} a ${data2}</h4>
    <table>
      <tr>
        <th>Seq</th>
        <th>Cliente</th>
        <th>Cidade</th>
        <th>Data</th>
        <th>Qtde itens</th>
        <th>Valor Total</th>
      </tr>
      <c:forEach var="venda" items="${vendas}" varStatus="line">
        <c:set var="total" value="${total + venda.valor}" /> 
        <tr>
          <td>${line.count}</td>
          <td>${venda.cliente.getNome()}</td>
          <td>${venda.cliente.getCidade()}</td>
          <td><fmt:formatDate value="${venda.data.time}" pattern="dd/MM/yyyy" /></td>
          <td>${venda.quantidade}</td>
          <td style="text-align: right"><fmt:formatNumber type="currency" maxFractionDigits="2" value="${venda.valor}" /></td>
        </tr>
      </c:forEach>
        <tr>
          <td colspan="5" style="text-align: right">Total</td>
          <td style="text-align: right"><fmt:formatNumber type="currency" maxFractionDigits="2" value="${total}" /></td>
        </tr>
    </table>
</html>
