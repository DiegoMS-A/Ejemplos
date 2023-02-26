package principal;

public class Pruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Empleados trabajador1 = new Empleados("Paco");
		Empleados trabajador2 = new Empleados("Ana");
		Empleados trabajador3 = new Empleados("Antonio");
		Empleados trabajador4 = new Empleados("Rosa");		
		trabajador1.cambiaSeccion("RRHHH"); // setter para cambiar estado inicial	
		
				
		System.out.println(trabajador1.devuelveDatos());		
		
		System.out.println(trabajador2.devuelveDatos());		
		
		System.out.println(trabajador3.devuelveDatos());
		
		System.out.println(trabajador4.devuelveDatos());

	}

}

class Empleados{
	
	public Empleados(String nom) {
		
		nombre=nom;
		seccion="Administracion";
		Id = IdSiguiente;
		IdSiguiente++;
		
	}
	
	public void cambiaSeccion(String seccion) {//setter
		
		this.seccion=seccion;
		
	}
	
	public String devuelveDatos() {
		
		return "El nombre es: " + nombre + " y la seccion es " + seccion + " y el Id " + Id;
	}
	
	public static String dameIdSiguiente() {// solo puede acceder a variables estaticas
		
		return "El Id siguiente es " + IdSiguiente; 
	}
	
	private final String nombre; //hacer constante nombre, que no cambiará
	private String seccion;
	private int Id;
	private static int IdSiguiente=1; // variable de clase, no de objeto por Static
	
}