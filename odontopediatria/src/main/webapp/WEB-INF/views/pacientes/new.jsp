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
	
	<form action="paciente" method="POST">
		<label for="nome"> Nome: </label>
		<input type="text" name="nome" id="nome"/> <br>
		
		<label for="genero">Genero: </label>
		<input type="radio" name="genero" value="M"/>Masculino
		<input type="radio" name="genero" value="F"/>Feminino
		<br>
		
		<label for="nome-resp">Nome do responsável: </label>
		<input type="text" name="nome-resp" id="nome-resp"/> <br>
		
		<label for="data-nasc">Data de nascimento: </label>
		<input type="date" name="data-nasc" id="data-nasc"/> <br>
		
		<input type="submit"/>
	</form>
</body>
</html>