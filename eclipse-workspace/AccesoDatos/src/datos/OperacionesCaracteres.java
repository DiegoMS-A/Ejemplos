package datos;

import java.io.*;

public class OperacionesCaracteres {

	public void leerFichero(File F) {		
		
	}
	
	public void leerFicherASCII (File file) {
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		try {
			fileReader = new FileReader (file);
			bufferedReader = new BufferedReader(fileReader);
			int codigo;
			while((codigo = bufferedReader.read())>0) {
				//codigo = bufferedReader.read(); //lee codigo de la letra E = 101
				System.out.println(codigo);
				System.out.println(Character.toChars(codigo));//convierte a char el codigo
				//String linea= bufferedReader.readLine(); //lee linea del fichero 
				//System.out.println(linea);
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
				bufferedReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
