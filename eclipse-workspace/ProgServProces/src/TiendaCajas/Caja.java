package TiendaCajas;

class Caja extends Thread {
	private int identif;
	private Tienda tienda;
	private double facturacionCaja;

	public Caja(int identif, Tienda tienda) {
		this.identif = identif;
		this.tienda = tienda;
		this.facturacionCaja = 0;
	}

	@Override
	public void run() {
		double facturacion;
		int numeroCliente;
		while (tienda.isClientePendientes()) {
			try {
				facturacion = Math.random() * 100;
				facturacionCaja += facturacion;
				numeroCliente = tienda.terminarCliente(facturacion);
				Thread.sleep((long) (Math.random() * 1000));
				System.out.println("El cliente " + numeroCliente + " ha entrado a la tienda");
				Thread.sleep((long) (Math.random() * 1000));
				System.out.println("La caja " + identif + " ha atendido al cliente numero " + numeroCliente
						+ " con una recaudacion de " + Math.round(facturacion * 100d) / 100d + " euros");
				Thread.sleep((long) (Math.random() * 1000));
				System.out.println("El cliente " + numeroCliente + " sale de la tienda");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Cierre de caja numero " + identif + ", con una recaudacion total de "
				+ Math.round(facturacionCaja * 100d) / 100d + " euros");
	}
}


