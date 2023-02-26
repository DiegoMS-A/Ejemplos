package TiendaCajas;

public class Cliente extends Thread {
	private int identif;
	private Tienda tienda;

	public Cliente(int identif, Tienda tienda) {
		this.identif = identif;
		this.tienda = tienda;
	}

	@Override
	public void run() {
		tienda.nuevoCliente(identif);
	}
}