<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>Cadastro - Paciente</h2>
	
	<form action="/odontopediatria/pacientes" method="POST" id="cadastro">
		<label for="nome"> Nome: </label>
		<input type="text" name="nome" id="nome" required/> <br>
		
		<label for="data-nasc">Data de nascimento: </label>
		<input type="date" name="data-nasc" id="data-nasc" required/> <br>
		
		<label for="genero">Genero: </label>
		<input type="radio" name="sexo" value="M"/>Masculino
		<input type="radio" name="sexo" value="F" checked/>Feminino
		<br>
		
		<label for="nome-resp">Nome do responsável: </label>
		<input type="text" name="nome-resp" id="nome-resp" required/> <br>
		
		<label for="tel-resp">Telefone do responsável: </label>
		<input type="text" name="tel-resp" id="tel-resp" maxLength="11" required/> <br>

		<input type="submit"/>
	</form>
</body>
</html>