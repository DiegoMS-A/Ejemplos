
public class Balsa extends Thread {	
	
	int identificador;
	PasoEstrecho paso;

	Balsa(PasoEstrecho paso, int identificador) {
		this.paso = paso;
		this.identificador = identificador;
	}

	@Override
	public void run() {	
		//synchronized(paso) {	
			try {
				paso.entrarPorNaufrago(identificador);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		//}
		}
	}
// ha quitado el synchronized