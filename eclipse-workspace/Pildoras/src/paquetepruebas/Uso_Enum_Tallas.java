package paquetepruebas;

import java.util.Scanner;

public class Uso_Enum_Tallas { // uso de tipo enumerado, variable obj de tipo enum que almacena un grupo
								// valores y ningun otro.

	// enum Talla{MINI, MEDIANO, GRANDE, MUY_GRANDE} // Hay que declararlo fuera del
	// main

	enum Talla {

		MINI("S"), MEDIANO("M"), GRADE("L"), MUY_GRANDE("XL");// NOMBRE Y ABREVIATURA

		private Talla(String abreviatura) {// LOS ENUM NO ADMITEN CREACION DE OJETOS, EL CONSTRUCTOR TIENE QUE SER
											// PRIVATE

			this.abreviatura = abreviatura;
		}

		public String dameAbreviatura() {

			return abreviatura;
		}

		private String abreviatura;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner entrada = new Scanner(System.in);

		System.out.println("Escribe una talla para conocer su abreviatura: MINI, MEDIANO, GRANDE, MUY GRANDE");

		String entrada_datos = entrada.next().toUpperCase();

		Talla la_Talla = Enum.valueOf(Talla.class, entrada_datos);

		System.out.println("Talla= " + la_Talla);
		System.out.println("Abreviatura= " + la_Talla.dameAbreviatura());

		entrada.close(); //cerrar flujo

	}

}
