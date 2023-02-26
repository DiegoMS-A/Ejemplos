import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

class Productor implements Runnable {

    // Referencia a la cola compartida
    BlockingQueue<Integer> cola;

    public Productor(BlockingQueue<Integer> cola) {
        this.cola = cola;
    }

    @Override
    public void run() {
        for (int i = 0; i < 15; i++) {
            try {
                System.out.println("El productor produce: " + i);

                // Añadimos a la cola el objeto producido

                cola.put(i);
                Thread.currentThread().sleep(40);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class Consumidor implements Runnable {
    // Referencia a un objeto compartido
    private BlockingQueue<Integer> cola;

    Consumidor(BlockingQueue<Integer> cola) {
        this.cola = cola;
    }

    @Override
    public void run() {

        for (int i = 0; i < 15; i++) {
            try {
                System.out.println("El consumidor consume: " + ((LinkedBlockingDeque)cola).takeLast());

                Thread.currentThread().sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class ProdConsQueueLIFO {
    public static void main(String[] args) {

        // En lugar del ArrayBlockingQueue creamos un LinkedBlockingDeque
        // con capacidad para 3 elementos

        BlockingQueue<Integer> colaCompartida = new LinkedBlockingDeque<>(3);

        // Creamos los procesos a partir de Productor y Consumidor
        Thread p = new Thread(new Productor(colaCompartida));
        Thread c = new Thread(new Consumidor(colaCompartida));

        // Y los lanzamos
        p.start();
        c.start();

    }
}
