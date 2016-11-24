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
	
<link rel="stylesheet" href="<c:url value='/css/style.css' />" />

<script type="text/javascript">
	function limite_textarea(valor) {
		quant = 140;
		total = valor.length;
		if (total <= quant) {
			resto = quant - total;
			document.getElementById('cont').innerHTML = resto;
		} else {
			document.getElementById('textarea').value = valor.substr(0, quant);
		}
	}
</script>

</head>
<body>
	<%@ include file="../../../header.jsp"%>
	<div class="alert alert-danger"
		style="height: relative; width: 370px; position: absolute; right: 10px; margin-top: -15px; background: #fff; border: 1px solid rgb(225, 232, 237); color: black;">
		<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
		${etsteasdadas}
	</div>
	<div class="panel panel-default">
		<div class="panel-body">

			<div class="row">
				<div class="thumbnail">
					<div class="caption">
						<form action="<c:url value="/publicar"/>" method="POST"
							class="form">
							<textarea id="textarea"
								style="width: 545px; height: 120px; resize: none; border: 1px #ddd solid;"
								name="twit.twit" placeholder="Oque você esta pensando?"
								onKeyDown="limite_textarea(this.value)" maxlength="140" required>
							</textarea>
							<br /> <input class="btnS" type="submit" style="right: 60px;"
								value="Publicar"> <span id="cont"
								style="text-align:right;">140</span>
						</form>
					</div>
				</div>
			</div>

			<div class="row">
				<c:forEach items="${teste}" var="twit">
					<div class="thumbnail">
						<div class="caption">
							<h4>${twit.name}</h4>
							<p style="color: rgb(136, 153, 166); text-align: right;">${twit.dataformat}</p>
							<p>${twit.twit}</p>
							<div class="stream-item-footer">
								<hr size="1" style="border: 1px solid rgb(225, 232, 237); border-radius: 4px;" />
								<p>
									<a href="#" class="glyphicon glyphicon-thumbs-up"></a> 
									<a href="#" class="glyphicon glyphicon-comment" style="left: 5%;" role="button"></a>
								</p>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<!-- fim da classe body -->
	</div>
	<!-- fim da classe default -->

	<div class="container fixed-top"
		style="background: #fff; width: 290px; height: relative; left: 74%; border: 1px solid rgb(225, 232, 237); border-radius: 4px; margin-bottom: 10px; top: 75px; position: absolute;">
		<h4 class="text-left">Seguindo</h4>
		<div class="list-group">
			<c:forEach items="${listaSeguindo}" var="Seguir">
				<button type="button" class="list-group-item">${Seguir.name}</button>

			</c:forEach>
		</div>
	</div>
	<!-- fim da classe container -->

</body>
</html>