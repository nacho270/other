<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="head.jsp" %>
</head>
<body onLoad="fillPeliculas()">
<div class="full">
<div class="contenedor">
  <%@include file="banner.jsp" %>
  <%@include file="menu.jsp" %>
</div>
<div class="contenido">

<br><br><br>
<center>Nuevos estrenos!</center><br>
<div id="pels">

</div>
<br>
<br>
<br>
<br>
<br>
</div>
</div>
<%@include file="footer.jsp" %>
</body>
</html>