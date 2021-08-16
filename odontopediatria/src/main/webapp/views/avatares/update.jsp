<%@page import="beans.Avatar"%>
<%@page import="dao.AvatarDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="/odontopediatria/js/avatares/desenharAvatar.js"></script>
<script src="/odontopediatria/js/avatares/update.js"></script>
<script src="/odontopediatria/js/formulario.js"></script>
<link rel="stylesheet" href="../../css/style.css"/>
<link rel="stylesheet" href="../../css/avatares/update.css"/>

<title>Editar avatar</title>
</head>
<body>
		<div class="header">Clínica Sorriso do amanhã</div>
	<% 
		String id = request.getParameter("idAvatar");
		Avatar avatar = AvatarDao.get(Integer.parseInt(id));
	%>
	
	<div 
		id="dados" 
		data-id-avatar=<%=avatar.getId() %>
		data-cor-pele=<%=avatar.getCorPele() %>
		data-cor-olho=<%=avatar.getCorOlho()%>
		data-orelha=<%=avatar.getOrelha()%>
		data-olho=<%=avatar.getOlho()%>
		data-rosto=<%=avatar.getRosto()%>
		data-sobrancelha=<%=avatar.getSobrancelha()%>
		data-boca=<%=avatar.getBoca()%>
		data-nariz=<%=avatar.getNariz()%>
		data-roupa=<%=avatar.getRoupa()%>
		data-cabelo=<%=avatar.getCabelo()%>
		data-id-paciente=<%=avatar.getPaciente().getId() %>
		data-genero=<%=avatar.getPaciente().getSexo().toLowerCase() %>
	>
	</div>
	
	<div class="container">
	<h2>Editar - Avatar</h2>
	<!--  https://avatarmaker.com/ -->
		
	<div id="avatar" style="width:500px;height:500px;position:relative">
	</div>
	
	<form action="/odontopediatria/avatares" id="formulario">
		<input hidden="true" name="idAvatar" value="<%=id%>" />		
		
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
		
		<button type="button" onclick="salvar()"> Salvar </button>
	</form>
	</div>
</body>
</html>