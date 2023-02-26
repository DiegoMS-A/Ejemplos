package graficos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import baseDeDatos.Conexion;
import baseDeDatos.GestionBD;

public class Login {

	private JFrame frmPlantillasNba;
	private JPanel frame_center;
	private JPanel frame_south;
	private JButton btnUsuario;
	private JButton btnAdministrador;
	private JLabel lblCabecera;
	private JLabel lblUsuario;
	private JTextField textFieldUsuario;
	private JLabel lblPassword;
	private JPasswordField passwordField;
	private JLabel lblLogoIzq;
	private JLabel lblLogoDcho;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Login window = new Login();
					window.frmPlantillasNba.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPlantillasNba = new JFrame();
		frmPlantillasNba.setIconImage(
				Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/graficos/fotos/logoV.png")));
		frmPlantillasNba.getContentPane().setBackground(new Color(102, 102, 102));
		frmPlantillasNba.setResizable(false);
		frmPlantillasNba.setTitle("Plantillas NBA 22 - 23");
		frmPlantillasNba.setBounds(100, 100, 730, 500);
		frmPlantillasNba.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frmPlantillasNba.getContentPane().setLayout(new BorderLayout(5, 5));
		frame_center = new JPanel();
		frame_center.setBackground(new Color(102, 102, 102));
		frame_south = new JPanel();
		frame_south.setBackground(new Color(102, 102, 102));
		FlowLayout fl_frame_south = new FlowLayout();
		fl_frame_south.setHgap(50);
		fl_frame_south.setVgap(25);
		frame_south.setLayout(fl_frame_south);
		frmPlantillasNba.getContentPane().add(frame_center, BorderLayout.CENTER);
		GridBagLayout gbl_frame_center = new GridBagLayout();
		gbl_frame_center.columnWidths = new int[] { 250, 128, 30, 30 };
		gbl_frame_center.rowHeights = new int[] { 20, 30, 0, 0, 0, 0, 0, 0 };
		gbl_frame_center.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0 };
		gbl_frame_center.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		frame_center.setLayout(gbl_frame_center);

		lblUsuario = new JLabel("Introduce tu usuario");
		lblUsuario.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 1;
		gbc_lblUsuario.gridy = 1;
		frame_center.add(lblUsuario, gbc_lblUsuario);

		textFieldUsuario = new JTextField();
		textFieldUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_textFieldUsuario = new GridBagConstraints();
		gbc_textFieldUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldUsuario.gridx = 1;
		gbc_textFieldUsuario.gridy = 2;
		frame_center.add(textFieldUsuario, gbc_textFieldUsuario);
		textFieldUsuario.setColumns(5);

		lblPassword = new JLabel("Introduce tu password");
		lblPassword.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 3;
		frame_center.add(lblPassword, gbc_lblPassword);

		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 4;
		frame_center.add(passwordField, gbc_passwordField);
		frmPlantillasNba.getContentPane().add(frame_south, BorderLayout.SOUTH);

		btnAdministrador = new JButton("ADMINISTRADOR");
		btnAdministrador.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Conexion con = new Conexion();
				GestionBD gestion = new GestionBD();
				String user = textFieldUsuario.getText();
				@SuppressWarnings("deprecation")
				String pass = passwordField.getText();
				try {
					con.getConexion();
					//gestion.comprobarAdministrador(user, pass);
					if (gestion.comprobarAdministrador(user, pass)){
						JOptionPane.showMessageDialog(null, "Login correcto");
						frmPlantillasNba.setVisible(false);
						MenuAdmin.main(null);

					}else {
						JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecto");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		frame_south.add(btnAdministrador);

		btnUsuario = new JButton("USUARIO");
		btnUsuario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Conexion con = new Conexion();
				GestionBD gestion = new GestionBD();
				String user = textFieldUsuario.getText();
				@SuppressWarnings("deprecation")
				String pass = passwordField.getText();
				try {
					con.getConexion();
					if (gestion.comprobarUsuarios(user, pass)){
						JOptionPane.showMessageDialog(null, "Login correcto");
						frmPlantillasNba.setVisible(false);
						MenuAdmin.main(null);
					}else {
						JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecto");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		frame_south.add(btnUsuario);

		lblCabecera = new JLabel("LOGIN");
		lblCabecera.setIcon(new ImageIcon(Login.class.getResource("/graficos/fotos/nbaheader2.jpg")));
		lblCabecera.setForeground(new Color(255, 255, 255));
		lblCabecera.setFont(new Font("Bookman Old Style", Font.BOLD, 30));
		lblCabecera.setHorizontalAlignment(SwingConstants.CENTER);
		frmPlantillasNba.getContentPane().add(lblCabecera, BorderLayout.NORTH);

		lblLogoIzq = new JLabel("");
		lblLogoIzq.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogoIzq.setIcon(new ImageIcon(Login.class.getResource("/graficos/fotos/logoHmuypeque.png")));
		frmPlantillasNba.getContentPane().add(lblLogoIzq, BorderLayout.WEST);

		lblLogoDcho = new JLabel("");
		lblLogoDcho.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogoDcho.setIcon(new ImageIcon(Login.class.getResource("/graficos/fotos/logoHmuypeque.png")));
		frmPlantillasNba.getContentPane().add(lblLogoDcho, BorderLayout.EAST);

	}

	public JButton getBtnAdministrador() {
		return btnAdministrador;
	}
	public JButton getBtnUsuario() {
		return btnUsuario;
	}
}
