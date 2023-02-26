package datos;

import java.io.File;
import java.io.IOException;

public class EntradaFichero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File ("src/documentos/inicio.txt");
		System.out.println(f.exists()); // si existe
		System.out.println(f.getName()); //su nombre
		System.out.println(f.getAbsolutePath()); // ruta absoluta
		System.out.println(f.getAbsoluteFile()); //nombre completo
		System.out.println(f.canRead()); // si se puede leer
		System.out.println(f.getParent()); //dar directorio padre
		
		if(!f.exists()) { // si el fichero no existe
			try {
				f.createNewFile(); //crealo
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		/*String[] listaDocumentos = f.list();//para apuntar a directorios y listar los documentos. src/documentos
		for(String doc : listaDocumentos) {
			System.out.println(doc);
		}*/
		
		/*File[] listaFicheros = f.listFiles();
		for (File file : listaFicheros) {
			System.out.println(file.getAbsolutePath());
		}*/
		
		File directorio = new File("/AccesoDatos/src/documentos");
		directorio.mkdir();// crea directorio en ruta
	}

}
