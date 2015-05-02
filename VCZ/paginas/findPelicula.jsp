<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-html.tld" prefix="html" %>
<%@ taglib uri="/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/struts-logic.tld" prefix="logic" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="head.jsp" %>
</head>
<body>
<div class="full">
<div class="contenedor">
  
  	<%@include file="banner.jsp" %>
  	<%@include file="menu.jsp" %>
</div>
<div class="contenido">
<logic:empty name="BuscarPeliculaForm" property="pels">
	<logic:notEmpty name="BuscarPeliculaForm" property="pelicula">
		<center>
			<label> Codigo: <bean:write name="BuscarPeliculaForm" property="pelicula.codigo"/></label>
			<label> Nombre: <bean:write name="BuscarPeliculaForm" property="pelicula.nombre"/></label>
		</center>
	</logic:notEmpty>
</logic:empty>

<logic:empty name="BuscarPeliculaForm" property="pelicula">
	<logic:notEmpty name="BuscarPeliculaForm" property="pels">
		<center>
			<ul>
				<logic:iterate id="pelicula" name="BuscarPeliculaForm" property="pels">
					<li>
						Sinopsis: <bean:write name='pelicula' property='sinopsis' />
					</li>
				</logic:iterate>
			</ul>
		<center>
	</logic:notEmpty>
</logic:empty>

<logic:empty name="BuscarPeliculaForm" property="pels">
	<logic:empty name="BuscarPeliculaForm" property="pelicula">
		<center>
			<label>No hay una verga</label>
		<center>			
	</logic:empty>
</logic:empty>

</div>
</div>
<%@include file="footer.jsp" %>
</body>
</html>