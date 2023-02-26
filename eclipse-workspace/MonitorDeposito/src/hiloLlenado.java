
public class hiloLlenado extends Thread {
	private deposito l;

	public hiloLlenado(String n, deposito l) {
		setName(n);
		this.l = l;
	}

	public void run() {
		int valor = l.valor();

		for (int i = 0; i < 500; i++) {
			valor = l.valor();
			
			if (valor < 900) {
				l.llenado10();
				try {
					hiloLlenado.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} else if (valor >= 1000) {
				System.out.println("El deposito tiene 1000L, se ha parado el llenado. Funcionará por debajo de los 1000L");
				try {
					l.pararHilos();
					hiloLlenado.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} else {
				l.llenado5();
				try {
					hiloLlenado.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
