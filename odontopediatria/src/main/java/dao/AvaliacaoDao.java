package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.Avaliacao;
import database.ConexaoMySQL;

public class AvaliacaoDao {
	private static Connection con = ConexaoMySQL.get();

	public static void create(Avaliacao a) {
		try {
			String query = "INSERT INTO avaliacoes"
					+ "(PacienteID, MedicoID, expressoes, `data`, ansiedade)"
					+ "VALUES(?, ?, ?, ?, ?);";
			
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, a.getPaciente().getId());
			st.setInt(2, a.getMedico().getId());
			st.setString(3, a.getExpressoes());
			st.setDate(4, new Date(new java.util.Date().getTime()));
			st.setInt(5, a.getAnsiedade());
			
			st.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
	}
}
