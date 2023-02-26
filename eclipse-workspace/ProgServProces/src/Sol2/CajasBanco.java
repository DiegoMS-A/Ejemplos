package Sol2;

public class CajasBanco {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Banco b = new Banco();

		for (int i = 0; i < 100; i++) {

			EjecucionTransferencias r= new EjecucionTransferencias(b,i,2000);

			Thread t= new Thread(r);

			t.start();

		}
	}

}

class Banco {

	public Banco() {

		cuentas = new double[100];// array para crear las 100 cuentas.

		for (int i = 0; i < cuentas.length; i++) {

			cuentas[i] = 2000; // se da de saldo 2000 euros a cada 1 de las 100 cuentas.

		}
	}

	public void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad) {

		if (cuentas[cuentaOrigen] < cantidad) { // evalua que el saldo no es inf a la transferencia

			return;
		}

		System.out.println(Thread.currentThread());

		cuentas[cuentaOrigen] -= cantidad; // dinero que sale de la cuenta origen

		System.out.printf("%10.2f de %d para %d", cantidad, cuentaOrigen, cuentaDestino);

		cuentas[cuentaDestino] += cantidad;

		System.out.printf(" Saldo total: %10.2f%n", getSaldoTotal());

	}

	public double getSaldoTotal() {

		double suma_cuentas = 0;

		for (double a : cuentas) {
			suma_cuentas += a;
		}
		return suma_cuentas; // retorna la suma de todas las cuentas
	}

	private final double[] cuentas;
}

	class EjecucionTransferencias implements Runnable {

		public EjecucionTransferencias(Banco b, int de, double max) {

			banco=b;
			deLaCuenta=de;
			cantidadMax=max;

		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {

			while(true) {    //bucle infinito

				int paraLaCuenta=(int)(100*Math.random());

				double cantidad=cantidadMax*Math.random();

				banco.transferencia(deLaCuenta, paraLaCuenta, cantidad);


					Thread.sleep((int)Math.random()*10);

				}

			} catch(InterruptedException e) {}

		}

		private Banco banco;
		private int deLaCuenta;
		private double cantidadMax;

	}