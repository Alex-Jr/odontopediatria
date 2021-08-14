package servlets;

import java.io.BufferedReader;
import java.io.IOException;

import beans.Avatar;
import dao.AvatarDao;
import dao.PacienteDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AvatarServlet
 */
@WebServlet("/avatares")
public class AvatarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AvatarServlet() {
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
		
		Avatar a = new Avatar();
		
		a.setCorPele(request.getParameter("corPele"));
		a.setCorOlho(request.getParameter("corOlho"));
		a.setBoca(request.getParameter("boca"));
		a.setCabelo(request.getParameter("cabelo"));
		a.setNariz(request.getParameter("nariz"));
		a.setOlho(request.getParameter("olho"));
		a.setOrelha(request.getParameter("orelha"));
		a.setRosto(request.getParameter("rosto"));
		a.setRoupa(request.getParameter("roupa"));
		a.setSobrancelha(request.getParameter("sobrancelha"));
		a.setPaciente(PacienteDao.get(Integer.parseInt(request.getParameter("idPaciente"))));
		
		AvatarDao.create(a);
		
		response.sendRedirect(request.getContextPath() + "/views/avatares/index.jsp");
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bfr  = request.getReader(); 

		String params[] = bfr.readLine().split("&");
		
		Avatar a = new Avatar();
		for(int i = 0; i < params.length; i++) {	
			String entry[] = params[i].split("=");

			if(entry.length == 1) continue;
			String key = entry[0];
			String value = entry[1];
			
			if(key.equals("id")) a.setId(Integer.parseInt(value));
			if(key.equals("corPele")) a.setCorPele(value);
			if(key.equals("olho")) a.setOlho(value);
			if(key.equals("corOlho")) a.setCorOlho(value);
			if(key.equals("boca")) a.setBoca(value);
			if(key.equals("cabelo")) a.setCabelo(value);
			if(key.equals("roupa")) a.setRoupa(Integer.parseInt(value));
			// coloquei pq é interessante fazer a verificação avatar x paciente 
			if(key.equals("idPaciente")) a.setPaciente(PacienteDao.get(Integer.parseInt(value))); 
		}

//		AvatarDao.update(a);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bfr  = request.getReader(); 
		
		String params = bfr.readLine();	
		
		String entry[] = params.split("=");
		
		String key = entry[0];
		String value = entry[1];
				
		AvatarDao.delete(Integer.parseInt(value));
	}

}
