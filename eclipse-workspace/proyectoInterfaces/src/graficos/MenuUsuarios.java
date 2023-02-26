package graficos;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import baseDeDatos.Conexion;

public class MenuUsuarios {

	private JFrame frameMenuUsuario;
	private JButton btnSalir;
	private JButton btnConsultar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					MenuUsuarios window = new MenuUsuarios();
					window.frameMenuUsuario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 *
	 * @throws IOException
	 */
	public MenuUsuarios() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 *
	 * @throws IOException
	 */
	private void initialize() throws IOException {
		frameMenuUsuario = new JFrame();
		frameMenuUsuario.setResizable(false);
		frameMenuUsuario.setIconImage(
				Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/graficos/fotos/logoV.png")));
		frameMenuUsuario.setTitle("Plantillas NBA 22 - 23");
		frameMenuUsuario.setTitle("MENU");
		frameMenuUsuario.setBounds(100, 100, 730, 500);
		frameMenuUsuario.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frameMenuUsuario.getContentPane().setLayout(new BoxLayout(frameMenuUsuario.getContentPane(), BoxLayout.Y_AXIS));

		ImageIcon back = new ImageIcon("src/graficos/fotos/fondotocado.jpg");
		JLabel background = new JLabel(back);
		background.setLabelFor(background);
		background.setAlignmentX(Component.CENTER_ALIGNMENT);
		background.setSize(730, 500);
		frameMenuUsuario.getContentPane().add(background);

		btnSalir = new JButton("SALIR");
		btnSalir.setBounds(265, 235, 190, 30);
		btnSalir.setForeground(new Color(255, 255, 255));
		btnSalir.setBackground(new Color(255, 0, 0));
		btnSalir.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 16));
		background.add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frameMenuUsuario.dispose();

			}
		});

		btnConsultar = new JButton("CONSULTAR PLANTILLAS");
		btnConsultar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Conexion con = new Conexion();
				try {
					con.getConexion();
					//frameMenuAdmin.setVisible(false);
					VistaConsultas.main(null);

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnConsultar.setSize(120, 30);
		btnConsultar.setBounds(265, 170, 190, 30);
		btnConsultar.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
		background.add(btnConsultar);

	}
	public JButton getBtnConsultar() {
		return btnConsultar;
	}
	public JButton getBtnSalir() {
		return btnSalir;
	}
}
