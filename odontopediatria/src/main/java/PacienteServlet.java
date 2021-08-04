

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import odontopediatria.Paciente;

/**
 * Servlet implementation class PacienteServlet
 */
@WebServlet("/paciente")
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
		
		Paciente p = new Paciente(nome, genero, nomeResponsavel, dataNasc);
		
		System.out.println(p.getNome());
		
		response.sendRedirect(request.getContextPath() + "/home.html");
		
		
	}

}
