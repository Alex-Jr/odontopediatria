package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Medico;
import beans.Usuario;
import database.ConexaoMySQL;

public class UsuarioDao {
	private static Connection con = ConexaoMySQL.get();
	
	public static Usuario get(Usuario u) {
		try {
			String query = "SELECT * FROM usuarios"
					+ " INNER JOIN medicos"
					+ " ON medicos.id = usuarios.id_medico"
					+ " WHERE login = ? AND senha = ?;";

			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, u.getInfo());
			st.setString(2, u.getSenha());
			
			ResultSet rs = st.executeQuery();
			
			if(!rs.next()) return null;

			String tipo = rs.getString("tipo");
			String id = rs.getString("id_medico");	
			String nome = rs.getString("nome");
			String crm = rs.getString("crm");
			
			Medico medico = new Medico();
			medico.setCrm(crm);
			medico.setId(Integer.parseInt(id));
			medico.setNome(nome);
			
			Usuario novoU = new Usuario();
			novoU.setTipo(tipo);
			novoU.setMedico(medico);
			return novoU;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
