import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPCliente {

	public static void main(String[] args) {

		try (
				// Se crea el socket con IP o localhost
				// Socket miSocket = new Socket("192.168.1.132", 5555);
				Socket miSocket = new Socket("localhost", 7777)) {

			// Se crea el DataOutPutStream e DataInputStream y se asocia con el
			// getOut/InPutStrean del socket
			DataOutputStream salidaDatos = new DataOutputStream(miSocket.getOutputStream());
			DataInputStream entradaDatos = new DataInputStream(miSocket.getInputStream());

			// Para recibir y mostrar pregunta de edad
			String mensajeRecib = entradaDatos.readUTF();
			System.out.println(mensajeRecib);

			try (// Se inicia Scanner para dar entrada a los datos del usuario
				Scanner sc = new Scanner(System.in)) {
				String mensaje = sc.nextLine();
				// Utilizo writeUTF() en lugar de write() para poder usar String
				salidaDatos.writeUTF(mensaje);
				
				//Intercambio de mensajes con TPCServer
				mensajeRecib = entradaDatos.readUTF();
				System.out.println(mensajeRecib);
				mensaje = sc.nextLine();
				salidaDatos.writeUTF(mensaje);
				mensajeRecib = entradaDatos.readUTF();
				System.out.println(mensajeRecib);
			}
			// Ceerramos flujo datos
			salidaDatos.close();

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}
}
