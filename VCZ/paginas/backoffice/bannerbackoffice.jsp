  <div class="bannerbackoffice">
	  	<p>&nbsp;</p>
	  	<p>&nbsp;</p>
	  	<p>&nbsp;</p>
	  	<p>&nbsp;</p>
	  	<center>
	  		<%
	  				String a = (String)session.getAttribute("user");
	  				if(a!=null)
	  				{
	  					%>
	  					<label>Usuario: <%=session.getAttribute("user")%></label>
	  				<%}
	  		%>
	  		</center>
  </div>