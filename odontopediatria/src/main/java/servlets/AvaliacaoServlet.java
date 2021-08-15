package servlets;

import java.io.IOException;

import beans.Avaliacao;
import beans.Medico;
import beans.Paciente;
import dao.AvaliacaoDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AvaliacaoServlet
 */
@WebServlet("/avaliacoes")
public class AvaliacaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AvaliacaoServlet() {
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
		String idMedico = request.getParameter("idMedico");
		String idPaciente = request.getParameter("idPaciente");
		String expressoes = request.getParameter("expressoes");
		
		Avaliacao a = new Avaliacao();
		Medico m = new Medico();
		m.setId(Integer.parseInt(idMedico));
		Paciente p = new Paciente();
		p.setId(Integer.parseInt(idPaciente));

		a.setMedico(m);
		a.setPaciente(p);
		a.setExpressoes(expressoes);
		
		AvaliacaoDao.create(a);
		
		response.sendRedirect(request.getContextPath() + "/views/pacientes/index.jsp");
	}

	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}

	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}

}
