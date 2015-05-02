var req;
var target;
var isIE;

function goLite(FRM,BTN)
{
   window.document.forms[FRM].elements[BTN].style.color = "#FFFF99";
   window.document.forms[FRM].elements[BTN].style.backgroundColor = "#11AAEE";
}

function goDim(FRM,BTN)
{
   window.document.forms[FRM].elements[BTN].style.color = "#EEFFFF";
   window.document.forms[FRM].elements[BTN].style.backgroundColor = "#0088DD";
}

function initRequest(url) 
{
    if (window.XMLHttpRequest) 
	{
        req = new XMLHttpRequest();
    } 
	else if (window.ActiveXObject) 
	{
        isIE = true;
        req = new ActiveXObject("Microsoft.XMLHTTP");
    }
}

function fillPeliculas()
{
	var url ="cargarpeliculas";
	initRequest(url);
	req.onreadystatechange = fillPeliculasRequest;
	req.open("POST", url, true); 
	req.send(null);
}

function fillPeliculasRequest()
{
	var div = document.getElementById("pels");
        
    if (req.readyState == 4) 
    {
        if (req.status == 200) 
        {
                
            var peliculas = req.responseXML.getElementsByTagName("pelicula");
            
            if(peliculas.length > 0)
            {
	              //var datos = "<ul>";
	              var datos = "<table border='1' align='center'  bordercolor='#98F38D'>"
	              
	              for (i = 0; i < peliculas.length; i++) 
	              {
		                 var nodes  = peliculas[i].childNodes;
		                 var codigo = nodes[0].childNodes[0].nodeValue;
		                 var nombre = nodes[1].childNodes[0].nodeValue;
		                 var fecha  = nodes[2].childNodes[0].nodeValue;
		                 var path   = nodes[3].childNodes[0].nodeValue;
		                 //datos += "<li>Codigo: " + codigo + " -   Nombre: " + nombre + "   Fecha:   " + fecha + "</li><br>Imagen: <img src='http://localhost:8080/img/" + path + "'/> ";
		                 datos += "<tr><td><a href='/video/BuscarPelicula.do?n=" + codigo + "'><img src='/img/" + path + "'/></a></td>";
		                 datos += "<td>Codigo: "     + codigo + "<br>Nombre: " + nombre + "<br>Fecha: " + fecha + "</td></tr>";		                 
	              }
	              //datos += "</ul>";
	              datos += "</table>";
	              div.innerHTML = datos;
            }
            else
            {
               div.innerHTML = "<center><label>No hay peliculas</label></center>";
            }          
        }
    }
    else
    {
		div.innerHTML = "<center><img src='img/loading.gif' /></center>"; 
    }
}


function fillCombos()
{
	var url ="cargardata";
	initRequest(url);
	req.onreadystatechange = fillcomboidiomas;
	req.open("POST", url, true); 
	req.send(null);
}

function setBusqueda()
{
	var div = document.getElementById("busqueda");
	var selection = window.document.forms["frmBusq"].elements["select"].options[window.document.forms["frmBusq"].elements["select"].selectedIndex].value;
	
	if(selection == "actor")
	{
		div.innerHTML = "Nombre: <input type='text' name='input' size='10'/>"
	}
	else if(selection == "director")
	{
		div.innerHTML = "Nombre: <input type='text' name='input' size='10'/>"
	}
	else if(selection == "numero")
	{
		div.innerHTML = "Numero: <input type='text' name='input' size='10'/>"
	}
	else if(selection == "idioma")
	{		
		var url ="cargaridiomas";
		initRequest(url);
		req.onreadystatechange = fillCmbIdiomas;
		req.open("POST", url, true); 
		req.send(null);
	}
	else if(selection == "genero")
	{
		var url ="cargargeneros";
		initRequest(url);
		req.onreadystatechange = fillCmbGeneros;
		req.open("POST", url, true); 
		req.send(null);	
	}
	else if(selection == "nombre")
	{
		div.innerHTML = "Nombre: <input type='text' name='input' size='10'/>"
	}
	else div.innerHTML = "";
}

function fillCmbIdiomas()
{
	var div = document.getElementById("busqueda");
	var datos = "Idioma: <select name='input'>";
	
	if (req.readyState == 4) 
    {
         if (req.status == 200) 
         {
              var idiomas = req.responseXML.getElementsByTagName("idioma"); 
              
              if(idiomas.length > 0)
              {
              		for(i = 0; i < idiomas.length; i++)
              		{
              			var nodes = idiomas[i].childNodes;
	              		var nombre = nodes[0].childNodes[0].nodeValue;
	              		datos += "<option value='" + nombre + "'>" + nombre + "</option>"
	              	}
	              	
	              	datos += "</select>";
	              	
	              	div.innerHTML = datos;
              }
          }
      }
}

function fillCmbGeneros()
{
	var div = document.getElementById("busqueda");
	var datos = "Genero: <select name='input'>";
	
	if (req.readyState == 4) 
    {
         if (req.status == 200) 
         {
              var idiomas = req.responseXML.getElementsByTagName("genero"); 
              
              if(idiomas.length > 0)
              {
              		for(i = 0; i < idiomas.length; i++)
              		{
              			var nodes = idiomas[i].childNodes;
	              		var nombre = nodes[0].childNodes[0].nodeValue;
	              		datos += "<option value='" + nombre + "'>" + nombre + "</option>"
	              	}
	              	
	              	datos += "</select>";
	              	
	              	div.innerHTML = datos;
              }
          }
      }
}

function fillcomboidiomas()
{
	var combo = document.getElementById("cmbIdioma");
	var array;
	var option;
	
	if (req.readyState == 4) 
    {
         if (req.status == 200) 
         {
              var idiomas = req.responseXML.getElementsByTagName("idioma"); 
              if(idiomas.length > 0)
              {
              		var size = idiomas.length;
              		arr = new Array(size);
              		
              		for(i = 0; i < idiomas.length; i++)
              		{
              			var nodes = idiomas[i].childNodes;
              			var nombre = nodes[0].childNodes[0].nodeValue;
              			arr[i] = nombre;
              		}
              		
              		for(i = 0; i<size;i++)
              		{
              			option = new Option(arr[i],arr[i]);
              			combo.options[i]=option;
              		}
              }
              
              var generos = req.responseXML.getElementsByTagName("genero"); 
              combo = document.getElementById("cmbGenero");
              if(generos.length > 0)
              {
              		var size = generos.length;
              		arr = new Array(size);
              		
              		for(i = 0; i<generos.length;i++)
              		{
              			var nodes = generos[i].childNodes;
              			var nombre = nodes[0].childNodes[0].nodeValue;
              			arr[i] = nombre;
              		}
              		
              		for(i = 0; i<size;i++)
              		{
              			option = new Option(arr[i],arr[i]);
              			combo.options[i]=option;
              		}
              }
		}
	}
}
