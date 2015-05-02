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
<body onload="fillCombos()">
<div class="full">
<div class="contenedor">
  
  	<%@include file="banner.jsp" %>
  	<%@include file="menu.jsp" %>
</div>
<div class="contenido">
<br>
<form name="frmBusq" action="Buscar.do" method="POST">
	<table border="1" bordercolor="#98F38D" align="center">
		<tr>
			<td><label>Buscar por: </label>
				<select name="select" onchange="setBusqueda()">
					<option value=" "> </option>
					<option value="actor">Actor</option>
					<option value="director">Director</option>
					<option value="numero">Numero</option>
					<option value="idioma">Idioma</option>
					<option value="genero">Genero</option>
					<option value="nombre">Nombre</option>
				</select>
				<div id="busqueda"></div> 
				<input type="submit" value="Buscar" name="btnBusq" 
					    	   class="groovybutton" onMouseOver="goLite(this.form.name,this.name)"
					    	   onMouseOut="goDim(this.form.name,this.name)"/>
			</td>
		</tr>
	</table>
	<br><br><br>
</form>

<!-- <br><br>
<table border="1" bordercolor="#B36118" align="center">
	<tr>
		<td>
			<form action="BuscarPelicula.do" method="POST" name="frmNumero">
			Numero: <input type="text" name="codigo" size="10"/>
				    <input type="submit" value="Buscar" name="btnNumero" 
				    	   class="groovybutton" onMouseOver="goLite(this.form.name,this.name)"
				    	   onMouseOut="goDim(this.form.name,this.name)"/>
			</form>
		</td>
		
		<td>
			<form action="BuscarActoresYDirectores.do" method="POST" name="frmDirector">
			Director: <input type="text" name="directorInput" size="10"/>
				    <input type="submit" value="Buscar" name="btnDirector" 
				    	   class="groovybutton" onMouseOver="goLite(this.form.name,this.name)"
				    	   onMouseOut="goDim(this.form.name,this.name)"/>
			</form>
		</td>
		
		<td>
			<form action="BuscarPelicula.do" method="POST" name="frmIdioma">
			Idioma:	<select id="cmbIdioma" name="idioma">
					</select>
					<input type="submit" value="Buscar" name="btnIdioma" 
				    	   class="groovybutton" onMouseOver="goLite(this.form.name,this.name)"
				    	   onMouseOut="goDim(this.form.name,this.name)"/>
			</form>
		</td>
		
		<td>
			<form action="BuscarPelicula.do" method="POST" name="frmGenero">
			Genero: <select id="cmbGenero" name="genero">
					</select>
					<input type="submit" value="Buscar"name="btnGenero" 
				    	   class="groovybutton" onMouseOver="goLite(this.form.name,this.name)"
				    	   onMouseOut="goDim(this.form.name,this.name)"/>
			</form>
		</td>
		
		<td>
			<form action="BuscarPelicula.do" method="POST" name="frmNombre">
			Nombre: <input type="text" name="nombre" size="10"/>
					<input type="submit" value="Buscar"name="btnNombre" 
				    	   class="groovybutton" onMouseOver="goLite(this.form.name,this.name)"
				    	   onMouseOut="goDim(this.form.name,this.name)"/>
			</form>
		</td>
		
		<td>
			<form action="BuscarActoresYDirectores.do" method="POST" name="frmActor">
			Actor: <input type="text" name="actorInput" size="10"/>
				   <input type="submit" value="Buscar"name="btnActor" 
				    	   class="groovybutton" onMouseOver="goLite(this.form.name,this.name)"
				    	   onMouseOut="goDim(this.form.name,this.name)"/>
			</form>
		</td>
	</tr>
</table>
 -->
</div>
</div>
<%@include file="footer.jsp" %>
</body>
</html>