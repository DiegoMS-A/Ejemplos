import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Principal {

	// Declaración de variables
	private JFrame frame;
	private JTextField textFieldRestult;
	private int resultado = 0;
	private int numero;
	private JButton btnAgregar;

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

		// Se crea el JFrame (ventana principal)
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// Se crea el panel de pestañas y posiciona los marcadores en la parte alta
		JTabbedPane panelDePestanas = new JTabbedPane(JTabbedPane.TOP);
		panelDePestanas.setBounds(10, 10, 610, 450);

		// Se crea panel 1
		JPanel panel1 = new JPanel();
		panel1.setBounds(100, 100, 550, 300);
		panel1.setLayout(null);

		// Se añade panel1 a panel de pestañas
		panelDePestanas.addTab("Pestaña 1", panel1);

		// Se crea panel 2
		JPanel panel2 = new JPanel();
		panel2.setBounds(100, 100, 550, 300);
		panel2.setLayout(null);

		// Se añade panel2 a panel de pestañas
		panelDePestanas.addTab("Pestaña 2", panel2);

		// Se añade al frame el panel de pestañas
		frame.getContentPane().add(panelDePestanas);

		// Añadir y gestionar componentes VENTANA 1
		JSlider slider = new JSlider();

		// tamaño slider
		slider.setBounds(10, 10, 585, 103);

		// incluye los valores de 10 en 10 en el eje del slider
		slider.setMajorTickSpacing(10);
		// hace visible los valores en el slider
		slider.setPaintLabels(true);
		// hace visible las lineas de marca en el eje del Slider
		slider.setPaintTicks(true);
		// se añade slider
		panel1.add(slider);

		JButton btnSumar = new JButton("SUMAR");
		btnSumar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// retorna el valor del slider sumandose al valor anterior
				numero = slider.getValue();
				textFieldRestult.setText(String.valueOf(resultado + numero));
				resultado = resultado + numero;

			}
		});
		btnSumar.setBounds(253, 134, 87, 40);
		panel1.add(btnSumar);

		textFieldRestult = new JTextField();
		textFieldRestult.setBounds(242, 246, 116, 31);
		panel1.add(textFieldRestult);

		// Añadir y gestionar componentes VENTANA 2

		// Se instancia JList para almacenar tipo File (parte blanca de de la pestaña)
		JList<File> ListaArchivos = new JList<File>();
		ListaArchivos.setLocation(10, 10);
		ListaArchivos.setSize(585, 291);

		// Se instancia modelo para aplicar al JList
		DefaultListModel<File> modelo = new DefaultListModel<File>();

		// Se aplica modelo a JList
		ListaArchivos.setModel(modelo);
		JFileChooser selector = new JFileChooser();

		// se añade JList a panel 2
		panel2.add(ListaArchivos);

		btnAgregar = new JButton("AGREGAR");
		btnAgregar.setBounds(240, 367, 109, 34);
		panel2.add(btnAgregar);
		btnAgregar.addActionListener(new ActionListener() {

			// Evento pulsación botón, se abre diálogo selector ficheros y se añade al
			// modelo la ruta del archivo seleccionado mediante el selector
			public void actionPerformed(ActionEvent e) {
				selector.showDialog(panel2, "Selecciona fichero");
				modelo.addElement(selector.getSelectedFile());

			}
		});

	}

}
