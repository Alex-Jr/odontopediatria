package servlets;

import java.io.BufferedReader;
import java.io.IOException;

import beans.Medico;
import beans.Usuario;
import dao.MedicoDao;
import dao.UsuarioDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/medicos")
public class MedicoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String crm = request.getParameter("crm");
		String senha = request.getParameter("senha");
		
		Medico m = new Medico(0, nome, crm);
		
		MedicoDao.create(m);
		
		Usuario u = new Usuario();
		m.setId(MedicoDao.getLast());
		u.setInfo(crm);
		u.setSenha(senha);
		u.setMedico(m);
		
		UsuarioDao.create(u);
		
		response.sendRedirect(request.getContextPath() + "/views/medicos/index.jsp");
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedReader bfr  = request.getReader(); 

		String params[] = bfr.readLine().split("&");
		
		Medico m = new Medico();
		for(int i = 0; i < params.length; i++) {	
			String entry[] = params[i].split("=");

			if(entry.length == 1) continue;
			String key = entry[0];
			String value = entry[1];
			
			if(key.equals("id")) m.setId(Integer.parseInt(value));
			if(key.equals("nome")) m.setNome(value);
			if(key.equals("crm")) m.setCrm(value);
		}
		MedicoDao.update(m);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedReader bfr  = request.getReader(); 
		
		String params = bfr.readLine();	
		
		String entry[] = params.split("=");
		
		String key = entry[0];
		String value = entry[1];
		
		Medico m = new Medico();
		m.setId(Integer.parseInt(value));
		
		MedicoDao.delete(m);
	}

}
