package TiendaCajas;

import java.util.PriorityQueue;
import java.util.concurrent.Semaphore;

public class Tienda {
	private Semaphore semaforoCaja;
	private Semaphore semaforoTienda;
	private PriorityQueue<Integer> listaClientes;
	private double facturacionTotal;

	public Tienda() {
		semaforoCaja = new Semaphore(1);
		semaforoTienda = new Semaphore(10);
		listaClientes = new PriorityQueue<>();
		facturacionTotal = 0;
	}

	public void nuevoCliente(Integer numeroCliente) {
		try {
			semaforoTienda.acquire();
			//semaforoCaja.acquire();
			listaClientes.add(numeroCliente);
			//semaforoCaja.release();
			semaforoTienda.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public int terminarCliente(double facturacionParcial) {
		int compra = 0;
		try {
			if (isClientePendientes()) {
				semaforoTienda.acquire();
				semaforoCaja.acquire();
				compra = listaClientes.remove();
				facturacionTotal += facturacionParcial;
				semaforoCaja.release();
				semaforoTienda.release();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return compra;
	}

	public boolean isClientePendientes() {
		return listaClientes.size() > 0;
	}

	public double getFacturacionTotal() {
		return facturacionTotal;
	}

}