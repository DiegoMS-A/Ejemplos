package baseDeDatos;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.mariadb.jdbc.Connection;


public class Conexion {

	private Connection conn;

	public Connection getConexion() throws SQLException {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/nba";
			String usuario = "root";
			String contrasenia = "";
			conn = (Connection) DriverManager.getConnection(url, usuario, contrasenia);
		} catch (ClassNotFoundException e) {
			System.out.println("No encuentra el controlador");
			e.getStackTrace();
		} catch (SQLException e) {
			System.out.println("Error en la conexion");
			e.getStackTrace();
		}
		return conn;
	}

	public void llamarConexion() {
		System.out.println(conn.toString());
	}

}