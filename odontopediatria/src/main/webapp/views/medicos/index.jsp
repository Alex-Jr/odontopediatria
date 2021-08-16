<%@page import="java.time.LocalDate"%>
<%@page import="dao.MedicoDao"%>
<%@page import="beans.Medico"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Medico</title>

<script src="/odontopediatria/js/medicos/delete.js"></script>
<link rel="stylesheet" href="../../css/style.css"/>
<link rel="stylesheet" href="../../css/medicos/index.css"/>

</head>
<body>
 	<% ArrayList<Medico> medicos = MedicoDao.list(); %>
	<div class="container">

    <a href="./new.jsp"><button type="button" value="">Cadastrar Médico</button></a>
    <h1>Lista de Médicos:</h1>
    <table>
    <tr>
      <td> ID </td>
      <td> Nome </td>
      <td> Crm </td> 
    </tr>
    
    <% for(int i = 0; i < medicos.size(); i++ ) { %>
    <% Medico m = medicos.get(i); %>
    <tr>
      <td> <%= m.getId() %> </td>
      <td> <%= m.getNome() %></td>
      <td> <%= m.getCrm() %> </td>
      <td>
        <a href="./update.jsp?id=<%=m.getId()%>"><button type="button">Editar</button></a>
        <button type="button">Avaliar</button>
        <button type="button" onclick="deletar(<%= m.getId() %>)">Excluir</button>
      </td>
    </tr>
    <% } %>   
  	</table>
  	</div>
</body>
</html>