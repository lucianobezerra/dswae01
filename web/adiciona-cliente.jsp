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
    <h3>Cadastro de Cliente</h3>
    <form action="gravaCliente" method="post">
      <fieldset>
        <legend>Adicionar Cliente</legend>
        <label>Nome: </label><input type="text" name="nome" style="width: 300px;" /><br/>
        <label>Cpf:</label> <input type="text" name="cpf" style="width: 120px;"/><br/>
        <label>Uf:</label><input type="text" name="uf" style="width: 50px;"/><br/>
        <label>Cidade:</label><input type="text" name="cidade" style="width: 200px;" /><br/>
        <input type="submit" value="Gravar"/>
      </fieldset>
    </form>
  </body>
</html>