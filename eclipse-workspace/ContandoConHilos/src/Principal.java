import java.util.Scanner;

public class Principal extends Thread {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);		
		System.out.println("Introduce el limite hasta el que contar sus pares e impares");
		int limite = sc.nextInt();
		sc.close();
		
		Pares conteoPares = new Pares();		
		Impares conteoImpares = new Impares();
		
		conteoPares.ObtenerLimitePar(limite);
		conteoImpares.ObtenerLimiteImpar(limite);
		
		conteoPares.start();
		conteoImpares.start();
		conteoPares.join();
		conteoImpares.join(); // los hilos se esperan a morir a que termine el resto
	}
}


