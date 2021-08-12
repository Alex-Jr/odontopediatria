<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>Cadastro - Medico</h2>
	
	<form action="/odontopediatria/medicos" method="POST">
		<label for="nome"> Nome: </label>
		<input type="text" name="nome" id="nome"/> <br>
			
		<label for="crm">Crm: </label>
		<input type="text" name="crm" id="crm"/> <br>
		
		<input type="submit"/>
	</form>
</body>
</html>