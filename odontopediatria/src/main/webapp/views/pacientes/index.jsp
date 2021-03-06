<%@page import="dao.AvatarDao"%>
<%@page import="beans.Avatar"%>
<%@page import="java.time.LocalDate"%>


<%@page import="dao.PacienteDao"%>

<%@page import="beans.Paciente"%>
<%@page import="beans.Medico"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="/odontopediatria/js/pacientes/delete.js"></script>
<link rel="stylesheet" href="../../css/style.css"/>
<link rel="stylesheet" href="../../css/pacientes/index.css"/>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
 <% ArrayList<Paciente> pacientes = PacienteDao.list(); %>
 
 <div class="header">
 	
 		<div>Clínica sorriso do amanhã</div>
 	
 		<a href="/odontopediatria" class="voltar">Sair</a>	
 	</div>
 	
 
<div class="container">
  <a href="./new.jsp"><button type="button" value="">Cadastrar Paciente</button></a>
  <h1>Lista de Pacientes</h1>
  
  <table>
    <tr>
      <td> ID </td>
      <td> Nome </td>
      <td> Data Nascimento </td>
      <td> Responsável </td>
      <td> Telefone </td>
      <td> Ações </td> 
    </tr>
    
  
    <% for(int i = 0; i < pacientes.size(); i++ ) { %>
    <% Paciente p = pacientes.get(i); %>
    <tr>
      <td> <%= p.getId() %> </td>
      <td> <%= p.getNome() %></td>
      <td> <%= p.getDataNasc() %> </td>
      <td> <%= p.getNomeResponsavel() %> </td>
      <td> <%= p.getTelefoneResponsavel() %> </td>
      <td>
        <a href="./update.jsp?id=<%=p.getId()%>"><button type="button">Editar</button></a>
        <button type="button" onclick="deletar(<%=p.getId()%>);">Deletar</button>
        <% 
			Avatar a = AvatarDao.getByPacienteId(p.getId());
			if(a == null) {
		%>
		 	<a href="../avatares/new.jsp?idPaciente=<%=p.getId()%>"> <button type="button">Avaliar</button> </a>
		<%
			} else {
		%>
			 <a href="../avaliacoes/new.jsp?idPaciente=<%=p.getId()%>&idMedico=1"> <button type="button">Avaliar</button> </a>
		<%
			}
		%>	

		<a href="./history.jsp?id=<%=p.getId()%>"><button type="button"> Histórico</button></a> 
       
      </td>
    </tr>
    <% } %>
    

  </table>
  
</div>
</body>
</html>
