<%@page import="beans.Medico"%>
<%@page import="dao.MedicoDao"%>
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
<title>Avaliação</title>
<script src="/odontopediatria/js/avatares/desenharAvatar.js"></script>
<script src="/odontopediatria/js/avaliacoes/new.js"></script>
<link rel="stylesheet" href="../../css/style.css"/>
<link rel="stylesheet" href="../../css/avaliacoes/new.css"/>
</head>
<body>
	<% 
		String idPaciente = request.getParameter("idPaciente");
		String idMedico = request.getParameter("idMedico");
		Medico medico = MedicoDao.get(Integer.parseInt(idMedico));
		Paciente paciente = PacienteDao.get(Integer.parseInt(idPaciente));
		Avatar avatar = AvatarDao.getByPacienteId(paciente.getId());
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
		data-id-avatar=<%=avatar.getId() %>
		data-id-paciente=<%=paciente.getId() %>
		data-genero=<%=paciente.getSexo().toLowerCase() %>
		data-id-medico=<%=medico.getId() %>
	>
	</div>
	<div class="header">Clínica sorriso do amanhã</div>
	 
	<div class="container">
		<h2>Nova Avaliação</h2>
		 <div class="aaaaa">

            <div id="avatar"></div>
            
            <div class="expressoes">
                <div id="expressao1" class="box" onclick="selecionar(this)"></div>
                
                <div id="expressao2" class="box" onclick="selecionar(this)"></div>
                
                <div id="expressao3" class="box" onclick="selecionar(this)"></div>
                
                <div id="expressao4" class="box" onclick="selecionar(this)"></div>	
            </div>
        </div>
	</div>
	
	
	<form action="/odontopediatria/avaliacoes" method="POST" id="avaliacao"> <!-- Method PUT with JS -->
		<input hidden="true" type="text" name="idPaciente" value="<%=paciente.getId()%>"/>
		<input hidden="true" type="text" name="idMedico" value="<%=medico.getId()%>"/>
		<input hidden="true" type="text" name="expressoes" value="0" id="expressoes"/>
	</form>
</body>
</html>