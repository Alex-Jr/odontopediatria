<%@page import="dao.PacienteDao"%>
<%@page import="dao.AvaliacaoDao" %>
<%@page import="beans.Avaliacao" %>
<%@page import="beans.Paciente"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Histórico de consultas</h1>
<% int id = Integer.parseInt(request.getParameter("id")); %>
<% ArrayList<Avaliacao> avaliacoes = AvaliacaoDao.list(id); %>

<%for(int i =0; i < avaliacoes.size(); i++) { %>

<% Avaliacao av = avaliacoes.get(i);%>
<table>
    <tr>
      <td> ID </td>
      <td> Data </td>
      <td> Medico </td>
      <td> Paciente </td>
      <td> Ansiedade </td>
       
    </tr>
	<tr>
		<td> <%= av.getId() %> </td>
		<td> <%= av.getData() %> </td>
		<td> <%= av.getMedico().getNome() %> </td>
		<td> <%= av.getPaciente().getNome() %> </td>
		<td> <%= av.getAnsiedade() %> </td>
	</tr>
</table>
<% } %>

</body>
</html>