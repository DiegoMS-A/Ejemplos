package graficos;

import java.awt.Frame;

import javax.swing.JFrame;

public class CreandoMarcos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		miMarco marco1 = new miMarco();

		marco1.setVisible(true); // por defecto vienen invisibles

		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// cerrar programa al cerrar ventana

	}

}

class miMarco extends JFrame {

	public miMarco() {

		//setSize(500, 300); //tamaño del frame
		
		//setLocation(500, 300); //localizacion en pixeles del frame en coord X,Y
		
		setBounds(500,300,550,250); //mezcla location y size, primero coordenadas y luego ancho y alto
		
		//setResizable(false); //no permite redimensionar ventana
		
		//setExtendedState(Frame.MAXIMIZED_BOTH); // se abre marco a pantalla completa
		
		setTitle("Mi ventana");
		
		
		
	}
}