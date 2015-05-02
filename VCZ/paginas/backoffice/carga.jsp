<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="../../head.jsp" %>
</head>
<body>
<div class="full">
<div class="contenedor">
  
  	<%@include file="bannerbackoffice.jsp" %>
  	<%@include file="menubackoffice.jsp" %>
  	<%@include file="validatesession.jsp" %>
 
</div>
	<div class="contenido">
		
		<form action="../CargarPelicula.do" method="POST" enctype="multipart/form-data">
		
			<br>
			Archivo XML de peliculas:  <input type="file" name="fileXML" size="7">
			<br><br>
			Archivo ZIP de imagenes de peliculas: <input type="file" name="fileZIP" size="7">
			<br><br>
			<input type="submit" name="Ingresar" size="7">
			<br>
		</form>
	
	</div>
</div>
<%@include file="../../footer.jsp" %>
</body>
</html>