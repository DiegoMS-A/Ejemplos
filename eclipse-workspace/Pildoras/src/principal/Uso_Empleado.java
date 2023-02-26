package principal;

import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;

public class Uso_Empleado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Jefatura jefe_RRHH = new Jefatura("Juan", 55000, 2006, 9, 25);
		jefe_RRHH.estableceIncentrivo(2570);

		Empleado[] misEmpleados = new Empleado[6];

		misEmpleados[0] = new Empleado("Paco Gomez", 85000, 1990, 12, 17);
		misEmpleados[1] = new Empleado("Ana Lopez", 95000, 1995, 6, 2);
		misEmpleados[2] = new Empleado("Paco Gomez", 105000, 2002, 03, 15);
		misEmpleados[3] = new Empleado("Antonio Fernandez", 47500, 2009, 11, 9);
		misEmpleados[4] = jefe_RRHH; // poliformismo en accion. Principio de sustitucion
		misEmpleados[5] = new Jefatura("Maria", 95000, 1999, 5, 26);

		/*
		 * double num1=7.5; int num2 = (int) num1; Casting
		 */

		Jefatura jefa_Finanzas = (Jefatura) misEmpleados[5]; // casting objetos

		jefa_Finanzas.estableceIncentrivo(5500);// aparece el metodo al hacer casting

		System.out.println(jefa_Finanzas.tomar_decisiones("Todos los empleados estan despedidos"));
		System.out.println("El Jefe: " + jefa_Finanzas.dameNombre()
				+ " tiene un bonus de: " + jefa_Finanzas.establece_bonus(500));
		
		System.out.println(misEmpleados[3].dameNombre() + " tiene un bonus de: " + misEmpleados[3].establece_bonus(200));

		/*
		 * Empleado director_comercial = new Jefatura("Sandra", 85000, 2012, 05,05);
		 * 
		 * Comparable ejemplo = new Empleado ("Elisabeth", 95000, 2011, 06, 07);
		 * 
		 * if(director_comercial instanceof Empleado) { // instanceof para saber a que
		 * clase pertenece
		 * 
		 * System.out.println("Es de tipo Jefatura"); } if(ejemplo instanceof
		 * Comparable) {
		 * 
		 * System.out.println("Implementa la interfaz comparable");
		 * 
		 * }
		 */

		for (int i = 0; i < misEmpleados.length; i++) {

			misEmpleados[i].subeSueldo(5);

		}

		for (int i = 0; i < misEmpleados.length; i++) {
			System.out.println(misEmpleados[i].dameNombre() + " " + misEmpleados[i].dameSueldo() + " "
					+ misEmpleados[i].dameFechaContrato());

		}

		Arrays.sort(misEmpleados);// ordena el array

		for (Empleado e : misEmpleados) {// for each mejorado
			System.out.println(e.dameNombre() + " " + e.dameSueldo());
		}
	}

}

class Empleado implements Comparable, Trabajadores { // para utilizar la clase Arrays

	public Empleado(String nom, double sue, int agno, int mes, int dia) {

		nombre = nom;
		sueldo = sue;
		GregorianCalendar calendario = new GregorianCalendar(agno, mes - 1, dia);
		altaContrato = calendario.getTime();
	}

	public Empleado(String nom) { // constructor sobrecargado con 1 parametro

		this(nom, 3000, 2000, 01, 01); // this: el constructor llama al otro constructor de la clase con los parametros
										// por defecto

	}

	public String dameNombre() {
		return "El nombre es " + nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double dameSueldo() { // si fuese public final double no se podria sobreescribir el metodo en Jefatura
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public String dameFechaContrato() {
		return "La fecha de alta de contrato es " + altaContrato;
	}

	public void setAltaContrato(Date altaContrato) {
		this.altaContrato = altaContrato;
	}

	public void subeSueldo(double porcentaje) {

		double aumento = sueldo * porcentaje / 100;

		sueldo += aumento;
	}

	private String nombre;
	private double sueldo;
	private Date altaContrato;

	@Override
	public int compareTo(Object miObjeto) { // obligado a implementar para utilizar el metodo sort

		Empleado otroEmpleado = (Empleado) miObjeto;

		if (this.sueldo < otroEmpleado.sueldo) {

			return -1;
		}

		if (this.sueldo > otroEmpleado.sueldo) {

			return 1;

		} // con else no funciona

		return 0;
	}

	@Override
	public double establece_bonus(double gratificacion) {

		return Trabajadores.bonus_base + gratificacion;
	}

}

class Jefatura extends Empleado implements Jefes {

	public Jefatura(String nom, double sue, int agno, int mes, int dia) {

		super(nom, sue, agno, mes, dia); // paso de parametros a constructor padre
	}

	public void estableceIncentrivo(double b) {

		incentivo = b;
	}

	public double dameSueldo() {

		double sueldoJefe = super.dameSueldo(); // para que llame a dameSueldo de la clase padre, no de jefatura

		return sueldoJefe + incentivo;
	}

	@Override // por la implementacion de la interface hay que desarrollar el metodo
	public String tomar_decisiones(String decision) {

		return "Un miembro de la direccion ha tomado la decision de: " + decision;
	}

	private double incentivo;

	@Override // por implementar interface Trabajadores
	public double establece_bonus(double gratificacion) {

		double prima = 2000;

		return Trabajadores.bonus_base + gratificacion + prima;
	}

}

class Director extends Jefatura {

	public Director(String nom, double sue, int agno, int mes, int dia) {

		super(nom, sue, agno, mes, dia); // paso de parametros a constructor padre
	}

}
