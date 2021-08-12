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
</head>
<body>
  <a href="./new.jsp"><button type="button" value="">Cadastrar Médico</button></a>
  <h1>Lista de Médicos</h1>
  
  <% ArrayList<Medico> medicos = MedicoDao.list(); %>
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
        <button type="button">Editar</button>
        <button type="button">Avaliar</button>
        <button type="button">Excluir</button>
      </td>
    </tr>
    <% } %>
  </table>
</body>
</html>