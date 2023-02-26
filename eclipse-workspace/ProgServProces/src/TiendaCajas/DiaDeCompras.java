package TiendaCajas;

public class DiaDeCompras {

	public static void main(String[] args) {
		int numCaja = 4;
		int numClientes = 30; // clientes totales que entraran en la tienda al final del día
		Tienda tienda = new Tienda();
		System.out.println(	"Durante el día entraran 30 clientes, "
				+ "solo pueden entrar 10 a la vez y ser atendidos de 1 en 1 en las 4 cajas disponibles");
		Cliente[] c = new Cliente[numClientes];
		for (int i = 0; i < numClientes; i++) {
			c[i] = new Cliente(i + 1, tienda);
			c[i].start();
		}

		Caja[] cj = new Caja[numCaja];
		for (int i = 0; i < numCaja; i++) {
			cj[i] = new Caja(i + 1, tienda);
			cj[i].start();
		}

		for (int i = 0; i < numCaja; i++) {
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("Hoy se ha cerrado la tienda con una recaudacion total de "
				+ (double) Math.round(tienda.getFacturacionTotal() * 100d) + " euros");
	}
}
