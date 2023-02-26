package baseDeDatos;

import java.sql.SQLException;

public class Entrada {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Conexion conexion = new Conexion();
		try {
			conexion.getConexion();
			conexion.llamarConexion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		GestionBD gestionbd = new GestionBD();

		try {
			//gestionbd.insertarJugador(5, "Usman Garuba","Houston", "Alero");
			System.out.println(gestionbd.devolverJugadores().toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
