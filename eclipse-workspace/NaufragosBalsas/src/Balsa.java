
public class Balsa extends Thread {	
	
	int identificador;
	PasoEstrecho paso;

	Balsa(PasoEstrecho paso, int identificador) {
		this.paso = paso;
		this.identificador = identificador;
	}

	@Override
	public void run() {	
		synchronized(paso) {	
			paso.entrarPorNaufrago(identificador);
		}
		}
	}
