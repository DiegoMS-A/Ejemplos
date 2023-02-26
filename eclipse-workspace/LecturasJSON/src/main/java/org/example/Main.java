package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File file = new File("C:\\Users\\diego\\eclipse-workspace\\LecturasJSON\\src\\recursos\\alumnos.txt");

		if (file.exists()) {
			System.out.println("El fichero existe");
			FileReader reader = null;
			BufferedReader bufferedReader = null;
			try {
				reader = new FileReader(file);
				bufferedReader = new BufferedReader(reader);
				String linea = null;
				StringBuilder builder = new StringBuilder();

				while ((linea = bufferedReader.readLine()) != null) {
					builder.append(linea);
					
				}
				
				JSONObject jsonObject = new JSONObject(builder.toString());
				//System.out.println(jsonObject);				
				//System.out.println(builder.toString());
				String nombre = jsonObject.getString("name_results");
				JSONObject objetoResultado = jsonObject.getJSONObject("object_results");
				//System.out.println(nombre);
				//System.out.println(objetoResultado);				
				JSONArray array = jsonObject.getJSONArray("results");
				//System.out.println(array);	
				
				for (int i = 0; i < array.length(); i++) {
					JSONObject temporal = array.getJSONObject(i);
					String nombreTemporal = temporal.getString("nombre");
					String apellidoTemporal = temporal.getString("apellido");
					System.out.printf("%s %s%n", nombreTemporal, apellidoTemporal);
					JSONArray asginaturasTemporal = temporal.getJSONArray("asignaturas");
					
					for (int j = 0; j < asginaturasTemporal.length(); j++) {
						System.out.printf("\t%s%n", asginaturasTemporal.get(j).toString());
					}
				}

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
