<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>TODO supply a title</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<script
	src="//ajax.googleapis.com/ajax/libs/prototype/1.7.1.0/prototype.js"></script>
<script
	src="//ajax.googleapis.com/ajax/libs/scriptaculous/1.9.0/scriptaculous.js"></script>
<script src="js/utilidades.js" type="text/javascript"
	language="javascript"></script>
<script type="text/javascript" language="javascript"></script>

<script>
	var obj;

	function completar() {
		new Ajax.Autocompleter("dato", "lista", "servletAutoCompletarTitulo", {
			paramName : "texto",
			minChars : 1
		});
	}

	function cargarLibros() {
		obj = new ObjetoAJAX();
		obj.enviar("servletLibrosPorTitulo?dato="
				+ document.getElementById("dato").value, "get",
				"procesaLibros", null);
	}

	function procesaLibros() {
		var libros = eval("(" + obj.respuestaTexto() + ")");
		var tablaHTML = "<table border = '1'>";
		tablaHTML += "<tr>";
		tablaHTML += "<th>ISBN</th>";
		tablaHTML += "<th>TITULO</th>";
		tablaHTML += "<th>PRECIO</th>";
		tablaHTML += "<th>DESCRIPCION</th>";
		tablaHTML += "</tr>";

		for (var elem = 0; elem < libros.length; elem++) {
			tablaHTML += "<tr>";
			tablaHTML += "<td>" + libros[elem].isbn + "</td>";
			tablaHTML += "<td>" + libros[elem].titulo + "</td>";
			tablaHTML += "<td>" + libros[elem].precio + "</td>";
			tablaHTML += "<td>" + libros[elem].descripcion + "</td>";
			tablaHTML += "</tr>";
		}

		tablaHTML += "</table>";
		document.getElementById("listado").innerHTML = tablaHTML;
	}
</script>
</head>
<body onload="completar();">
	<section>
	<form id="miForm" action="javascript:cargarLibros();">
		<div class="label">
			<label>Introduce el título completo o palabras contenidas en
				el título: </label>
		</div>
		<input type="text" id="dato" size="100"> <input type="submit"
			value="Aceptar">

		<div id="lista"></div>


	</form>
	</section>

	<section>
		<br></br>
		<br></br>
		<br></br>
		<div class="label">
			<label>Listado libros: </label>
		</div>
		<div class="textarea">
			<div id="listado" />
		</div>
	</section>
	
	<br></br>
	<a href="buscarEditorial.jsp" target="_self"> <input type="button"
		name="boton" value="Buscar Editorial" />
	</a>
	<a href="index.jsp" target="_self"> <input type="button"
		name="boton" value="Buscar Autor" />
	</a>
</body>
</html>