<% 
	session.removeAttribute("login");
	session.invalidate();
	response.sendRedirect("index.jsp");
%>