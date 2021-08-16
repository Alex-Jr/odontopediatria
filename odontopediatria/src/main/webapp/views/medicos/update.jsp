<%@page import="dao.MedicoDao"%>
<%@page import="beans.Medico"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Medico</title>
<script src="/odontopediatria/js/formulario.js"> </script>
<script src="/odontopediatria/js/medicos/update.js"> </script>

<link rel="stylesheet" href="../../css/style.css"/>
<link rel="stylesheet" href="../../css/medicos/update.css"/>
</head>
<body>
	<% 
		String id = request.getParameter("id");
		Medico m = MedicoDao.get(Integer.parseInt(id));
	%>
	
	<div class="header">
 	
 		<div>Clínica sorriso do amanhã</div>
 	
 		<a href="/odontopediatria" class="voltar">Sair</a>	
 	</div>
 	
	
	<div class="container">
		<form action="/odontopediatria/medicos"  id="formulario"> <!-- Method PUT with JS -->
			<h2>Editar - Médico</h2>
			<input hidden="true" type="text" name="id" value="<%=id%>"/>
	
			<label for="nome"> Nome: </label>
			<input type="text" name="nome" id="nome" placeholder="<%=m.getNome()%>"/> <br>
			
			
			<label for="tel-resp">Crm: </label>
			<input type="text" name="crm" id="crm" placeholder="<%=m.getCrm()%>" maxLength="20"/> <br>
	
			<button type="button" onclick="update()" class="botaopadrao"> Confirmar </button>
			<button type="button" onclick="resetar()" class="botaopadrao"> Limpar </button>
		</form>
	</div>
	
</body>
</html>