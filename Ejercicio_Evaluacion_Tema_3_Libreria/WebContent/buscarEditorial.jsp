<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EJERCICIO DE EVALUACION TEMA 3. BUSCAR EDITORIALES.</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<script src="js/utilidades.js" type="text/javascript" language="javascript"></script>
<script type="text/javascript" language="javascript">

	var obj;
	
	function cargarEditoriales() {
		obj = new ObjetoAJAX();
		obj.enviar("servletEditorial", "get", "procesaEditoriales", null);
	}

	function cargarLibros() {
		obj = new ObjetoAJAX();
		obj.enviar("servletLibrosPorEditorial", "get", "procesaLibros", document.forms[0]);
	}

	function procesaEditoriales() {
		var editoriales = eval("(" + obj.respuestaTexto() + ")");
		var lista = document.getElementById("editorial");

		var item = document.createElement("option");
		item.setAttribute("value", 0);
		var texto = document.createTextNode("Seleccione una editorial");
		item.appendChild(texto);
		lista.appendChild(item);
		
		for (var elem = 0; elem < editoriales.length; elem++) {
			var item = document.createElement("option");
			item.setAttribute("value", editoriales[elem].id);
			var texto = document.createTextNode(editoriales[elem].nombre);
			item.appendChild(texto);
			lista.appendChild(item);
		}
	}

	function procesaLibros() {

		var resp = obj.respuestaXML();	
        var datos_libro = resp.getElementsByTagName("datos_libro");
        var elementos = datos_libro.item(0).childNodes;
        var tablaHTML = "<table border='1'>";
			        
        tablaHTML += "<tr>";
        
        for(var i=0; i<elementos.length; i++){
	        tablaHTML += "<th>" + datos_libro[0].childNodes[i].nodeName + "</th>";
        } 
        tablaHTML += "</tr>";
        
        tablaHTML += "<tr>";
        
        for(var i=0; i<datos_libro.length; i++){
        	for(var h=0; h<elementos.length; h++){
            	tablaHTML += "<td>" +  datos_libro[i].childNodes[h].firstChild.nodeValue + "</td>";
        	}      	
        	tablaHTML += "</tr>";   
        }      
        tablaHTML += "</table>";

        document.getElementById("listado").innerHTML = tablaHTML;    
	}
	
</script>
</head>
<body>
<body onLoad="cargarEditoriales()">

	<section>
	<form>
		<div class="label">
			<label>Elige una editorial:</label>
		</div>
		<div class="select">
			<select id="editorial" name="editorial" onchange="cargarLibros()"></select>
		</div>
	</form>
	</section>
	
	<br></br>
	<div class="label">
		<label>Listado libros: </label>
	</div>
	<div class="textarea">
		<div id="listado" />
	</div>

	<br></br>	
	<a href="index.jsp" target="_self"> <input type="button" name="boton" value="Buscar Autores" /> </a>	

	<a href="buscarTitulo.jsp" target="_self"> <input type="button" name="boton" value="Buscar Titulo" /> </a>	

</body>
</html>