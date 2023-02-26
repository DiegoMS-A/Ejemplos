
public class Impares extends Thread {
	protected int limite_impar;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int total = 0;
		for (int i = 1; i < limite_impar+1; i++) {
			if (i%2!=0) {
				total++;
				System.out.println(i + " es impar en " + limite_impar);
			}		
		
		}System.out.println(limite_impar + " tiene un total de: " + total + " impares");		
	}
	public void ObtenerLimiteImpar(int valor) {
		this.limite_impar = valor;
	}
}
