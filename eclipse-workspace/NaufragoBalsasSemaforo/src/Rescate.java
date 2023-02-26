import java.util.concurrent.Semaphore;

public class Rescate extends Thread {

	private static Semaphore pasoEstrecho = new Semaphore(1);
	private int identificador = 0;	
	private int naufragos = 2;	
	

	public Rescate(int identificador) {
		this.identificador = identificador;
		
	}

	public void run() {
		while (naufragos != 0) {
			try {
				pasoEstrecho.acquire();
				Thread.sleep(500);
				System.out.println("La balsa " + this.identificador + " entra al paso a rescatar");
				naufragos--;
				pasoEstrecho.release();
				System.out.println("La balsa " + this.identificador + " sale del paso con un naufrago");
			} catch (InterruptedException ex) {
				System.out.println(ex.getMessage());
			}

		}

	}

	public static void main(String[] args) {
		int balsaRescate = 3;		
		for (int i = 1; i <= balsaRescate; i++) {
			new Rescate(i).start();
		}

	}

}