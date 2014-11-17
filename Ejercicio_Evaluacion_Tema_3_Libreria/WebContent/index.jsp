<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EJERCICIO DE EVALUACION TEMA 3. BUSCAR AUTORES.</title>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<script src="js/utilidades.js" type="text/javascript"
	language="javascript"></script>
<script type="text/javascript" language="javascript">
	var obj;

	function cargarAutores() {
		obj = new ObjetoAJAX();
		obj.enviar("servletAutor", "get", "procesaAutores", null);
	}

	function cargarLibros() {
		obj = new ObjetoAJAX();
		obj.enviar("servletLibrosPorAutor", "post", "procesaLibros", document.forms[0]);
	}

	function procesaAutores() {
		var autores = eval("(" + obj.respuestaTexto() + ")");
		var lista = document.getElementById("autor");

		var item = document.createElement("option");
		item.setAttribute("value", 0);
		var texto = document.createTextNode("Seleccione un autor");
		item.appendChild(texto);
		lista.appendChild(item);
		
		for (var elem = 0; elem < autores.length; elem++) {
			var item = document.createElement("option");
			item.setAttribute("value", autores[elem].id);
			var texto = document.createTextNode(autores[elem].nombre);
			item.appendChild(texto);
			lista.appendChild(item);
		}
	}

	function procesaLibros() {
		var libros = eval("(" + obj.respuestaTexto() + ")");
		var tablaHTML = "<table border = '1'>";
		tablaHTML += "<tr>";
		tablaHTML += "<th>ISBN</th>";
		tablaHTML += "<th>TITULO</th>";
		tablaHTML += "<th>PRECIO</th>";
		tablaHTML += "</tr>";

		for (var elem = 0; elem < libros.length; elem++) {
			tablaHTML += "<tr>";
			tablaHTML += "<td>" + libros[elem].isbn + "</td>";
			tablaHTML += "<td>" + libros[elem].titulo + "</td>";
			tablaHTML += "<td>" + libros[elem].precio + "</td>";
			tablaHTML += "</tr>";
		}

		tablaHTML += "</table>";
		document.getElementById("listado").innerHTML = tablaHTML;
	}
</script>
</head>
<body onLoad="cargarAutores()">

	<section>
	<form>
		<div class="label">
			<label>Elige un Autor:</label>
		</div>
		<div class="select">
			<select id="autor" name="autor" onchange="cargarLibros()"></select>
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
	<a href="buscarEditorial.jsp" target="_self"> <input type="button" name="boton" value="Buscar Editorial" /> </a>	

	<a href="buscarTitulo.jsp" target="_self"> <input type="button" name="boton" value="Buscar Titulo" /> </a>	
</body>
</html>