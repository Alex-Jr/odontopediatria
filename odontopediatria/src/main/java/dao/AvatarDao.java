package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.Avatar;
import database.ConexaoMySQL;

public class AvatarDao {
	private static Connection con = ConexaoMySQL.get();
	
	public static ArrayList<Avatar> list() {
		try {
			String query = "SELECT * FROM avatares"
					+ "RIGHT JOIN paciente"
					+ "ON avatar.id_paciente = paciente.id;";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			ArrayList<Avatar> lista = new ArrayList<Avatar>();
			while(rs.next()) {
				Avatar a = new Avatar();
				a.setId(rs.getInt("id_avatar"));
				a.setCorPele(rs.getString("cor_da_pele"));
				a.setOlho(rs.getString("olho"));
				a.setCorOlho(rs.getString("cor_do_olho"));
				a.setBoca(rs.getString("boca"));
				a.setCabelo(rs.getString("cabelo"));
				a.setRoupa(rs.getInt("roupa"));
				a.setPaciente(PacienteDao.get(rs.getInt("id_paciente")));

				lista.add(a);
			}	
			
			return lista;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static Avatar get(int id) {
		try {
			String query = "SELECT * FROM avatares WHERE id = ?;";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, id);
			
			ResultSet rs = st.executeQuery();
			
			if(!rs.next()) return null;
			
			Avatar a = new Avatar();

			a.setId(rs.getInt("id_avatar"));
			a.setCorPele(rs.getString("cor_da_pele"));
			a.setOlho(rs.getString("olho"));
			a.setCorOlho(rs.getString("cor_do_olho"));
			a.setBoca(rs.getString("boca"));
			a.setCabelo(rs.getString("cabelo"));
			a.setRoupa(rs.getInt("roupa"));
			a.setPaciente(PacienteDao.get(rs.getInt("id_paciente")));

			return a;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static boolean create(Avatar  a) {
		try {
			String query = "INSERT INTO odontopediatria.avatares"
					+ "(cor_da_pele, olho, cor_do_olho, sobrancelha, nariz, orelha, boca, cabelo, rosto, roupa, id_paciente)"
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
					
			PreparedStatement st = con.prepareStatement(query);

			st.setString(1, a.getCorPele());
			st.setInt(2, a.getOlho());
			st.setString(3, a.getCorOlho());
			st.setInt(4, a.getSobrancelha());
			st.setInt(5, a.getNariz());
			st.setInt(6, a.getOrelha());
			st.setInt(7, a.getBoca());
			st.setInt(8, a.getCabelo());
			st.setInt(9, a.getRosto());
			st.setInt(10, a.getRoupa());
			st.setInt(11, a.getPaciente().getId());
			
			st.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public static void delete(int id) {
		try {
			String query = "DELETE FROM avatares WHERE id=?";
			PreparedStatement st = con.prepareStatement(query);
	
			st.setInt(1, id);
	
			st.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
	}
}
