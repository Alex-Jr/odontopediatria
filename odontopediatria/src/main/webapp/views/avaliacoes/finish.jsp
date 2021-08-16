<%@ page import="dao.PacienteDao" %>
<%@ page import="dao.MedicoDao" %>

<%@ page import="beans.Paciente" %>
<%@ page import="beans.Medico" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fim da avaliação</title>
<link rel="stylesheet" href="../../css/style.css"/>
<link rel="stylesheet" href="../../css/avaliacoes/finish.css"/>
</head>
<body>
	<div class="container">
		<% String ansiedade = request.getParameter("ansiedade"); %>
		
		<% 
		int pacienteID = Integer.parseInt(request.getParameter("pacienteID"));
		Paciente p = PacienteDao.get(pacienteID); 
		
		int medicoID = Integer.parseInt(request.getParameter("medicoID"));
		Medico m = MedicoDao.get(medicoID);
		%>
		<h2> Fim de avaliação</h2>
		<h3>Paciente: <%= p.getNome() %></h3>
		<h3>Médico responsável: <%= m.getNome() %></h3>
		<h3>Nível de ansiedade: <%= ansiedade %></h3>
		<a href="../pacientes/index.jsp"><button type="button" class="botaopadrao">Finalizar</button></a>
	</div>
	
</body>
</html>