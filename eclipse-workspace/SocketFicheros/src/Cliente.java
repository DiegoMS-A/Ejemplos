import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Scanner sc = new Scanner(System.in);
			sc.useDelimiter("\n");
			Socket sck = new Socket("localhost", 7777);
			
			DataInputStream in = new DataInputStream(sck.getInputStream());
			DataOutputStream out = new DataOutputStream(sck.getOutputStream());
			
			String mensaje = in.readUTF();
			System.out.println(mensaje);
			
			String nombre = sc.next();
			out.writeUTF(nombre);
			
			ClienteHilo hilo = new ClienteHilo(in,out);
			hilo.start();
			hilo.join();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
