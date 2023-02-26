public class Pares extends Thread {

	protected int limite_par;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int total = 0;
		for (int i = 1; i < limite_par+1; i++) {
			if (i%2==0) {
				total++;
				System.out.println(i + " es par en " + limite_par);
			}		
		
		}System.out.println(limite_par + " tiene un total de: " + total + " pares");		
	}
	public void ObtenerLimitePar(int valor) {
		this.limite_par = valor;
	}
}
