package acceso_ficheros;

import java.io.FileReader;
import java.io.IOException;

public class Lectura_fichero_character {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leer_Fichero accediendo = new Leer_Fichero();
		accediendo.lee();
	}

}

class Leer_Fichero {

	public void lee() {

		try {
			FileReader entrada = new FileReader("C:\\Users\\diego\\eclipse-workspace\\Pildoras\\src\\acceso_ficheros\\prueba");

			int c = 0;

			while (c != -1) {
				c = entrada.read();
				char letra = (char) c;

				if (c != -1) {
					System.out.print(letra);
				}
			}

			entrada.close();

		} catch (IOException e) {
			System.out.println("No se ha encontrado el archivo");
		}

	}
}