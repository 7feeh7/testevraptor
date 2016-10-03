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
function limite_textarea(valor){
	quant = 140;
	total = valor.length;
	if (total <= quant){
		resto = quant - total;
		document.getElementById('cont').innerHTML = resto;
	}else {
		document.getElementById('textarea').value = valor.substr(0,quant);
		}	
}</script>

</head>
<body>
<p class="bg-primary">${message}</p>
<%@ include file="../../../header.jsp"%>
<div class="panel panel-default">
  <div class="panel-body">
	 <form action="<c:url value="/publicar"/>" method="POST" class="form">
		<textarea id="textarea" name="twit.twit" placeholder="Oque você esta pensando?" onKeyDown="limite_textarea(this.value)" maxlength="140"></textarea></br>
		<input class="btnS" type="submit" style="right:60px;" value="Twiitar">
		<span id="cont" style="text-align:right;">140</span>
	</form>
	<table class="table table-condensed">
	  	<tbody>
	  	<c:forEach items="${publicacao}" var="twit">
			<tr style="">
				<td>${twit.twit}</td>
				<td style="color:rgb(136, 153, 166);">${twit.dataformat}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	</div>	
</div>
</body>
</html>