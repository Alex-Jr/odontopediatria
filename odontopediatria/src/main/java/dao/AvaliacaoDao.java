package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;
import java.util.ArrayList;

import beans.Paciente;
import beans.Medico;

import dao.PacienteDao;
import dao.MedicoDao;

import beans.Avaliacao;
import database.ConexaoMySQL;

public class AvaliacaoDao {
	public static void create(Avaliacao a) {
		try {
			String query = "INSERT INTO avaliacoes"
					+ "(PacienteID, MedicoID, expressoes, `data`, ansiedade)"
					+ "VALUES(?, ?, ?, ?, ?);";
			
			Connection con = ConexaoMySQL.get();
			
			PreparedStatement st = con.prepareStatement(query);

			st.setInt(1, a.getPaciente().getId());
			st.setInt(2, a.getMedico().getId());
			st.setString(3, a.getExpressoes());
			st.setDate(4, new Date(new java.util.Date().getTime()));
			st.setInt(5, a.getAnsiedade());
			
			st.execute();
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
	}
	
	public static ArrayList<Avaliacao> list(int id){
		try {
			String query = "SELECT * FROM Avaliacoes WHERE PacienteID = ?";
			Connection con = ConexaoMySQL.get();
			
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, id);
			
			ResultSet rs = st.executeQuery();
			
			ArrayList<Avaliacao> lista = new ArrayList<Avaliacao>(); 
			
			while(rs.next()) {
				int idAvaliacao = rs.getInt("id");
				int pacienteId = rs.getInt("PacienteID");
				int medicoId = rs.getInt("MedicoID");
				String expressoes = rs.getString("expressoes");
				Date data = rs.getDate("data");
				int ansiedade = rs.getInt("ansiedade");
				
				Paciente paciente = PacienteDao.get(pacienteId);
				Medico medico = MedicoDao.get(medicoId);
				
				lista.add(new Avaliacao(idAvaliacao, paciente, medico, expressoes, data, ansiedade));
			}
			
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
