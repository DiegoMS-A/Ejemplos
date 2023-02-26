package graficos;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import org.mariadb.jdbc.Connection;

public class VistaConsultas {

	private JFrame frameConsultas;
	private DefaultTableModel modelo = new DefaultTableModel();
	private String[] datos = new String[7];// posición dependeera del numero de columnas
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField textNombre;
	private JButton btnLimpiar;
	private JButton btnVolverMenu;
	private JButton btnBuscar;
	private JTextField textMenorEdad;
	private JTextField textMayorAltura;
	private JTextField textMayorEdad;
	private JTextField textMenorAltura;
	private JComboBox comboBox;
	private JRadioButton rdbtnBase;
	private JRadioButton rdbtnEscolta;
	private JRadioButton rdbtnAlero;
	private JRadioButton rdbtnAlapivot;
	private JRadioButton rdbtnPivot;
	private String equipo;
	private String nombre;
	private String posicion1;
	private String posicion2;
	private String posicion3;
	private String posicion4;
	private String posicion5;
	private int edadMax;
	private int edadMin;
	private float alturaMax;
	private float alturaMin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					VistaConsultas window = new VistaConsultas();
					window.frameConsultas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VistaConsultas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameConsultas = new JFrame();
		frameConsultas.setBounds(100, 100, 730, 500);
		frameConsultas.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frameConsultas.setIconImage(
				Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/graficos/fotos/logoV.png")));
		frameConsultas.setResizable(false);
		frameConsultas.setTitle("Plantillas NBA 22 - 23");
		frameConsultas.setBounds(100, 100, 730, 500);

		table = new JTable();
		modelo.addColumn("ID");
		modelo.addColumn("Nombre");
		modelo.addColumn("Equipo");
		modelo.addColumn("Posicion");
		modelo.addColumn("Altura");
		modelo.addColumn("Edad");
		frameConsultas.getContentPane().setLayout(null);
		table.setModel(modelo);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 696, 256);
		frameConsultas.getContentPane().add(scrollPane);
		scrollPane.setViewportView(table);

		btnLimpiar = new JButton("LIMPIAR PANTALLA");
		btnLimpiar.setBounds(10, 432, 137, 21);
		frameConsultas.getContentPane().add(btnLimpiar);

		btnVolverMenu = new JButton("VOLVER A MENU");
		btnVolverMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frameConsultas.setVisible(false);
				// Login.main(null);
			}
		});
		btnVolverMenu.setBounds(574, 432, 130, 21);
		frameConsultas.getContentPane().add(btnVolverMenu);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Todos los equipos", "Atlanta Hawks" }));
		comboBox.setBounds(10, 299, 137, 19);
		frameConsultas.getContentPane().add(comboBox);

		rdbtnBase = new JRadioButton("Base");
		rdbtnBase.setSelected(true);
		rdbtnBase.setBounds(338, 295, 103, 21);
		frameConsultas.getContentPane().add(rdbtnBase);

		rdbtnAlero = new JRadioButton("Alero");
		rdbtnAlero.setSelected(true);
		rdbtnAlero.setBounds(338, 341, 103, 21);
		frameConsultas.getContentPane().add(rdbtnAlero);

		rdbtnAlapivot = new JRadioButton("Ala-Pivot");
		rdbtnAlapivot.setSelected(true);
		rdbtnAlapivot.setBounds(338, 364, 103, 21);
		frameConsultas.getContentPane().add(rdbtnAlapivot);

		rdbtnEscolta = new JRadioButton("Escolta");
		rdbtnEscolta.setSelected(true);
		rdbtnEscolta.setBounds(338, 318, 103, 21);
		frameConsultas.getContentPane().add(rdbtnEscolta);

		rdbtnPivot = new JRadioButton("Pivot");
		rdbtnPivot.setSelected(true);
		rdbtnPivot.setBounds(338, 387, 103, 21);
		frameConsultas.getContentPane().add(rdbtnPivot);

		JLabel lblMenorEdad = new JLabel("Menor a");
		lblMenorEdad.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenorEdad.setBounds(471, 345, 56, 13);
		frameConsultas.getContentPane().add(lblMenorEdad);

		JLabel lblMayorEdad = new JLabel("Mayor a");
		lblMayorEdad.setHorizontalAlignment(SwingConstants.CENTER);
		lblMayorEdad.setBounds(471, 302, 56, 13);
		frameConsultas.getContentPane().add(lblMayorEdad);

		JLabel lblMayorAltura = new JLabel("Mayor a");
		lblMayorAltura.setHorizontalAlignment(SwingConstants.CENTER);
		lblMayorAltura.setBounds(601, 302, 63, 13);
		frameConsultas.getContentPane().add(lblMayorAltura);

		JLabel lblMenorAltura = new JLabel("Menor a");
		lblMenorAltura.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenorAltura.setBounds(601, 345, 63, 13);
		frameConsultas.getContentPane().add(lblMenorAltura);

		textMenorEdad = new JTextField();
		textMenorEdad.setBounds(471, 365, 56, 19);
		frameConsultas.getContentPane().add(textMenorEdad);
		textMenorEdad.setColumns(10);

		textMayorAltura = new JTextField();
		textMayorAltura.setColumns(10);
		textMayorAltura.setBounds(601, 319, 63, 19);
		frameConsultas.getContentPane().add(textMayorAltura);

		textMayorEdad = new JTextField();
		textMayorEdad.setColumns(10);
		textMayorEdad.setBounds(471, 319, 56, 19);
		frameConsultas.getContentPane().add(textMayorEdad);

		textMenorAltura = new JTextField();
		textMenorAltura.setColumns(10);
		textMenorAltura.setBounds(601, 365, 63, 19);
		frameConsultas.getContentPane().add(textMenorAltura);

		JLabel lblEquipo = new JLabel("EQUIPO");
		lblEquipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblEquipo.setBounds(53, 276, 56, 13);
		frameConsultas.getContentPane().add(lblEquipo);

		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBounds(208, 276, 56, 13);
		frameConsultas.getContentPane().add(lblNombre);

		JLabel lblPosicion = new JLabel("POSICION");
		lblPosicion.setHorizontalAlignment(SwingConstants.CENTER);
		lblPosicion.setBounds(356, 276, 63, 13);
		frameConsultas.getContentPane().add(lblPosicion);

		JLabel lblEdad = new JLabel("EDAD");
		lblEdad.setHorizontalAlignment(SwingConstants.CENTER);
		lblEdad.setBounds(471, 276, 49, 13);
		frameConsultas.getContentPane().add(lblEdad);

		JLabel lblAltura = new JLabel("ALTURA");
		lblAltura.setHorizontalAlignment(SwingConstants.CENTER);
		lblAltura.setBounds(601, 276, 56, 13);
		frameConsultas.getContentPane().add(lblAltura);

		textNombre = new JTextField();
		textNombre.setHorizontalAlignment(SwingConstants.CENTER);
		textNombre.setBounds(171, 299, 137, 19);
		frameConsultas.getContentPane().add(textNombre);
		textNombre.setColumns(10);

		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBounds(315, 432, 85, 21);
		frameConsultas.getContentPane().add(btnBuscar);
		btnBuscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					modelo.setRowCount(0);// limpiar tabla si es que la hay para nueva busqueda
					Connection miConexion = (Connection) DriverManager
							.getConnection("jdbc:mariadb://127.0.0.1:3306/nba", "root", "");

					nombre = "%" + textNombre.getText() + "%";
					equipo = comboBox.getSelectedItem().toString();
					posicion1 = "";
					posicion2 = "";
					posicion3 = "";
					posicion4 = "";
					posicion5 = "";

					PreparedStatement miSentencia = miConexion.prepareStatement(
							"SELECT * FROM nba WHERE (nombre LIKE ?) AND (equipo LIKE ?) AND (posicion LIKE ? OR posicion LIKE ? OR posicion LIKE ?"
									+ " OR posicion LIKE ? OR posicion LIKE ?) AND (edad BETWEEN ? AND ?) AND (altura BETWEEN ? AND ? )");

					if (nombre.length() == 0) {
						nombre = "%";
						miSentencia.setString(1, nombre);
					} else {
						miSentencia.setString(1, nombre);
					}

					if (equipo == "Todos los equipos") {
						equipo = "%";
						miSentencia.setString(2, equipo);
					} else {
						miSentencia.setString(2, equipo);
					}

					if (rdbtnBase.isSelected()) {
						posicion1 = "Base";
						miSentencia.setString(3, posicion1);
					} else {
						posicion1 = "";
						miSentencia.setString(3, posicion1);
					}
					if (rdbtnEscolta.isSelected()) {
						posicion2 = "Escolta";
						miSentencia.setString(4, posicion2);
					} else {
						posicion2 = "";
						miSentencia.setString(4, posicion2);
					}
					if (rdbtnAlero.isSelected()) {
						posicion3 = "Alero";
						miSentencia.setString(5, posicion3);
					} else {
						posicion3 = "";
						miSentencia.setString(5, posicion3);
					}
					if (rdbtnAlapivot.isSelected()) {
						posicion4 = "Ala-Pivot";
						miSentencia.setString(6, posicion4);
					} else {
						posicion4 = "";
						miSentencia.setString(6, posicion4);
					}
					if (rdbtnPivot.isSelected()) {
						posicion5 = "Pivot";
						miSentencia.setString(7, posicion5);
					} else {
						posicion5 = "";
						miSentencia.setString(7, posicion5);
					}

					if (textMayorEdad.getText().length() > 0 && textMenorEdad.getText().length() > 0) {
						try {
							edadMax = Integer.parseInt(textMayorEdad.getText());
							edadMin = Integer.parseInt(textMenorEdad.getText());
							miSentencia.setInt(8, edadMax);
							miSentencia.setInt(9, edadMin);

						} catch (NumberFormatException y) {
							JOptionPane.showMessageDialog(null, "Introduce correctamente la edad");
							edadMax = 99;
							edadMin = 1;
							miSentencia.setInt(9, edadMax);
							miSentencia.setInt(8, edadMin);
						}
					} else {
						edadMax = 99;
						edadMin = 1;
						miSentencia.setInt(9, edadMax);
						miSentencia.setInt(8, edadMin);
					}
					System.out.println(textMayorAltura.getText().length());
					System.out.println(textMenorAltura.getText().length());
					if (textMayorAltura.getText().length() > 0 && textMenorAltura.getText().length() > 0) {
						try {
							alturaMax = Float.parseFloat(textMayorAltura.getText());
							alturaMin = Float.parseFloat(textMenorAltura.getText());
							miSentencia.setFloat(10, alturaMax);
							miSentencia.setFloat(11, alturaMin);
						} catch (NumberFormatException z) {
							JOptionPane.showMessageDialog(null, "Introduce correctamente la altura");
							alturaMax = 3f;
							alturaMin = 0.1f;
							miSentencia.setFloat(11, alturaMax);
							miSentencia.setFloat(10, alturaMin);

						}
					} else {
						alturaMax = 3f;
						alturaMin = 0.1f;
						miSentencia.setFloat(11, alturaMax);
						miSentencia.setFloat(10, alturaMin);
					}

					System.out.println(miSentencia);

					ResultSet rs = miSentencia.executeQuery();

					// mientras queden filas pendiente añade los datos de la rs a la columna
					while (rs.next()) {
						datos[0] = rs.getString(1);
						datos[1] = rs.getString(2);
						datos[2] = rs.getString(3);
						datos[3] = rs.getString(4);
						datos[4] = rs.getString(5);
						datos[5] = rs.getString(6);
						modelo.addRow(datos);

					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

	}

	public JButton getBtnLimpiar() {
		return btnLimpiar;
	}

	public JButton getBtnVolverMenu() {
		return btnVolverMenu;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public JComboBox getComboBox() {
		return comboBox;
	}

	public JRadioButton getRdbtnBase() {
		return rdbtnBase;
	}

	public JRadioButton getRdbtnEscolta() {
		return rdbtnEscolta;
	}

	public JRadioButton getRdbtnAlero() {
		return rdbtnAlero;
	}

	public JRadioButton getRdbtnAlapivot() {
		return rdbtnAlapivot;
	}

	public JRadioButton getRdbtnPivot() {
		return rdbtnPivot;
	}

	public JTextField getTextNombre() {
		return textNombre;
	}
}
