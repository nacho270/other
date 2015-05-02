<%
  		try
  		{	
	        String label = session.getAttribute("login").toString();
		  	
	        if(label!=null)
	        {
	        	if(label.equalsIgnoreCase("no"))
	        	{
	        		response.sendRedirect("index.jsp");
	        	}
			}
	        else
	        {
	        	response.sendRedirect("index.jsp");
	        }
	        
  		}
  		catch(Exception e)
  		{
  			response.sendRedirect("index.jsp");
  		}
	%>