<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Inicia sesión
	<form:form action="/login" method="POST" modelAttribute="usuario">
		<form:label path="correo">Correo: </form:label>
		<form:input type="email" path="correo"/>
		<br>
		<form:label path="contrasena">Contraseña: </form:label>
		<form:input type="password" path="contrasena"/>
		<br>
		<input type="submit" value="Entrar">
	</form:form>
	<br>
	<a href="/registrar" >Crear cuenta</a>
</body>
</html>