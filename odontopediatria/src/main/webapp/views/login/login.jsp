<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="/odontopediatria/js/formulario.js"></script>
<script src="/odontopediatria/js/login/login.js"></script>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<form id="formulario">
		<label for="login">CRM</label>
		<input type="text" name="login"/>
		<br>
		
		<label for="senha">Senha</label>
		<input type="text" name="senha"/>
		<br>

		<button type="button" onclick="entrar('medicos')"> ENTRAR MEDICOS </button>
		<button type="button" onclick="entrar('pacientes')"> ENTRAR PACIENTES</button>
	</form>
</body>
</html>