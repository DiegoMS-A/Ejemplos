import java.util.concurrent.Semaphore;

public class Prueba {

	public static void main(String[] args) {
		Naufragos naufragos = new Naufragos();
		Semaphore semaforo = new Semaphore(1);

		Balsa balsa1 = new Balsa(naufragos, semaforo, 1);
		Balsa balsa2 = new Balsa(naufragos, semaforo, 2);
		Balsa balsa3 = new Balsa(naufragos, semaforo, 3);

		balsa1.start();
		balsa2.start();
		balsa3.start();
	}
}

class Naufragos {

	private int total;

	Naufragos() {
		total = 10;
	}

	public void rescatar(int id) {

		if (total == 0) {
			System.out.println("Rescate finalizado para la balsa " + id);
		}
		if (total == 1) {
			total--;
			System.out.println("Rescate finalizado para la balsa " + id + " se esta llevando al ultimo naufrago");
		} else {
			System.out.println("La balsa numero: " + id + " entra a la zona de rescate");
			System.out.println("Se ha rescatado un naufrago, quedan " + obtenerNaufragos());
			total--;

		}
	}

	public int obtenerNaufragos() {
		return total;
	}
}

class Balsa extends Thread {
	private Naufragos naufrago;
	private Semaphore semaforo;
	private int id;

	Balsa(Naufragos naufrago, Semaphore semaforo, int id) {
		this.naufrago = naufrago;
		this.semaforo = semaforo;
		this.id = id;
	}

	public void run() {
		try {
			sleep((int) (Math.random() * 10));
			semaforo.acquire();
		} catch (InterruptedException ex) {
			System.out.println(ex.getMessage());
		}
		naufrago.rescatar(id);
		semaforo.release();

	}
}