<%@page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
<head>
<title>bolsas - v1</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>

<link rel="stylesheet" href="<c:url value='/css/style.css' />"/>
<script type="text/javascript">
/* Máscaras ER */
function mascara(o,f){
    v_obj=o
    v_fun=f
    setTimeout("execmascara()",1)
}
function execmascara(){
    v_obj.value=v_fun(v_obj.value)
}
function mtel(v){
    v=v.replace(/\D/g,"");             //Remove tudo o que não é dígito
    v=v.replace(/^(\d{2})(\d)/g,"($1) $2"); //Coloca parênteses em volta dos dois primeiros dígitos
    v=v.replace(/(\d)(\d{4})$/,"$1-$2");    //Coloca hífen entre o quarto e o quinto dígitos
    return v;
}
function id( el ){
	return document.getElementById( el );
}
window.onload = function(){
	id('telefone').onkeyup = function(){
		mascara( this, mtel );
	}
}
</script>

<script type="text/javascript">
//adiciona mascara de data
function mascaraData( campo, e )
{
	var kC = (document.all) ? event.keyCode : e.keyCode;
	var data = campo.value;
	
	if( kC!=8 && kC!=46 )
	{
		if( data.length==2 )
		{
			campo.value = data += '/';
		}
		else if( data.length==5 )
		{
			campo.value = data += '/';
		}
		else
			campo.value = data;
	}
}
</script>

</head>
<body>
	<%@ include file="../../../header.jsp"%>
	<div class="panel panel-default">
		<div class="panel-body"
			style="border: 1px #ddd solid; border-radius: 4px;">
			<h4 class="text-center">Configurações da Conta</h4>
			<form action="<c:url value="/update"/>" name="formulario"
				class="form-group" enctype="multipart/form-data">
				<div class="form-group">
					<label for="exampleInputName2">Nome:</label> <input type="text"
						name="user.name" class="form-control"
						style="width: 210px; border: 1px solid #e1e8ed;"
						value="${userSession.user.name}" required />
				</div>
				<div class="form-group">
					<label for="exampleInputName2">Data de Nascimento:</label> <input
						type="text" name="user.data_nasc" class="form-control"
						id="outra_data" maxlength="10"
						onkeypress="mascaraData( this, event)"
						style="width: 210px; border: 1px solid #e1e8ed;"
						value="${userSession.user.data_nasc}" placeholder="dd/mm/aaaa"/>
				</div>
				<div class="form-group">
					<label for="exampleInputName2">Email:</label> <input type="email"
						name="user.email" class="form-control"
						style="width: 210px; border: 1px solid #e1e8ed;"
						value="${userSession.user.email}" required />
				</div>
				<div class="form-group">
					<label for="exampleInputName2">Telefone / Celular:</label> <input
						type="tel" name="user.fone" class="form-control"
						style="width: 210px; border: 1px solid #e1e8ed;"
						value="${userSession.user.fone}" id="telefone"
						onKeypress="mascTel(formulario.fone)" value="() -" maxlength="15"
						placeholder="() -" />
				</div>
				<div class="form-group">
					<label for="exampleInputName2">Senha:</label> <input
						type="password" name="user.password" id="telefone"
						class="form-control"
						style="width: 210px; border: 1px solid #e1e8ed;"
						value="${userSession.user.password}" required />
				</div>
				<button type="submit" class="btnS">Alterar</button>
			</form>
		</div>

	</div>
</body>
</html>