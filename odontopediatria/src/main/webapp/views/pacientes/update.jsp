<%@page import="beans.Avatar"%>
<%@page import="dao.AvatarDao"%>
<%@page import="dao.PacienteDao"%>
<%@page import="beans.Paciente"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar paciente</title>
<script src="/odontopediatria/js/formulario.js"> </script>
<script src="/odontopediatria/js/pacientes/update.js"> </script>
</head>
<body>

	<h2>Editar - Paciente</h2>
	<% 
		String id = request.getParameter("id");
		Paciente p = PacienteDao.get(Integer.parseInt(id));
	%>
	
	<form action="/odontopediatria/pacientes" id="formulario"> <!-- Method PUT with JS -->
		<input hidden="true" type="text" name="id" value="<%=id%>"/>

		<label for="nome"> Nome: </label>
		<input type="text" name="nome" id="nome" placeholder="<%=p.getNome()%>"/> <br>
		
		<label for="data-nasc">Data de nascimento: </label>
		<input type="date" name="dataNasc" id="data-nasc" placeholder="<%=p.getDataNasc()%>"/> <br>
		
		<label for="genero">Genero: </label>
		<input type="radio" name="genero" value="M" <%=p.getSexo().equals("M") ? "checked" : ""%>/>Masculino
		<input type="radio" name="genero" value="F" <%=p.getSexo().equals("F") ? "checked" : ""%>/>Feminino
		<br>
		
		<label for="nome-resp">Nome do responsável: </label>
		<input type="text" name="nomeResp" id="nome-resp" placeholder="<%=p.getNomeResponsavel()%>"/> <br>
		
		<label for="tel-resp">Telefone do responsável: </label>
		<input type="text" name="telResp" id="tel-resp" placeholder="<%=p.getTelefoneResponsavel()%>" maxLength="11"/> <br>

		<button type="button" onclick="update()"> Confirmar </button>
		<button type="button" onclick="resetar()"> Limpar </button>
		<br>
		<% 
			Avatar a = AvatarDao.getByPacienteId(p.getId());
			if(a == null) {
		%>
			<a href="../avatares/new.jsp?idPaciente=<%=p.getId()%>"><button type="button" > Criar Avatar </button></a>
			<br>
		<%
			} else {
		%>
			<a href="../avatares/update.jsp?idAvatar=<%=a.getId()%>"><button type="button" > Editar Avatar </button></a>
			<br>
		<%
			}
		%>		
	</form>
</body>
</html>
