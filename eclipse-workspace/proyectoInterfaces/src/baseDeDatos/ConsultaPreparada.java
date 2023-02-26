package baseDeDatos;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mariadb.jdbc.Connection;

public class ConsultaPreparada {

	public static void main(String[] args) {

		try {
			// 1- Crea conexion
			Connection miConexion = (Connection) DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/nba",
					"root", "");

			// 2- Prepara consulta
			PreparedStatement miSentencia = miConexion.prepareStatement("SELECT * FROM nba ORDER BY equipo");
			// PreparedStatement miSentencia = miConexion.prepareStatement("SELECT * FROM
			// nba WHERE Equipo= 'Houston'" );

			// 3. Establecer los parametros de consulta en caso de tener where

			// miSentencia.setString(3, "Equipo");

			// 4 Ejecutar y recorrer consulta

			ResultSet rs = miSentencia.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
