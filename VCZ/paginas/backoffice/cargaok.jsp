<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-html.tld" prefix="html" %>
<%@ taglib uri="/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/struts-logic.tld" prefix="logic" %> 
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
</div>
<div class="contenido">
<label>
Se cargaron correctamente:
<br>
<%= request.getAttribute("files") %>
</label>
</div>
</div>
<%@include file="../../footer.jsp" %>

</body>
</html>