
public class deposito {

	private int l = 0;
	
	public deposito(int l) {
		this.l = l;
	}

	public synchronized void llenado10() {
		l = l + 10;
		System.out.println("Se ha llenado el deposito 10L, el deposito tiene " + valor() + " litros");
		if(l>=1000) {
			notifyAll();//para revaaluar los limites 
		}
	}

	public synchronized void vaciado5() {
		l = l - 5;
		System.out.println("Se ha vaciado el deposito 5L, el deposito tiene " + valor() + " litros");
		if(l<1000) {
			notifyAll();//para revaaluar los limites 
		}
	}

	public synchronized void vaciado10() {
		l = l - 10;
		System.out.println("Se ha vaciado el deposito 10L, el deposito tiene " + valor() + " litros");
		if(l<1000) {
			notifyAll();//para revaaluar los limites 
		}
	}

	public synchronized void llenado5() {
		l = l + 5;
		if(l>=1000) {
			notifyAll(); //para revaaluar los limites 
			}
		System.out.println("Se ha llenado el deposito 5L, el deposito tiene " + valor() + " litros");

	}
	
	public synchronized void pararHilos() { //manda dormir a los hilos cuando se supera el limite
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected int valor() {
		
		return this.l;
	}

	void set(int litro) {
		
		this.l = litro;
	}

}
