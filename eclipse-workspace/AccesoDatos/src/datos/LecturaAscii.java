package datos;

import java.io.*;

public class LecturaAscii {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File file = new File("src/documentos/escritura.txt");
		FileReader reader = null;
		BufferedReader bufferedReader = null;

		try {
			reader = new FileReader(file);
			bufferedReader = new BufferedReader(reader);
			String lectura = null;
			while ((lectura = bufferedReader.readLine()) != null) {
				//System.out.println(lectura); muestra el documento
				String[] palabras= lectura.split(" ");
					for (String item : palabras){
						System.out.println(Character.toChars(Integer.parseInt(item)));//saca los simbolos segun el numero ascii del doc
					}
			}
			
			
			/*int lectura = -1;
			while((lectura = reader.read())!= -1) {//lee todos los numeros y devuelve codigo ascii
				System.out.println(Character.toChars(lectura));
			}
			//System.out.println(reader.read());*/
			
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

}
