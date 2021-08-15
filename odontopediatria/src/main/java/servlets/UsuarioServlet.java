package servlets;

import java.io.BufferedReader;
import java.io.IOException;

import beans.Medico;
import beans.Usuario;
import dao.UsuarioDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/login")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UsuarioServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bfr  = request.getReader(); 
		
		String params[] = bfr.readLine().split("&");
		
		Usuario u = new Usuario();
		
		for(int i = 0; i < params.length; i++) {
			String entry[] = params[i].split("=");

			if(entry.length == 1) continue;
			String key = entry[0];
			String value = entry[1];
			
			if(key.equals("login")) u.setInfo(value);
			if(key.equals("senha")) u.setSenha(value);
		}
		
		Usuario newU = UsuarioDao.get(u);
		
		if(newU == null) {
			response.getWriter().append("");
		} else {
			response.getWriter().append(newU.toString());
		}
	}
}
