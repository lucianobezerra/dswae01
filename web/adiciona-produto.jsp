<%@page import="dao.FornecedorDao"%>
<%@page import="model.Fornecedor"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="dswae01.css">
    <link rel="stylesheet" type="text/css" href="css_menu.css">
    <script src="jquery.js"></script>
    <script type="text/javascript">
      $(document).ready(function () {
        $('#cssmenu').load('menu.html');
        $('input[name=fornecedor_id]').blur(function() {
          var id = $(this).val();
          $.get('mvc?logica=PegaFornecedor', {id: id}, function(response){
            if(response){
              $('#nome_fornecedor').text(response).css("color", "#000");
            } else{
              $('#nome_fornecedor').text('FORNECEDOR NÃO LOCALIZADO').css("color", "red");
            }
          });
        });
      });
    </script>
  </head>
  <body>
    <div id="cssmenu"></div>
    <h3>Cadastro de Produtos</h3>
    <form action="gravaProduto" method="post">
      <fieldset>
        <legend>Adicionar Produto</legend>
        <label>Fornecedor: </label><input type="text" name="fornecedor_id" style="width: 80px;" />
        <span id="nome_fornecedor"></span><br/>
        <label>Descrição:</label> <input type="text" name="descricao" style="width: 300px;"/><br/>
        <label>Unidade:</label><input type="text" name="unidade" style="width: 120px;"/><br/>
        <label>Valor:</label><input type="text" name="valor" style="width: 200px;" /><br/>
        <input type="submit" value="Gravar"/>
      </fieldset>
    </form>
  </body>
</html>