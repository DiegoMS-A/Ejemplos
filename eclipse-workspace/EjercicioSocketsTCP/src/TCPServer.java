import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) {

		// Se crea ServerSocket con el puerto indicado en TCPCLiente
		try (
		ServerSocket miServidor = new ServerSocket(7777)) {

			// Se crea socket y se deja a la escucha aceptando las peticiones por el puerto 7777
			Socket miSocket = miServidor.accept();

			// Se crea flujo de datos salida y se envia pregunta nombre
			DataOutputStream salidaDatos = new DataOutputStream(miSocket.getOutputStream());
			salidaDatos.writeUTF("¿Como te llamas?, introduce los datos con el teclado");
			
			//Se recibe respuesta nombre
			DataInputStream entradaDatos = new DataInputStream(miSocket.getInputStream());
			String mensaje = entradaDatos.readUTF();
			
			//Se manda pregunta edad incluyendo el nombre
			salidaDatos.writeUTF("¿Que edad tienes " + mensaje + " ?");			
			
			//Se recibe respuesta edad
			mensaje = entradaDatos.readUTF();
			//System.out.println(mensaje);
			
			//Se convierte a int la edad y se evaluando que ha sido introducida correctamente
			try {
				int edad = Integer.valueOf(mensaje);
				if (edad >= 18) {
					salidaDatos.writeUTF("Eres mayor de edad, hasta luego");
				}
				if (edad <= 18) {
					salidaDatos.writeUTF("Eres menor de edad, hasta pronto");
				}
			} catch (NumberFormatException ex) {
				salidaDatos.writeUTF("Edad introducida incorrectamente, cerrada sesion");
			}

			 miSocket.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}