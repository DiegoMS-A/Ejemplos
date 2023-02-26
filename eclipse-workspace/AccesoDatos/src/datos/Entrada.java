package datos;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

public class Entrada {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OperacionesCaracteres operacionesCaracteres = new OperacionesCaracteres();
		operacionesCaracteres.leerFicherASCII(new File("src/documentos/ASCII.txt"));
		
	}

}
