import java.util.concurrent.Semaphore;

public class ParquePublico {

	@SuppressWarnings("removal")
	public static void main(String[] args) {		
	
		Contador contador = new Contador();
		Semaphore mutex = new Semaphore(1);
		
		Torno torno1 = new Torno(contador, mutex);
		Torno torno2 = new Torno(contador, mutex);
		Torno torno3 = new Torno(contador, mutex);
		
		torno1.start();
		torno2.start();
		torno3.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		torno1.stop();
		torno2.stop();
		torno3.stop();
		
		System.out.println("Al final del día, han pasado " + contador.obtenerContador() + " personas");
}
}