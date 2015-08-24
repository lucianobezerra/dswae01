<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
  <head>
    <title>SO ELETROS</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="dswae01.css">
    <link rel="stylesheet" type="text/css" href="css_menu.css">
    <script src="jquery.js"></script>
    <script type="text/javascript">
      $(document).ready(function () {
        $('#cssmenu').load('menu.html');
        $('input[name=produto_id]').blur(function() {
          var txtName  = $('#nome_produto');
          var txtValue = $('input[name=valor]');
          var id = $(this).val();
          $.get('mvc?logica=PegaProduto', {id: id}, function(response){
            txtName.text(null);
            txtValue.val(null);
            if(response !== '{}'){
              var product = eval('(' + response + ')');
              txtName.text(product.nome_produto).css("color", "#000");
              txtValue.val(eval(product.valor)).css("color", "#000");
            } else{
              $('#nome_produto').text('PRODUTO NÃO LOCALIZADO').css("color", "red");
            }
          });
        });
      });
    </script>
  </head>
  <body>
    <div id="cssmenu"></div>
    <h3>Inclusão de Item</h3>
    <form action="gravaItem" method="post">
      <fieldset>
        <legend>Adicionar Item</legend>
        <input type="hidden" name="venda_id" value="${venda_id}" />
        <label>Produto: </label><input type="text" name="produto_id" style="width: 80px;" />
        <span id="nome_produto"></span><br/>
        <label>Quantidade:</label><input type="text" name="quantidade" style="width: 120px;"/><br/>
        <label>Valor:</label><input type="text" name="valor" style="width: 120px;"  /><br/>
        <input type="submit" value="Gravar"/>
      </fieldset>
    </form>
  </body>
</html>