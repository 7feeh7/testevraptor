<%@page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<link href="css/style.css" rel="stylesheet">
  <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
<div class="alert alert-danger" style="height:50px;width:370px;position:absolute;right:10px;margin-top:-15px;display:none;">
  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  <strong>Danger!</strong> ${warningerro}.
</div>
<form action="<c:url value="/validarUser"/>" method="POST" class="form-inline">
  <div class="form-group">
    <label class="sr-only" for="exampleInputEmail3">Email address</label>
    <input type="email" name="user.email" class="form-control" placeholder="E-mail">
  </div>
  <div class="form-group">
    <label class="sr-only" for="exampleInputPassword3">Password</label>
    <input type="password" name="user.password" class="form-control" placeholder="Senha">
  </div>
  <button type="submit" class="btn" style="width:90px;border: 1px solid #fff;">Entrar</button>
</form>
<hr size="1" style="border: 1px solid #DBDBDB;" />

<div class="WelcomeB">
   <dl>
    <dt>Compartilhe oque gosta</dt>
    <dd>compartilhe com todos seus amigos fotos, videos e musicas.</dd>
  </dl>
  <dl>
    <dt>Conheça novas pessoas</dt>
    <dd>Adicione novas pessoas com os mesmos interesses e gostos.</dd>
  </dl>
  <dl>
    <dt>Faça tudo isso com segurança</dt>
    <dd>garantimos que todos seus dados e mensagens sejam protegidos etc.</dd>
  </dl>
</div>

<form action="<c:url value="/salvar"/>" class="form-horizontal" method="POST">
<div class="row">
<div class="col-lg-4 col-lg-offset-7">
<h2 class="titulo">Cadastre-se</h2>
<div class="form-group">
<div class="col-sm-8">	   
		<input type="text" name="user.name" value="${user.name}" class="form-control" placeholder="Digite seu Nome">
</div>
	</div>
	<div class="form-group">
	<div class="col-sm-8">
		<input type="email" name="user.email" class="form-control" placeholder="Digite seu E-mail">
	</div>
	</div>
	<div class="form-group">
	<div class="col-sm-8">
		<input type="password" name="user.password" class="form-control" placeholder="Digite sua Senha">
	</div>
	</div>
	<div class="col-sm-">
	<button type="submit" class="btn" style=".btn:hover{border: 1px solid #222222;}">Cadastre-se</button>
	</div>
</div>
</div>
</form>

</body>
</html>