<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../../css/pacientes/new.css"/>
<link rel="stylesheet" href="../../css/style.css"/>
<title> Cadastro Paciente</title>
</head>
<body class="letras">

  <div class="header"> Sorriso do amanhã </div>  
   
    
    <form action="/odontopediatria/pacientes" method="POST" id="cadastro" class="container">
      <h2>Cadastro - Paciente</h2>
        <label for="nome"> Nome: </label>
        <input type="text" name="nome" id="nome" class="campotexto"required/> <br>
        
        <label for="data-nasc">Data de nascimento: </label>
        <input type="date" name="data-nasc" id="data-nasc" class="campotexto" required/> <br>
        
        <label for="genero">Genero: </label>
        <input type="radio" name="sexo" value="M"/>Masculino
        <input type="radio" name="sexo" value="F" checked/>Feminino<br>
        
        <label for="nome-resp">Nome do responsável: </label>
        <input type="text" name="nome-resp" id="nome-resp" class="campotexto" required/> <br>
        
        <label for="tel-resp">Telefone do responsável: </label>
        <input type="text" name="tel-resp" id="tel-resp" maxLength="11" class="campotexto" required/> <br>

        <input type="submit" class="botaopadrao"/>
    </form>
  </div>
</body>
</html>
