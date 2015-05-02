<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="../../head.jsp" %>
</head>
<body OnLoad="javascript:document.forms['login'].userName.focus();">
<div class="full">
<div class="contenedor">
  
  	<%@include file="bannerbackoffice.jsp" %>
  	<%@include file="menubackoffice.jsp" %>
</div>
<div class="contenido">

<form action="../Login.do" method="post" name="login"> <!-- ver el tema del direccionamiento de los .do.
														Con la / no anda, probar con ../ y con ../../.
														Chequear struts config tambien.
														sino volver atras todo y meter un index.jsp en
														backoffice que forwardee al login en la raiz -->

<br>
Usuario: 
<input type="text" name="userName" size="10">
<br><br>
Password: 
<input type="password" name="password" size="10">

<br><br>
<input type="submit" name="Ingresar" value="Ingresar">
<br>

</form>

</div>
</div>
<%@include file="../../footer.jsp" %>
</body>
</html>