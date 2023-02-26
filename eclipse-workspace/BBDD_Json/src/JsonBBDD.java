import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonBBDD {
	public static Connection ConectarBBDD() throws Exception {
		// Registro de driver
		Class.forName("org.mariadb.jdbc.Driver");
		// Url de la conexion
		String url = "jdbc:mariadb://127.0.0.1:3306/almacen";
		Connection con = DriverManager.getConnection(url, "root", "");
		System.out.println("Conexion establecida");
		return con;
	}

	public static void main(String args[]) {
		JSONParser jsonParser = new JSONParser();
		try {
			JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("src/archivos/productos.json"));
			JSONArray jsonArray = (JSONArray) jsonObject.get("products");
			Connection con = ConectarBBDD();

			// Borramos contenido tabla para que se inserten los articulos
			PreparedStatement truncate = con.prepareStatement("TRUNCATE TABLE productos");
			truncate.executeUpdate();

			// Insertar desde products.json sacando la info a tabla productos recorriendo el
			// json
			PreparedStatement pstmt = con.prepareStatement("INSERT INTO productos values (?, ?, ?, ?, ? )");
			for (Object object : jsonArray) {
				JSONObject record = (JSONObject) object;
				int id = Integer.parseInt(String.valueOf(record.get("id")));
				String nombre = (String) record.get("title");
				String descripcion = (String) record.get("description");
				int cantidad = Integer.parseInt(String.valueOf(record.get("stock")));
				double precio = Double.parseDouble(String.valueOf(record.get("price")));
				pstmt.setInt(1, id);
				pstmt.setString(2, nombre);
				pstmt.setString(3, descripcion);
				pstmt.setInt(4, cantidad);
				pstmt.setDouble(5, precio);

				// Ejecutamos la insercion preparada
				pstmt.executeUpdate();
			}
			System.out.println("Insertados registros correctamente desde productos.json");

			// AGREGAR UNA SERIE DE EMPLEADOS Y PEDIDOS MEDIANTE STATEMENT
			// DEJAMOS LAS TABLA VACIAS PARA HACER LA EJECUCIÓN
			truncate = con.prepareStatement("TRUNCATE TABLE EMPLEADOS");
			truncate.executeUpdate();
			truncate = con.prepareStatement("TRUNCATE TABLE PEDIDOS");
			truncate.executeUpdate();

			// Se insertan 3 trabajadores, la id, la autoincrementa la BBDD
			PreparedStatement InsertarEmplead1 = con.prepareStatement(
					"INSERT INTO empleados (nombre, apellidos, correo) VALUES ('PACO', 'RODRIGUEZ', 'PRODRIGUEZ@CORREO.COM')");
			InsertarEmplead1.executeUpdate();
			PreparedStatement InsertarEmplead2 = con.prepareStatement(
					"INSERT INTO empleados (nombre, apellidos, correo) VALUES ('MAR', 'SANCHEZ', 'MSANCHEZZ@CORREO.COM')");
			InsertarEmplead2.executeUpdate();
			PreparedStatement InsertarEmplead3 = con.prepareStatement(
					"INSERT INTO empleados (nombre, apellidos, correo) VALUES ('RAFA', 'SALAS', 'RSALASZ@CORREO.COM')");
			InsertarEmplead3.executeUpdate();

			// Se insertan 3 pedidos.La id, la autoincrementa la BBDD
			PreparedStatement InsertarPedido1 = con.prepareStatement(
					"INSERT INTO pedidos (id_producto, descripcion, precio_total) SELECT id, descripcion, precio FROM productos WHERE ID='1'");
			InsertarPedido1.executeUpdate();
			PreparedStatement InsertarPedido2 = con.prepareStatement(
					"INSERT INTO pedidos (id_producto, descripcion, precio_total) SELECT id, descripcion, precio FROM productos WHERE ID='6'");
			InsertarPedido2.executeUpdate();
			PreparedStatement InsertarPedido3 = con.prepareStatement(
					"INSERT INTO pedidos (id_producto, descripcion, precio_total) SELECT id, descripcion, precio FROM productos WHERE ID='9'");
			InsertarPedido3.executeUpdate();

			// MOSTRAR POR CONSOLA LISTA DE EMPLEADOS
			PreparedStatement empleados = con.prepareStatement("SELECT * FROM empleados");
			empleados.executeQuery();
			ResultSet rs = empleados.executeQuery();
			System.out.println("-------------------");
			System.out.println("LISTA DE EMPLEADOS");
			System.out.println("-------------------");
			while (rs.next()) {
				System.out.println("ID = " + rs.getString(1));
				System.out.println("NOMBRE = " + rs.getString(2));
				System.out.println("APELLIDOS = " + rs.getString(3));
				System.out.println("CORREO = " + rs.getString(4));
				System.out.println("---------------");
			}

			// MOSTRAR POR CONSOLA LISTA DE PRODCUTOS
			PreparedStatement productos = con.prepareStatement("SELECT * FROM productos");
			productos.executeQuery();
			rs = productos.executeQuery();
			System.out.println("-------------------");
			System.out.println("LISTA DE PRODUCTOS");
			System.out.println("-------------------");
			while (rs.next()) {
				System.out.println("ID = " + rs.getString(1));
				System.out.println("ARTICULO = " + rs.getString(2));
				System.out.println("DESCRIPCION = " + rs.getString(3));
				System.out.println("STOCK = " + rs.getString(4));
				System.out.println("PRECIO = " + rs.getString(5) + " euros");
				System.out.println("---------------");
			}

			// MOSTRAR POR CONSOLA LISTA DE PEDIDOS
			PreparedStatement pedidos = con.prepareStatement("SELECT * FROM pedidos");
			pedidos.executeQuery();
			rs = pedidos.executeQuery();
			System.out.println("-------------------");
			System.out.println("LISTA DE PEDIDOS");
			System.out.println("-------------------");
			while (rs.next()) {
				System.out.println("ID = " + rs.getString(1));
				System.out.println("ID PRODUCTO = " + rs.getString(2));
				System.out.println("DESCRIPCION = " + rs.getString(3));
				System.out.println("PRECIO = " + rs.getString(4) + " euros");
				System.out.println("---------------");
			}

			// MOSTRAR POR CONSOLA LOS PRODUCTOS CON PRECIO<600 EUROS

			PreparedStatement precio600 = con.prepareStatement("SELECT * FROM productos WHERE precio<600");
			precio600.executeQuery();
			rs = precio600.executeQuery();
			System.out.println("-------------------");
			System.out.println("ARTICULOS POR MENOS DE 600 EUROS");
			System.out.println("-------------------");
			while (rs.next()) {
				System.out.println("ID = " + rs.getString(1));
				System.out.println("ARTICULO = " + rs.getString(2));
				System.out.println("DESCRIPCION = " + rs.getString(3));
				System.out.println("STOCK = " + rs.getString(4));
				System.out.println("PRECIO = " + rs.getString(5) + " euros");
				System.out.println("---------------");
			}

			// INSERTAR EN PRODUCTOS_FAV PRODUCTOS CON PRECIO>1000 EUROS

			truncate = con.prepareStatement("TRUNCATE TABLE productos_fav");
			truncate.executeUpdate();
			// "INSERT INTO pedidos (id_producto, descripcion, precio_total) SELECT id,
			// descripcion, precio FROM productos WHERE ID='9'
			PreparedStatement InsertarProductos1000 = con.prepareStatement(
					"INSERT INTO productos_fav (id_producto) SELECT id FROM productos WHERE precio>1000");
			InsertarProductos1000.executeUpdate();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}