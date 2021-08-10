package servlets;


import java.io.IOException;
import java.util.ArrayList;

import beans.Paciente;
import dao.PacienteDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PacienteServlet
 */
@WebServlet("/pacientes")
public class PacienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public PacienteServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Paciente> pacientes = PacienteDao.list();
		
		request.setAttribute("pacientes", pacientes);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/pacientes/index.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nome = request.getParameter("nome");
		String genero = request.getParameter("genero");
		String nomeResponsavel = request.getParameter("nome-resp");
		String dataNasc = request.getParameter("data-nasc");
		
//		Paciente p = new Paciente(nome, genero, nomeResponsavel, dataNasc);
		
//		System.out.println(p.getNome());
		
		response.sendRedirect(request.getContextPath() + "/home.html");
		
		
	}

}
