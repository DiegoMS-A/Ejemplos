package Pistamulti;

import java.util.PriorityQueue;
import java.util.concurrent.Semaphore;

public class Principal {

	public static void main(String[] args) {
		int numPista = 4; // Cantidad de pistas
		int numClientes = 40; // Partidos totales que se jugarán en el día.
		Recinto recinto = new Recinto();
		System.out.println("Durante el dia se jugaran 40 partidos con 2 jugadores por equipo "
				+ "en las 4 pistas disponibles, el coste es 5 euros por jugador");

		Cliente[] c = new Cliente[numClientes];
		for (int i = 0; i < numClientes; i++) {
			c[i] = new Cliente(i + 1, recinto);
			c[i].start();
		}

		Pista[] cj = new Pista[numPista];
		for (int i = 0; i < numPista; i++) {
			cj[i] = new Pista(i + 1, recinto);
			cj[i].start();
		}

		for (int i = 0; i < numPista; i++) {
			try {
				cj[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		for (int i = 0; i < numClientes; i++) {
			try {
				c[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Se cierra el recinto con una recaudacion total de: " + recinto.getFacturacionTotal()
				+ " euros en las pistas");
	}
}

class Recinto {
	private Semaphore semaforoPista;
	private Semaphore semaforoRecinto;
	private PriorityQueue<Integer> listaClientes;
	private double facturacionTotal;

	public Recinto() {
		semaforoPista = new Semaphore(1);
		semaforoRecinto = new Semaphore(5);
		listaClientes = new PriorityQueue<>();
		facturacionTotal = 0;
	}

	public synchronized void nuevoCliente(Integer numeroCliente) {
		try {
			semaforoRecinto.acquire();
			listaClientes.add(numeroCliente);
			semaforoRecinto.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized int terminarCliente(double facturacionParcial) {
		int partido = 0;
		try {
			if (isClientePendientes()) {
				semaforoRecinto.acquire();
				semaforoPista.acquire();
				partido = listaClientes.remove();
				facturacionTotal += facturacionParcial;
				semaforoPista.release();
				semaforoRecinto.release();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return partido;
	}

	public synchronized boolean isClientePendientes() {
		return listaClientes.size() > 0;
	}

	public synchronized double getFacturacionTotal() {
		return facturacionTotal;
	}

}

class Cliente extends Thread {
	private int identif;
	private Recinto recinto;

	public Cliente(int identif, Recinto recinto) {
		this.identif = identif;
		this.recinto = recinto;
	}

	@Override
	public void run() {
		recinto.nuevoCliente(identif);
	}
}

class Pista extends Thread {
	private int identif;
	private Recinto recinto;
	private int facturacionPista;

	public Pista(int identif, Recinto recinto) {
		this.identif = identif;
		this.recinto = recinto;
		this.facturacionPista = 0;
	}

	@Override
	public void run() {
		int facturacion;
		int numeroCliente;
		while (recinto.isClientePendientes()) {
			try {
				facturacion = 20;
				facturacionPista += facturacion;
				numeroCliente = recinto.terminarCliente(facturacion);
				Thread.sleep((long) (Math.random() * 500));
				System.out.println("Los clientes integrantes del partido numero " + numeroCliente
						+ " del dia han entrado al recinto");
				Thread.sleep((long) (Math.random() * 1000));
				System.out.println(
						"El partido numero " + numeroCliente + " " + " ha comenzado en la pista numero " + identif);
				Thread.sleep((long) (Math.random() * 5000));
				System.out.println("La pista numero " + identif + " ha quedado libre, el partido numero "
						+ numeroCliente + " ha terminado");
				Thread.sleep((long) (Math.random() * 1000));
				System.out.println("Los integrantes del partido " + numeroCliente + " salen del recinto");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Se cierra la pista numero " + identif + ", con una recaudacion total de " + facturacionPista
				+ " euros");
	}
}
