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
</head>
<body>

	<h2>Editar - Médico</h2>
	<% 
		String id = request.getParameter("id");
		Medico m = MedicoDao.get(Integer.parseInt(id));
	%>
	
	<form action="/odontopediatria/medicos" id="formulario"> <!-- Method PUT with JS -->
		<input hidden="true" type="text" name="id" value="<%=id%>"/>

		<label for="nome"> Nome: </label>
		<input type="text" name="nome" id="nome" placeholder="<%=m.getNome()%>"/> <br>
		
		
		<label for="tel-resp">Crm: </label>
		<input type="text" name="crm" id="crm" placeholder="<%=m.getCrm()%>" maxLength="20"/> <br>

		<button type="button" onclick="update()"> Confirmar </button>
		<button type="button" onclick="resetar()"> Limpar </button>
	</form>
</body>
</html>