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

public class MenuAdmin {

	private JFrame frameAdmin;
	private JButton btnSalir;
	private JButton btnConsultar;
	private JButton btnInsertar;
	private JButton btnEliminar;
	private JButton btnActualizar;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					MenuAdmin window = new MenuAdmin();
					window.frameAdmin.setVisible(true);
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
	public MenuAdmin() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 *
	 * @throws IOException
	 */
	private void initialize() throws IOException {
		frameAdmin = new JFrame();
		frameAdmin.setResizable(false);
		frameAdmin.setIconImage(
				Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/graficos/fotos/logoV.png")));
		frameAdmin.setTitle("Plantillas NBA 22 - 23");
		frameAdmin.setTitle("MENU");
		frameAdmin.setBounds(100, 100, 730, 500);
		frameAdmin.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frameAdmin.getContentPane().setLayout(new BoxLayout(frameAdmin.getContentPane(), BoxLayout.Y_AXIS));

		ImageIcon back = new ImageIcon("src/graficos/fotos/fondotocado.jpg");
		JLabel background = new JLabel(back);
		background.setAlignmentX(Component.CENTER_ALIGNMENT);
		background.setSize(730, 500);
		frameAdmin.getContentPane().add(background);

		btnSalir = new JButton("SALIR");
		btnSalir.setBounds(265, 345, 190, 30);
		btnSalir.setForeground(new Color(255, 255, 255));
		btnSalir.setBackground(new Color(255, 0, 0));
		btnSalir.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 16));
		background.add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frameAdmin.dispose();

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
		btnConsultar.setBounds(265, 65, 190, 30);
		btnConsultar.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
		background.add(btnConsultar);

		btnInsertar = new JButton("INSERTA JUGADORES");
		btnInsertar.setSize(120, 30);
		btnInsertar.setBounds(265, 135, 190, 30);
		btnInsertar.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
		background.add(btnInsertar);

		btnEliminar = new JButton("ELIMINA JUGADORES");
		btnEliminar.setSize(120, 30);
		btnEliminar.setBounds(265, 205, 190, 30);
		btnEliminar.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
		background.add(btnEliminar);

		btnActualizar = new JButton("ACTUALIZA JUGADORES");
		btnActualizar.setSize(120, 30);
		btnActualizar.setBounds(265, 275, 190, 30);
		btnActualizar.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
		background.add(btnActualizar);

	}
	public JButton getBtnConsultar() {
		return btnConsultar;
	}
	public JButton getBtnSalir() {
		return btnSalir;
	}
}
