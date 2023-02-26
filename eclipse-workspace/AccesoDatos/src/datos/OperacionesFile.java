package datos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class OperacionesFile {

	public void leerFichero(File F) {
		//File --> Flujo --> Buffer --> Close
		
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		try {
			fileReader = new FileReader(F);
			bufferedReader = new BufferedReader(fileReader);
			//int lectura = fileReader.read();//añadido catch al try
			String linea;
			while((linea= bufferedReader.readLine()) != null) {
				
				System.out.println(linea);
			}
			//System.out.println(lectura);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Fichero no encontrado");
		} catch (IOException e) {//para fileReader.read()
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Error al cerrar el fichero");
			}
		}
		
		
	}
	}
