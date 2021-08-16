<%@page import="beans.Paciente"%>
<%@page import="dao.PacienteDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="/odontopediatria/js/avatares/desenharAvatar.js"></script>
<script src="/odontopediatria/js/avatares/new.js"></script>
<link rel="stylesheet" href="../../css/style.css"/>
<link rel="stylesheet" href="../../css/avatares/new.css"/>
<title>Novo avatar</title>
</head>
<body>
	<% 
		String id = request.getParameter("idPaciente");
		Paciente p = PacienteDao.get(Integer.parseInt(id));
	%>
	<div class="header">Clínica Sorriso do amanhã</div>

	<div class="container">
		<h2>Criar - Avatar</h2>
		
		<div id="avatar"></div>
		<!--  https://avatarmaker.com/ -->
		<form action="/odontopediatria/avatares" method="POST">
			<input hidden="true" name="idPaciente" value="<%=id%>" />		
			
			<div class="botoes"> 
				<label for="corPele"> Cor da pele </label>
				<input type="color" name="corPele" id="corPele"/>
				<br/><br/>
		
				<label for="corOlho"> Cor do olho </label>
				<input type="color" name="corOlho" id="corOlho"/>
				<br/><br/>
				
				<button type="button" onclick="update('rosto')">Trocar Rosto</button>
				<button type="button" onclick="update('boca')">Trocar Boca</button>
				<button type="button" onclick="update('nariz')">Trocar Nariz</button>
				<button type="button" onclick="update('cabelo')">Trocar Cabelo</button>
				<button type="button" onclick="update('olho')">Trocar Olho</button>
				<button type="button" onclick="update('orelha')">Trocar Orelha</button>
				<button type="button" onclick="update('sobrancelha')">Trocar Sobrancelha</button>
				<button type="button" onclick="update('roupa')">Trocar Roupa</button>
			</div>
			
			<input hidden=true id="rostoInput" name="rosto" value="1"/>
			<input hidden=true id="bocaInput" name="boca" value="1"/>
			<input hidden=true id="narizInput" name="nariz" value="1"/>
			<input hidden=true id="cabeloInput" name="cabelo" value="1"/>
			<input hidden=true id="olhoInput" name="olho" value="1"/>
			<input hidden=true id="orelhaInput" name="orelha" value="1"/>
			<input hidden=true id="sobrancelhaInput" name="sobrancelha" value="1"/>
			<input hidden=true id="roupaInput" name="roupa" value="1"/>
			<div id="genero" data-genero= "<%=p.getSexo().toLowerCase()%>"/>
			
			<button type="submit" class="salvar"> Salvar </button>
		</form>
	</div>
</body>
</html>