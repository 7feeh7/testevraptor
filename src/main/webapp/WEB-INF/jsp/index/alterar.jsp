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
  <div class="panel-body" style="border: 1px #ddd solid;border-radius: 4px;">
      <center><h4>Configurações da conta</h4></center>
  <form action="<c:url value="/update"/>" class="form-group">
  <div class="form-group">
    <label for="exampleInputName2">Nome:</label>
    <input type="text" name="user.name"  class="form-control" style="width:210px;border: 1px solid #e1e8ed;" value="${userSession.user.name}"/>
  </div>
  <div class="form-group">
    <label for="exampleInputName2">Email:</label>
    <input type="email" name="user.email" class="form-control" style="width:210px;border: 1px solid #e1e8ed;" value="${userSession.user.email}"/>
  </div>
  <div class="form-group">
    <label for="exampleInputName2">Senha:</label>
    <input type="password" name="user.password" class="form-control" style="width:210px;border: 1px solid #e1e8ed;" value="${userSession.user.password}"/>
  </div>
  <button type="submit" class="btnS">Alterar</button>
  </form>
 </div>
  
</div>
</body>
</html>