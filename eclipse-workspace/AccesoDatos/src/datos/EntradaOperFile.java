package datos;

import java.io.File;

public class EntradaOperFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		OperacionesFile operacionesFile = new OperacionesFile();
		operacionesFile.leerFichero(new File ("src/documentos/inicio.txt"));
	}

}
