<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bienvenido a la calculadora online</title>
</head>
<body>
	<fmt:message key="lenguaje"/> <a href="cambiarLenguajeController?siteLanguage=es"><fmt:message key="espanol"/></a>
									|<a href="cambiarLenguajeController?siteLanguage=en"><fmt:message key="ingles"/></a>
									|<a href="cambiarLenguajeController?siteLanguage=de"><fmt:message key="aleman"/></a>

	<!--<form action="${flowExecutionUrl}" method="POST">-->

	<form action="inicio.flow">
		<fmt:message key="firstNum"/><input type="text" name="firstNum" /><br>
				
		<fmt:message key="secondNum"/><input type="text" name="secondNum" /><br>
		
		<fmt:message key="operacion"/>
			  <select name="operacion" >
                   <option value="+"><fmt:message key="sumar"/>
                   <option value="-"><fmt:message key="restar"/>
                   <option value="x"><fmt:message key="multiplicar"/>
	      	       <option value="/"><fmt:message key="dividir"/>
	      	  </select>
              
         <input type="hidden" name="_eventId" value="toValidaCalc" />	          
         <input type="submit" value="Aceptar" />

</body>
</html>