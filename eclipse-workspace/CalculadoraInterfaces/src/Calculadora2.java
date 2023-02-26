import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.TextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;

//Calculadora en modo Design con el método de creación Swing>JFrame

public class Calculadora2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora2 frame = new Calculadora2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Calculadora2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		TextField visor= new TextField("0");
		visor.setFont(new Font("Dialog", Font.BOLD, 16));
		visor.setBackground(new Color(240, 255, 255));
		getContentPane().add(visor,BorderLayout.NORTH);
		
		JPanel botonera = new JPanel();
		botonera.setLayout(new GridLayout(4,4));
		
		JButton boton1 = new JButton("1");
		boton1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		botonera.add(boton1);
		
	JButton boton2 = new JButton("2");
	boton2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		botonera.add(boton2);	
		
	JButton boton3 = new JButton("3");
	boton3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		botonera.add(boton3);
		
	JButton boton4 = new JButton("4");
	boton4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		botonera.add(boton4);
		
	JButton boton5 = new JButton("5");
	boton5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		botonera.add(boton5);
		
	JButton boton6 = new JButton("6");
	boton6.setFont(new Font("Tahoma", Font.PLAIN, 17));
		botonera.add(boton6);
		
	JButton boton7 = new JButton("7");
	boton7.setFont(new Font("Tahoma", Font.PLAIN, 17));
		botonera.add(boton7);	
		
	JButton boton8 = new JButton("8");
	boton8.setFont(new Font("Tahoma", Font.PLAIN, 17));
		botonera.add(boton8);
		
	JButton boton9 = new JButton("9");
	boton9.setFont(new Font("Tahoma", Font.PLAIN, 17));
		botonera.add(boton9);

	JButton boton0 = new JButton("0");
	boton0.setFont(new Font("Tahoma", Font.PLAIN, 17));
		botonera.add(boton0);
		
	JButton botonDiv = new JButton("/");
	botonDiv.setFont(new Font("Tahoma", Font.PLAIN, 17));
		botonera.add(botonDiv);
		
	JButton botonMult = new JButton("*");
	botonMult.setFont(new Font("Tahoma", Font.PLAIN, 17));
		botonera.add(botonMult);
		
	JButton botonSum = new JButton("+");
	botonSum.setFont(new Font("Tahoma", Font.PLAIN, 17));
		botonera.add(botonSum);
		
	JButton botonRest = new JButton("-");
	botonRest.setFont(new Font("Tahoma", Font.PLAIN, 17));
		botonera.add(botonRest);
		
	JButton botonIgual = new JButton("=");
	botonIgual.setFont(new Font("Tahoma", Font.PLAIN, 17));
		botonera.add(botonIgual);
		
	JButton botonPunto = new JButton(".");
	botonPunto.setFont(new Font("Tahoma", Font.PLAIN, 17));
		botonera.add(botonPunto);
		
		getContentPane().add(botonera, BorderLayout.CENTER);	
	}

}
