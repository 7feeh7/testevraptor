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


</head>
<body>
<%@ include file="../../../header.jsp"%>
<div class="panel panel-default">
  <div class="panel-body" style="border:1px solid rgb(225, 232, 237);border-radius: 4px;">

	<table class="table table-condensed">
	  <h3 style="size: 14px;">Talvez voçê conheça</h3>
	  	<tbody>
	  	<c:forEach items="${listaUser}" var="user">
			<tr style="">
				<td>${user.name}</td>
				<td><a href="seguir?id=${user.id}">Seguir</a></td>				
			</tr>
		</c:forEach>
		</tbody>
	</table>
	</div>
</div>
</body>
</html>