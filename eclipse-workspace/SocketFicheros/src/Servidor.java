import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			ServerSocket server = new ServerSocket (7777);
			Socket sck;
			
			System.out.println("Servidor iniciado");
			while(true) {
				sck = server.accept();
				DataInputStream in = new DataInputStream(sck.getInputStream());
				DataOutputStream out = new DataOutputStream(sck.getOutputStream());
				
				out.writeUTF("Escribe tu nombre");
				String nombreCliente = in.readUTF();
				
				ServidorHilo hilo = new ServidorHilo(in, out, nombreCliente);
				hilo.start();
				
				System.out.println("Conexion creada con el cliente " + nombreCliente);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
