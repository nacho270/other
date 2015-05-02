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

	<logic:empty name="BuscarPeliculaForm" property="directores">
		<logic:empty name="BuscarPeliculaForm" property="pels">
			<logic:notEmpty name="BuscarPeliculaForm" property="actores">
				<label>Actores:</label><br>
					<logic:iterate id="actor" name="BuscarPeliculaForm" property="actores">
						<form action="Buscar.do" method="POST" name="frmactores">
								<label> <bean:write name="actor" property="nombreActor"/> </label>
								<input type="hidden" name="select" value="peliculasActor">
								<input type="hidden" name="input"  value="<bean:write name='actor' property='nombreActor'/>">
								<input type="submit" value="Ver Peliculas" name="btnVer" 
							    	    class="groovybutton" onMouseOver="goLite(this.form.name,this.name)"
							    	    onMouseOut="goDim(this.form.name,this.name)"/>	
						<br>
					</logic:iterate>
			</logic:notEmpty>
		</logic:empty>
	</logic:empty>
	
	<logic:empty name="BuscarPeliculaForm" property="actores">
		<logic:empty name="BuscarPeliculaForm" property="pels">
			<logic:notEmpty name="BuscarPeliculaForm" property="directores">
				<label>Directores:</label><br>
					<logic:iterate id="director" name="BuscarPeliculaForm" property="directores">
							<form action="Buscar.do" method="POST" name="frmdir">
								<label> <bean:write name="director" property="nombreDirector"/> </label>
								<input type="hidden" name="select" value="peliculasDirector">
								<input type="hidden" name="input"  value="<bean:write name='director' property='nombreDirector'/>">
								<input type="submit" value="Ver Peliculas" name="btnVer" 
							    	    class="groovybutton" onMouseOver="goLite(this.form.name,this.name)"
							    	    onMouseOut="goDim(this.form.name,this.name)"/>
							</form>
						<br>
					</logic:iterate>
			</logic:notEmpty>
		</logic:empty>
	</logic:empty>
	
	<logic:empty name="BuscarPeliculaForm" property="actores">
		<logic:empty name="BuscarPeliculaForm" property="directores">
			<logic:notEmpty name="BuscarPeliculaForm" property="pels">
				<logic:iterate id="pel" name="BuscarPeliculaForm" property="pels">
							<form action="BuscarPelicula.do" method="POST" name="frmpel">
								<label> <bean:write name="pel" property="nombre"/> </label>
								<input type="hidden" name="nombre" value="<bean:write name='pel' property='nombre'/>">
								<input type="hidden" name="codigo" value="<bean:write name='pel' property='codigo'/>">
								<input type="submit" value="Ver Pelicula" name="btnVer" 
							    	    class="groovybutton" onMouseOver="goLite(this.form.name,this.name)"
							    	    onMouseOut="goDim(this.form.name,this.name)"/>
							</form>
						<br>
				</logic:iterate>
			</logic:notEmpty>
		</logic:empty>
	</logic:empty>
				
	<logic:empty name="BuscarPeliculaForm" property="directores">
		<logic:empty name="BuscarPeliculaForm" property="actores">
			<logic:empty name="BuscarPeliculaForm" property="pels">
				<label>No se han encontrado resultados</label>
			</logic:empty>
		</logic:empty>
	</logic:empty>

</div>
</div>
<%@include file="footer.jsp" %>
</body>
</html>