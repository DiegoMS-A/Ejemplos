package graficos;

import java.awt.*;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PruebaDibujo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoConDibujos mimarco = new MarcoConDibujos();

		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoConDibujos extends JFrame {

	MarcoConDibujos() {

		setTitle("Prueba con dibujos");
		setSize(400, 400);
		LaminaConFiguras milamina = new LaminaConFiguras();
		add(milamina);

	}
}

class LaminaConFiguras extends JPanel {

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		
		//g.drawRect(50, 50, 200, 200); // dibujar un cuadrado, 50,50 punto inicio XY pixeles, 200,200 ancho y alto
		///g.drawLine(100, 100, 300,  200);// XY primer punto, XY segundo punto
		g.drawArc(50, 100, 100, 200, 120, 150);// coord x, y, parametros arco
		
		
	}

}