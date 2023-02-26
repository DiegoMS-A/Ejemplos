import java.util.concurrent.Semaphore;

public class Torno extends Thread {
	private Contador contador;
	private Semaphore mutex;

	Torno(Contador contador, Semaphore mutex) {
		this.contador = contador;
		this.mutex = mutex;
	}

	public void run() {
		while (true) {
			try {
				//espera a detectar persona
				sleep((int) (Math.random() * 10));
				try {
					mutex.acquire();					
				} catch (InterruptedException ex) {
					System.out.println(ex.getMessage());
				}
				contador.incrementar();
				mutex.release();
			} catch (InterruptedException ex) {
				ex.getMessage();
			}
		}
	}
}