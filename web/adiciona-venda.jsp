<%@page import="dao.FornecedorDao"%>
<%@page import="model.Fornecedor"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="dswae01.css">
    <link rel="stylesheet" type="text/css" href="css_menu.css">
    <script src="jquery.js"></script>
    <script type="text/javascript">
      $(document).ready(function () {
        $('#cssmenu').load('menu.html');
        $('input[name=cliente_id]').blur(function() {
          var id = $(this).val();
          $.get('mvc?logica=PegaCliente', {id: id}, function(response){
            if(response){
              $('#nome_cliente').text(response).css("color", "#000");
            } else{
              $('#nome_cliente').text('CLIENTE NÃO LOCALIZADO').css("color", "red");
            }
          });
        });
      });
    </script>
  </head>
  <body>
    <div id="cssmenu"></div>
    <h3>Cadastro de Venda</h3>
    <form action="gravaVenda" method="post">
      <fieldset>
        <legend>Adicionar Venda</legend>
        <label>Cliente: </label><input type="text" name="cliente_id" style="width: 80px;" />
        <span id="nome_cliente"></span><br/>
        <jsp:useBean id="now" class="java.util.Date"/>    
        <label>Data:</label> <input type="text" name="data" value="<fmt:formatDate value="${now}" pattern="dd/MM/yyyy" />" style="width: 120px;"/><br/>
        <label>Quantidade:</label><input type="text" name="quantidade" style="width: 120px;" disabled="disabled"/><br/>
        <label>Valor:</label><input type="text" name="valor" style="width: 120px;" disabled="disabled" /><br/>
        <input type="submit" value="Gravar"/>
      </fieldset>
    </form>
  </body>
</html>