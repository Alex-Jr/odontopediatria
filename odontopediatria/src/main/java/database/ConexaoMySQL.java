package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;

public class ConexaoMySQL {
	private static Connection con;

	public static Connection get() {
		try {
			if(con != null && con.isValid(0)) {
				return con;
			}

			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String host = "us-cdbr-east-04.cleardb.com";
			String database = "heroku_076c0b1756bad35";
			String port = "3306";
			String user = "b34f340722ec0b";
			String password = "3835ed25";
		    String url = "jdbc:mysql://" + host + ":" + port + "/" + database;
		    
			con = DriverManager.getConnection(url, user, password);

			return con;
		} catch (ClassNotFoundException e) {
			System.out.println("Driver MySQL não encontrado");
			
			return null;
		} catch(SQLNonTransientConnectionException e) {
			con = null;
			return ConexaoMySQL.get();
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
