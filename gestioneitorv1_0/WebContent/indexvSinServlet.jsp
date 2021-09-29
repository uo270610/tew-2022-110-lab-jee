<%@ page contentType="text/html" %>
<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>

<jsp:useBean id="alumnos" class="com.tew.presentation.GestioneitorBean" scope="page"/>

<html>
<head>
<title>Piloto de TEW</title>
</head>
<body>
<h1>Gestioneitor!</h1>
<br>
<h2>Aplicación de gestión de alumnos</h2>
<br>
<br>
Listado de alumnos:
<br>
<table>
	<tr>
		<td><b>Nombre</b></td>
		<td><b>Apellidos</b></td>
		<td><b>Identificador</b></td>
		<td><b>EMail</b></td>
	</tr>

<c:forEach var="alumno" items="${alumnos.listado}">
	<tr>
		<td><c:out value="${alumno.nombre}"/></td>
		<td><c:out value="${alumno.apellidos}"/></td>
		<td><c:out value="${alumno.iduser}"/></td>
		<td><c:out value="${alumno.email}"/></td>
	</tr>
</c:forEach>

</table>
<br>
<br>
</body>
</html>
