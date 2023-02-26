import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Principal {

	private JFrame frame;
	private JTextField textNombSinDigit;
	private JTextField textNomElegido;
	private JTextField textSoloDigitos;	
	private JLabel lblEstasSobre;
	private JComboBox<String> comboEligeOpcion;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 987, 419);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		textNombSinDigit = new JTextField();
		textNombSinDigit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				//se guarda en char la letra pulsada
				char letra = e.getKeyChar();

				// Con isLetter() valdría para filtrar que es letra, no numero ni simbolos, utilizo los 2 cómo indica el ejercicio.
				if (Character.isDigit(letra) || Character.isLetter(letra) == false) {
					e.consume();
				}
			}
		});
		textNombSinDigit.setBounds(600, 81, 282, 24);
		frame.getContentPane().add(textNombSinDigit);
		textNombSinDigit.setColumns(10);

		JLabel lblNombreSinDigitos = new JLabel("Escribe el nombre de una persona sin digitos");
		lblNombreSinDigitos.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNombreSinDigitos.setBounds(600, 36, 345, 24);
		frame.getContentPane().add(lblNombreSinDigitos);

		JButton btnAnadirNombreSinDigt = new JButton("Añadir");
		btnAnadirNombreSinDigt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombreAnadido = textNombSinDigit.getText();
				
				//Evalúa la longitud del String para ver si esta vacío
				if (nombreAnadido.length() == 0) {
					JOptionPane.showMessageDialog(null, "No hay ningun nombre para añadir");
				} else {//Si no está vacío lo añadae
					comboEligeOpcion.addItem(nombreAnadido);
					JOptionPane.showMessageDialog(null, "Nombre añadido: " + nombreAnadido);
					textNombSinDigit.setText("");
				}
			}
		});
		btnAnadirNombreSinDigt.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAnadirNombreSinDigt.setBounds(595, 146, 90, 24);
		frame.getContentPane().add(btnAnadirNombreSinDigt);

		JButton btnPulsame = new JButton("Pulsame");
		btnPulsame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Pulsado el botón 'Pulsame'");
			}
		});
		btnPulsame.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnPulsame.setBounds(36, 81, 136, 23);
		frame.getContentPane().add(btnPulsame);

		JLabel lblPulsaBtn = new JLabel("Pulsa el boton");
		lblPulsaBtn.setHorizontalAlignment(SwingConstants.CENTER);
		lblPulsaBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPulsaBtn.setBounds(36, 36, 136, 24);
		frame.getContentPane().add(lblPulsaBtn);

		comboEligeOpcion = new JComboBox<String>();
		comboEligeOpcion.setEditable(true);
		comboEligeOpcion.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String seleccionado = (String) comboEligeOpcion.getSelectedItem();
				textNomElegido.setText(seleccionado);
			}
		});
		comboEligeOpcion.setFont(new Font("Tahoma", Font.PLAIN, 14));		
		comboEligeOpcion.setModel(new DefaultComboBoxModel<String>(new String[] { "Fernando", "Paco", "Rosa", "Juan" }));
		comboEligeOpcion.setBounds(267, 82, 157, 24);
		frame.getContentPane().add(comboEligeOpcion);

		JLabel lblEligeOpcion = new JLabel("Elige una opcion:");
		lblEligeOpcion.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEligeOpcion.setBounds(267, 36, 146, 24);
		frame.getContentPane().add(lblEligeOpcion);

		JLabel lblNombreElegido = new JLabel("Nombre Elegido");
		lblNombreElegido.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNombreElegido.setBounds(267, 149, 157, 17);
		frame.getContentPane().add(lblNombreElegido);

		textNomElegido = new JTextField();
		textNomElegido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textNomElegido.setBounds(267, 176, 157, 24);
		frame.getContentPane().add(textNomElegido);
		textNomElegido.setColumns(10);

		textSoloDigitos = new JTextField();
		textSoloDigitos.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				textSoloDigitos.setText("");
			}
		});
		textSoloDigitos.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				//se guarda en char la tecla pulsada
				char letra = e.getKeyChar();

				if (Character.isLetter(letra)) {
					e.consume(); //metodo para pasar por alto la pulsación de la tecla si es true la evaluacion
				}

			}
		});

		textSoloDigitos.setBounds(600, 288, 184, 29);
		frame.getContentPane().add(textSoloDigitos);
		textSoloDigitos.setColumns(10);

		JLabel lblSoloDigit = new JLabel("Solo se pueden escribir digitos");
		lblSoloDigit.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSoloDigit.setBounds(600, 248, 261, 24);
		frame.getContentPane().add(lblSoloDigit);

		lblEstasSobre = new JLabel("Estas sobre la ");
		lblEstasSobre.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEstasSobre.setBounds(218, 248, 251, 24);
		frame.getContentPane().add(lblEstasSobre);

		JRadioButton rdbtnOpcion1 = new JRadioButton("Opcion 1");
		rdbtnOpcion1.addMouseListener(new MouseAdapter() {
			@Override
			
			//Al entrar mouse
			public void mouseEntered(MouseEvent e) {
				lblEstasSobre.setText("Estas sobre la opcion 1");
			}
			//Al salir mouse
			@Override
			public void mouseExited(MouseEvent e) {
				lblEstasSobre.setText("Estas sobre la");
			}
		});

		rdbtnOpcion1.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnOpcion1.setBounds(57, 217, 103, 21);
		frame.getContentPane().add(rdbtnOpcion1);

		JRadioButton rdbtnOpcion2 = new JRadioButton("Opcion 2");
		rdbtnOpcion2.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnOpcion2.setBounds(57, 251, 103, 21);
		frame.getContentPane().add(rdbtnOpcion2);
		rdbtnOpcion2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblEstasSobre.setText("Estas sobre la opcion 2");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblEstasSobre.setText("Estas sobre la");
			}
		});

		JRadioButton rdbtnOpcion3 = new JRadioButton("Opcion 3");
		rdbtnOpcion3.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnOpcion3.setBounds(57, 290, 103, 21);
		frame.getContentPane().add(rdbtnOpcion3);
		rdbtnOpcion3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblEstasSobre.setText("Estas sobre la opcion 3");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblEstasSobre.setText("Estas sobre la");
			}
		});

	}

}
