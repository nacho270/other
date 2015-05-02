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
		
		<table border="0" bordercolor="#B36118" align="center">
			<tr>
				<th scope="row">Codigo</th>
				<td> <label><bean:write name="BuscarPeliculaForm" property="pelicula.codigo" /> </label></td>
			</tr>
			
			<tr>
				<th scope="row">Nombre</th>
				<td> <label><bean:write name="BuscarPeliculaForm" property="pelicula.nombre" /> </label></td>
			</tr>
			
			<tr>
				<th scope="row">Genero</th>
				<td> <label><bean:write name="BuscarPeliculaForm" property="pelicula.genero.nombreGenero" /> </label></td>
			</tr>
			
			<tr>
				<th scope="row">Idioma</th>
				<td> <label><bean:write name="BuscarPeliculaForm" property="pelicula.idioma.nombreIdioma" /> </label></td>
			</tr>
			
			<tr>
				<th scope="row">Director</th>
				<td> <label><bean:write name="BuscarPeliculaForm" property="pelicula.director.nombreDirector" /> </label></td>
			</tr>
			
			<tr>
				<th scope="row">Actores</th>
				<td> 
					<label>
						<logic:iterate id="actor" name="BuscarPeliculaForm" property="pelicula.actores">
							<bean:write name="actor" property="nombreActor" /><br>
					  	</logic:iterate>
					</label>
				</td>
			</tr>
			
			<tr>
				<th scope="row">Sinopsis</th>
				<td><label><bean:write name="BuscarPeliculaForm" property="pelicula.sinopsis" /> </label></td>
			</tr>	
		</table>
	
		<center>
			<form action="/video/busquedas.jsp" name="frmVolver">
				<input type="submit" value="Volver" name="btnVolver" 
		    	   	   class="groovybutton" onMouseOver="goLite(this.form.name,this.name)"
		    	       onMouseOut="goDim(this.form.name,this.name)"/>
			</form>	
		</center>
	</div>
</div>
<%@include file="footer.jsp" %>
</body>
</html>