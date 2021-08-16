package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.Medico;
import database.ConexaoMySQL;

public class MedicoDao {
	private static Connection con = ConexaoMySQL.get();
	
	public static ArrayList<Medico> list() {
		try {
			String query = "select * from medicos";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			ArrayList<Medico> lista = new ArrayList<Medico>();
			while(rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String crm = rs.getString("crm");


				lista.add(new Medico(id, nome, crm));
			}	
			
			return lista;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static Medico get(int id) {
		try {
			String query = "SELECT * FROM medicos WHERE id = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, id);
			
			ResultSet rs = st.executeQuery();
			
			if(!rs.next()) return null;

			String nome = rs.getString("nome");
			String crm = rs.getString("crm");
			
			Medico m = new Medico(id, nome, crm);
			return m;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static void create(Medico m) {
		try {
			String query = "INSERT INTO medicos (nome, crm) values (?, ?)";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, m.getNome());
			st.setString(2, m.getCrm());
			
			st.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
	}
	
	public static void update(Medico m) {
		try {
			String query = "UPDATE medicos"
					+ " SET nome = ?, crm = ?"
					+ "WHERE id = ?";
			
			Medico old = MedicoDao.get(m.getId());

			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, m.getNome() != null ? m.getNome() : old.getNome());
			st.setString(2, m.getCrm() != null ? m.getCrm() : old.getCrm());
			st.setInt(3, m.getId());
			st.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
	}
	
	public static void delete(Medico m) {
		try {
			String query = "DELETE FROM medicos WHERE id= ?";
			PreparedStatement st = con.prepareStatement(query);
	
			st.setInt(1, m.getId());
			st.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
	}
	
	public static int getLast() {
		try {
			String query = "SELECT max(id) AS ultimo FROM medicos;";
			PreparedStatement st = con.prepareStatement(query);

			ResultSet rs = st.executeQuery();
			
			rs.next();
			
			return rs.getInt("ultimo");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
}
