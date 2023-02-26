import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ClienteHilo extends Thread {

	private DataInputStream in;
	private DataOutputStream out;

	public ClienteHilo(DataInputStream in, DataOutputStream out) {
		this.in = in;
		this.out = out;
	}

	public void run() {

		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		boolean salir = false;
		String mensaje;

		while (!salir) {

			System.out.println("1. Guardar numero en el archivo");
			System.out.println("2. Leer numeros en el archivo");
			System.out.println("3. Salir");

			opcion = sc.nextInt();
			try {
				out.writeInt(opcion);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			switch (opcion) {
			case 1:
				int numeroAleatorio= generaNumeroAleatorio(1, 100);
				try {
					System.out.println("numero generado: " + numeroAleatorio);
					out.writeInt(numeroAleatorio);
					mensaje = in.readUTF();
					System.out.println(mensaje);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				break;

			case 2:
				try {
					mensaje = in.readUTF();
					System.out.println(mensaje);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;

			case 3:
				salir = true;
				break;

			default:
				try {
					mensaje = in.readUTF();
					System.out.println(mensaje);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
	}

	public int generaNumeroAleatorio(int minimo, int maximo) {
		int num = (int) Math.floor(Math.random() * (maximo - minimo + 1) + (minimo));
		return num;

	}

}
