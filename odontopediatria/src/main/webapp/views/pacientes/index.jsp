<%@page import="java.time.LocalDate"%>
<%@page import="dao.PacienteDao"%>
<%@page import="beans.Paciente"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="/odontopediatria/js/pacientes/delete.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <a href="./new.jsp"><button type="button" value="">Cadastrar Paciente</button></a>
  <h1>Lista de Pacientes</h1>
  
  <% ArrayList<Paciente> pacientes = PacienteDao.list(); %>
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
        <button type="button">Avaliar</button>
      </td>
    </tr>
    <% } %>
  </table>
</body>
</html>