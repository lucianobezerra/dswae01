<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Filtro Produtos Vendidos</title>
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
    <h3>Defina o Filtro</h3>
    <form action="listaProdutoVendido" method="post">
      <fieldset>
        <legend>Intervalo</legend>
        <label>Data Inicial: </label><input type="text" name="data_inicial" style="width: 80px;" />
        <label>Data Final:</label><input type="text" name="data_final" style="width: 80px;" /><br/>
        <input type="submit" value="Enviar"/>
      </fieldset>
    </form>
</html>
