<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="/odontopediatria/js/formulario.js"></script>
<script src="/odontopediatria/js/login/login.js"></script>
<link rel="stylesheet" href="../../css/style.css"/>
<link rel="stylesheet" href="../../css/login/login.css"/>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
 	<div class="header">Clínica sorriso do amanhã</div>
 	
	 <form id="formulario" class="container">

        <h1>Login</h1>
        <label for="login">CRM</label>
        <input type="text" name="login" class="input"/>
        <br/>
        
        <label for="senha">Senha</label>
        <input type="password" name="senha" class="input"/>
        <br>
        <div class="botoes">
            <button type="button" onclick="entrar('medicos')"> ENTRAR COMO ADMIN </button>
            <button type="button" onclick="entrar('pacientes')"> ENTRAR COMO MEDICO</button>
        </div>
    </form>
</body>
</html>