<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastrar medico</title>
<link rel="stylesheet" href="../../css/style.css"/>
<link rel="stylesheet" href="../../css/medicos/new.css"/>
</head>
<body>

	<div class="header">
 	
 		<div>Clínica sorriso do amanhã</div>
 	
 		<a href="/odontopediatria" class="voltar">Sair</a>	
 	</div>
 	
	

	<div class="container">
		
	<form action="/odontopediatria/medicos" method="POST">
		<h1>Cadastro - Médicos </h1>
		<label for="nome"> Nome: </label>
		<input type="text" name="nome" id="nome"/> <br>
			
		<label for="crm">Crm : </label>
		<input type="text" name="crm" id="crm"/> <br>
		
		<label for="senha">Senha </label>
		<input type="password" name="senha" id="senha"/> <br>
		
		<input type="submit"/>
	</form>
	</div>
</body>
</html>
