package principal;

import java.util.Date;
import java.util.GregorianCalendar;

public class Uso_Persona {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona[] lasPersonas = new Persona [2];
		
		lasPersonas[0] = new Empleado2 ("Luis Conde", 50000,2009,02,25);
		lasPersonas[1] = new Alumno ("Ana Lopez","Biologia");  //reglas es un...
		
		for (Persona persona : lasPersonas) {
			
			System.out.println(persona.dameNombre() + " " + persona.dameDescripcion());
		}
	}

}

abstract class Persona{
	
	public Persona(String nom) {
		
		
		nombre = nom;
		
	}
	
	public String dameNombre() {
		
		return nombre;
		
	}
	
	public abstract String dameDescripcion();//Se define para ser sobreescrito en las clases que hereden,
	

	private String nombre;
	
}

class Empleado2 extends Persona {

	public Empleado2(String nom, double sue, int agno, int mes, int dia) {
		
		super(nom);

		sueldo = sue;
		GregorianCalendar calendario = new GregorianCalendar(agno, mes - 1, dia);
		altaContrato = calendario.getTime();
		++IdSiguiente;
		Id=IdSiguiente;
	}
	
	@Override
	public String dameDescripcion() { //override del método abstracto de la clase persona
		
		return "Este empleado tiene un id = " + Id + " con un sueldo igual a " + sueldo;
	}
	
	
	public double dameSueldo() { 
		return sueldo; 
	}

	public String dameFechaContrato() {
		return "La fecha de alta de contrato es " + altaContrato; 
	}

	public void subeSueldo(double porcentaje) {

		double aumento = sueldo * porcentaje / 100;

		sueldo += aumento;
	}

	private double sueldo;
	private Date altaContrato;
	private static int IdSiguiente;
	private int Id;	

}

class Alumno extends Persona{
	
	public Alumno(String nom, String car) {
		
		super(nom);
		carrera = car;
		
	}
	
	private String carrera;

	@Override
	public String dameDescripcion() {
		
		return "Este alumno esta estudiando la carrera de " + carrera;
	}
}
