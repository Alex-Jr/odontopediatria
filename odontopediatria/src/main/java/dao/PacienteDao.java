package dao;

import java.sql.Connection;
import java.sql.Date;
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
}
