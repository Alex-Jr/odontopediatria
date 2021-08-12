package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.Paciente;
import database.ConexaoMySQL;

public class PacienteDao {
	private static Connection con = ConexaoMySQL.get();
	
	public static ArrayList<Paciente> list() {
		try {
			String query = "select * from pacientes";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			ArrayList<Paciente> lista = new ArrayList<Paciente>();
			while(rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String sexo = rs.getString("sexo");
				Date dataNasc = rs.getDate("dataNasc");
				String nomeResponsavel = rs.getString("responsavel");
				String telefoneResponsavel = rs.getString("telefone_responsavel");

				lista.add(new Paciente(id, nome, sexo, dataNasc, nomeResponsavel, telefoneResponsavel));
			}	
			
			return lista;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static void create(Paciente p) {
		try {
			String query = "INSERT INTO pacientes (nome, sexo, dataNasc, responsavel, telefone_responsavel) values (?, ?, ?, ?, ?)";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, p.getNome());
			st.setString(2, p.getSexo());
			st.setDate(3, new java.sql.Date(p.getDataNasc().getTime()));
			st.setString(4, p.getNomeResponsavel());
			st.setString(5, p.getTelefoneResponsavel());
			
			st.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
	}
	
	public static Paciente get(int id) {
		try {
			String query = "SELECT * FROM pacientes WHERE id = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, id);
			
			ResultSet rs = st.executeQuery();
			
			if(!rs.next()) return null;

			String nome = rs.getString("nome");
			String sexo = rs.getString("sexo");
			Date dataNasc = rs.getDate("dataNasc");
			String nomeResponsavel = rs.getString("responsavel");
			String telefoneResponsavel = rs.getString("telefone_responsavel");
			
			Paciente p = new Paciente(id, nome, sexo, dataNasc, nomeResponsavel, telefoneResponsavel);
			return p;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static void update(Paciente p) {
		try {
			String query = "UPDATE pacientes"
					+ " SET nome = ?, sexo = ?, dataNasc  = ?, responsavel = ?, telefone_responsavel = ?"
					+ "WHERE id = ?";
			
			Paciente old = PacienteDao.get(p.getId());

			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, p.getNome() != null ? p.getNome() : old.getNome());
			st.setString(2, p.getSexo() != null ? p.getSexo() : old.getSexo());
			st.setDate(3, p.getDataNasc() != null ? new java.sql.Date(p.getDataNasc().getTime()) : new java.sql.Date(old.getDataNasc().getTime()));
			st.setString(4, p.getNomeResponsavel() != null ? p.getNomeResponsavel() : old.getNomeResponsavel());
			st.setString(5, p.getTelefoneResponsavel() != null ? p.getTelefoneResponsavel() : old.getTelefoneResponsavel());
			st.setInt(6, p.getId());
			st.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
	}
	
	public static void delete(Paciente p) {
		try {
			String query = "DELETE FROM pacientes WHERE id = ?";
			
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, p.getId());
			st.execute();
			
		} catch (SQLException e){
			e.printStackTrace();
			return;
		}	
	}
}
