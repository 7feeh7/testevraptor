<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>


<title>Insert title here</title>
</head>
<body>

<nav class="navbar navbar-default" role="navigation">
<div class="container">

<div class="navbar-header">
<a class="navbar-brand" href="#">
	<img alt="Brand" src="css/icon-tw.png" style="width:50px;height:50px;position:absolute;top:77%;margin-left:-45px;margin-top:-40px;">
</a>
<button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> 
	<span class="sr-only">Toggle navigation</span>
</button> 
<a class="navbar-brand" href="#">Twitter</a>
</div>

<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
<ul class="nav navbar-nav">
	<li class="active"><a href="#" icon="">Inicio</a></li>
	<li><a href="${linkTo[IndexController].logout}">Sair</a></li>
</ul>

<form class="navbar-form navbar-right" role="search">
	<div class="form-group"><input class="form-control" type="text" placeholder="Buscar no Twitter" /></div>
	<button class="btnS" type="submit">Pesquisar</button>
</form>

</div><!-- /.navbar-collapse -->
</div><!-- /.container --> 
</nav>
</body>
</html>