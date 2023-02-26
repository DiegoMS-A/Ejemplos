
public class compartirInfo {

	public static void main(String[] args) {
		deposito depos = new deposito((int) (Math.random()*1000)); //pruebo con varios hilos distintos, orginalmente lo hacia con 2
		hiloLlenado llenado = new hiloLlenado("HiloLLenado", depos);
		hiloVaciado	vaciado = new hiloVaciado("HiloVaciado", depos);
		hiloLlenado llenado2 = new hiloLlenado("HiloLLenado", depos);
		hiloVaciado	vaciado2 = new hiloVaciado("HiloVaciado", depos);
		hiloLlenado llenado3 = new hiloLlenado("HiloLLenado", depos);
		hiloVaciado	vaciado3 = new hiloVaciado("HiloVaciado", depos);
		hiloVaciado	vaciado4 = new hiloVaciado("HiloVaciado", depos);
		llenado.start();
		vaciado.start();	
		llenado2.start();
		vaciado2.start();
		llenado3.start();
		vaciado3.start();
		vaciado4.start();
		try {
			llenado.join();
			vaciado.join();
			llenado2.join();
			vaciado2.join();
			llenado3.join();
			vaciado3.join();
			vaciado4.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
