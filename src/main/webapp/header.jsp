<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
	
<link rel="stylesheet" href="<c:url value='/css/style.css' />"/>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>

</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top">
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
	<li><a href="${linkTo[IndexController].home}" icon="glyphicon glyphicon-console
	">Inicio</a></li>
	<li><a href="${linkTo[IndexController].list}" icon="">Usuarios</a></li>
	 <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Olá, ${userSession.user.name}<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="${linkTo[IndexController].logout}">Sair</a></li>
          </ul>
        </li>
</ul>
 <form class="navbar-form navbar-right">
     <div class="nav navbar-nav navbar-right">
            <form role="search" class="navbar-form">
                <div class="form-group has-feedback">
                    <input type="text" class="form-control" placeholder="Buscar" />
                    <span class="form-control-feedback glyphicon glyphicon-search"></span>
                </div>
            </form>
        </div>
  </form>   
</div><!-- /.navbar-collapse -->
</div><!-- /.container --> 
</nav>

</body>
</html>