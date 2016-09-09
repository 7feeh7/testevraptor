<%@page contentType="text/html; charset=UTF-8"%>
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


</head>
<body>
	${message}

	<form action="${linkTo[UsuarioController].Salvar}" class="form-inline">
	<div class="form-group">
		<input type="text" name="usuario.nome" class="form-control" placeholder="Digite seu Nome">
	</div>
	<div class="form-group">
		<input type="email" name="usuario.email" class="form-control" placeholder="Digite seu E-mail">
	</div>
	<div class="form-group">
		<input type="password" name="usuario.senha" class="form-control" placeholder="Digite sua Senha">
	</div>
	
		<button type="submit" class="btn btn-default">Cadastre-se</button>
		
	</form>


	<%@ include file="../../../footer.jsp"%>
</body>
</html>