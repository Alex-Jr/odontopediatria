package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {
	private static Connection con;

	public static Connection get() {
		try {
			if(con != null && con.isValid(0)) {
				return con;
			}

			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String host = "localhost";
			String database = "odontopediatria";
			String port = "3306";
			String user = "odontopediatria";
			String password = "password";
		    String url = "jdbc:mysql://" + host + ":" + port + "/" + database;
		    
			con = DriverManager.getConnection(url, user, password);

			return con;
		} catch (ClassNotFoundException e) {
			System.out.println("Driver MySQL não encontrado");
			
			return null;
		} catch (SQLException e) {
			System.out.println("Erro ao conectar");
			e.printStackTrace();
			
			return null;
		}
	}
	
	public static void close() {
		if(con == null) return;

		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("Falha ao fechar conexão");
			e.printStackTrace();
		}
	}
	
	public static Boolean isValid() {
		if (con == null) return false;
		
		try {
			return con.isValid(0);
		} catch (SQLException e) {
			return false;
		}
	}
}
