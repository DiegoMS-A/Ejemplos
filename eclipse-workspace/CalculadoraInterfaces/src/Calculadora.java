import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import javax.swing.*;
import java.awt.Font;
//Calculadora en código.

public class Calculadora {

	public static void main(String[] args) {
	
		CuerpoCalculadora pantalla = new CuerpoCalculadora();		
		pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pantalla.setVisible(true);	
		
		}
	}
	
	class CuerpoCalculadora extends JFrame {
		private JPanel contentPane;
		
		public CuerpoCalculadora() {
			
			setTitle("Calculadora");
			setBounds(500,300,450,300);
			
			VistaCalculadora visor = new VistaCalculadora();
			add(visor);
		}
		
	}
	
	class VistaCalculadora extends JPanel {
		
		public VistaCalculadora(){
			setLayout(new BorderLayout());			
			TextField visor= new TextField("0");
			add(visor,BorderLayout.NORTH);
			
			JPanel botonera = new JPanel();
			botonera.setLayout(new GridLayout(4,4));			
					
					
			JButton boton1 = new JButton("1");
				botonera.add(boton1);
				
			JButton boton2 = new JButton("2");
				botonera.add(boton2);	
				
			JButton boton3 = new JButton("3");
				botonera.add(boton3);
				
			JButton boton4 = new JButton("4");
				botonera.add(boton4);
				
			JButton boton5 = new JButton("5");
				botonera.add(boton5);
				
			JButton boton6 = new JButton("6");
				botonera.add(boton6);
				
			JButton boton7 = new JButton("7");
				botonera.add(boton7);	
				
			JButton boton8 = new JButton("8");
				botonera.add(boton8);
				
			JButton boton9 = new JButton("9");
				botonera.add(boton9);

			JButton boton0 = new JButton("0");
				botonera.add(boton0);
				
			JButton botonDiv = new JButton("/");
				botonera.add(botonDiv);
				
			JButton botonMult = new JButton("*");
				botonera.add(botonMult);
				
			JButton botonSum = new JButton("+");
				botonera.add(botonSum);
				
			JButton botonRest = new JButton("-");
				botonera.add(botonRest);
				
			JButton botonIgual = new JButton("=");
				botonera.add(botonIgual);
				
			JButton botonPunto = new JButton(".");
				botonera.add(botonPunto);
				
			
		add(botonera, BorderLayout.CENTER);						
				
		}
	}