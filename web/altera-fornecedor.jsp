<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
    <h3>Cadastro de Fornecedor</h3>
    <form action="gravaFornecedor" method="post">
      <fieldset>
        <legend>Editar Fornecedor</legend>
        <input type="hidden" name="id" value="${fornecedor.id}" />
        <label>C�digo: ${fornecedor.id}</label>
        <label>Raz�o: </label><input type="text" name="razao" style="width: 300px;" value="${fornecedor.razao}" /><br/>
        <label>Cnpj:</label> <input type="text" name="cnpj" style="width: 100px;" value="${fornecedor.cnpj}"/><br/>
        <label>Uf:</label><input type="text" name="uf" style="width: 50px;" value="${fornecedor.uf}"/><br/>
        <label>Cidade:</label><input type="text" name="cidade" style="width: 200px;" value="${fornecedor.cidade}" /><br/>
        <input type="submit" value="Gravar"/>
      </fieldset>
    </form>
  </body>
</html>