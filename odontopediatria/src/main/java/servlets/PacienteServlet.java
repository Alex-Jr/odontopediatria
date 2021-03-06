package servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

import beans.Paciente;
import dao.PacienteDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/pacientes")
public class PacienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nome = request.getParameter("nome");
		String sexo = request.getParameter("sexo");
		String nomeResponsavel = request.getParameter("nome-resp");
		String telResponsavel = request.getParameter("tel-resp");

		Date dataNasc = null;
		try {
			dataNasc = new SimpleDateFormat("yyyy-mm-dd").parse(request.getParameter("data-nasc"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Paciente p = new Paciente(0, nome, sexo, dataNasc, nomeResponsavel, telResponsavel); 
		
		PacienteDao.create(p);

		response.sendRedirect(request.getContextPath() + "/views/pacientes/index.jsp");		
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		BufferedReader bfr  = request.getReader(); 
		
		String params[] = bfr.readLine().split("&");
		
		Paciente p = new Paciente();
		for(int i = 0; i < params.length; i++) {	
			String entry[] = params[i].split("=");

			if(entry.length == 1) continue;
			String key = entry[0];
			String value = entry[1];
			
			if(key.equals("id")) p.setId(Integer.parseInt(value));
			if(key.equals("nome")) p.setNome(value);
			if(key.equals("dataNasc")) p.setDataNasc(value);
			if(key.equals("genero")) p.setSexo(value);
			if(key.equals("nomeResp")) p.setNomeResponsavel(value);
			if(key.equals("telResp")) p.setTelefoneResponsavel(value);
		}
		PacienteDao.update(p);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedReader bfr  = request.getReader(); 
		
		String params = bfr.readLine();	
		
		String entry[] = params.split("=");
		
		String key = entry[0];
		String value = entry[1];
		
		Paciente p = new Paciente();
		p.setId(Integer.parseInt(value));
		
		PacienteDao.delete(p);		
	}
}
