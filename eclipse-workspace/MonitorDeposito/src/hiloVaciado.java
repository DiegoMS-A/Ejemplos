
public class hiloVaciado extends Thread {
	private deposito l;

	public hiloVaciado(String n, deposito l) {
		setName(n);
		this.l = l;
	}

	public void run() {
		int valor = l.valor();
		for (int i = 0; i < 500; i++) {			
			valor = l.valor();	
			
			if (valor >= 900) {
				l.vaciado5();
				try {
					hiloVaciado.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} else if (valor >= 1000) {
				l.vaciado10();
				try {
					hiloVaciado.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} else {
				try {		
					l.pararHilos();
					hiloVaciado.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}System.out.println("Proceso de vaciado en marcha");
			
				
			}
			
		}
	}
}
