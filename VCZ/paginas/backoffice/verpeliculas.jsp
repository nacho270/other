<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-html.tld" prefix="html" %>
<%@ taglib uri="/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/struts-logic.tld" prefix="logic" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="../../head.jsp" %>
<script type="text/javascript" src="/video/js/ext-base.js">
</script>
<script type="text/javascript" src="/video/js/ext-all.js">
</script>
<!--  <script type="text/javascript" src="/video/js/ext-core.js">-->
<!-- </script>-->
<!-- <script type="text/javascript" src="/video/js/ext-all-debug.js">-->
<!-- </script>-->
<script type="text/javascript" src="/video/js/ext-get-peliculas.js">
</script>
<link rel="stylesheet" type="text/css" href="/video/js/ext_resources/css/ext-all.css"/>

<style type="text/css">
		div.pos_rel
		{
			position:absolute;
			top:170px;
			left:250px;
			background-color: #000000;
		}
	</style>

</head>
<body>
<div class="full">
<div class="contenedor">
  
  	<%@include file="bannerbackoffice.jsp" %>
  	<%@include file="menubackoffice.jsp" %>
  	<%@include file="validatesession.jsp" %>
 
</div>
	<div class="contenido">
	
	<center>
	<div id="registrar_discos_form">
    	<div id="registrar_discos_window" class="pos_rel"></div>
	</div>
	</center>
	
	<form action="Delete.do" method="POST">
		<table border="1" bordercolor="#B36118" align="center">
			<thead>
				<tr>
					<th> </th>
					<th>Codigo</th>
					<th>Nombre</th>
					<th>Genero</th>
					<th>Idioma</th>
					<th>Director</th>
					<th>Actores</th>
				</tr>
			</thead>
			<tbody>	
				<logic:iterate id="pelicula" name="ShowPeliculasForm" property="peliculas" >
					<tr>
						<td><input type="checkbox" value="unchecked" name="borrar"/></td>
						<td> 
							<label><bean:write name='pelicula' property='codigo' /> </label>
							<input type="hidden" name="codigos" value="<bean:write name='pelicula' property='codigo' />"/>
						</td>
						<td> <label><bean:write name='pelicula' property='nombre' /> </label></td>
						<td> <label><bean:write name='pelicula' property='genero.nombreGenero' /> </label></td>
						<td> <label><bean:write name='pelicula' property='idioma.nombreIdioma' /> </label></td>
						<td> <label><bean:write name='pelicula' property='director.nombreDirector' /> </label></td>
						<td> 
							<label>
								<logic:iterate id="actor" name="pelicula" property="actores" >
									<bean:write name='actor' property='nombreActor' /><br>
								</logic:iterate>
							</label>
						</td>
					</tr>
				</logic:iterate>
			</tbody>
		</table>
		<center><input type="submit" value="Borrar selecciondas"/></center>
	</form>
	</div>
</div>
<%@include file="../../footer.jsp" %>
</body>
</html>