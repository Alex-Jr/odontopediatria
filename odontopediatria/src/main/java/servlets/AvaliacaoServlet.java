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

@WebServlet("/avaliacoes")
public class AvaliacaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		
		
		response.sendRedirect(request.getContextPath() + "/views/avaliacoes/finish.jsp?ansiedade=" + a.getAnsiedade() + 
				"&pacienteID=" + p.getId() + "&medicoID=" + m.getId());
	}
}
