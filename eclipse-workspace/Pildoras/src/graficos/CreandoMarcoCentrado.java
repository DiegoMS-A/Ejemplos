package graficos;

import java.awt.Toolkit;
import java.awt.*;
import javax.swing.JFrame;

public class CreandoMarcoCentrado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoCentrado mimarco = new MarcoCentrado();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);
		
	}

}

class MarcoCentrado extends JFrame {

	public MarcoCentrado() {

		Toolkit mipantalla = Toolkit.getDefaultToolkit(); // almacenar sistema nativo ventanas

		Dimension tamanoPantalla = mipantalla.getScreenSize(); // almacena el tamaño de pantalla en un objeto dimension

		int alturaPantalla = tamanoPantalla.height; // obtener el alto de la pantalla

		int anchoPantalla = tamanoPantalla.width; // obtener el ancho de la pantalla
		
		setSize(anchoPantalla/2, alturaPantalla/2); // marco a la mitad de la pantalla
		
		setLocation(anchoPantalla/4, alturaPantalla/4); //para que quede centrado sabiendo que la pantalla ocupa la mitad
		
		setTitle("Marco Centrado");
		
		Image miIcono=mipantalla.getImage("src/graficos/icono.gif"); //en SRC, añade icono a la ventana, nombre de este archivo
		
		setIconImage(miIcono); //establece el icono

	}

}