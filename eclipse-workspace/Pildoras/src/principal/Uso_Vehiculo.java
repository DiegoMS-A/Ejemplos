package principal;

public class Uso_Vehiculo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Coche micoche1= new Coche();		
		micoche1.setColor("rojo");
		
		Furgoneta mifurgoneta1 = new Furgoneta(7,580);
		
		mifurgoneta1.setColor("azul");
		mifurgoneta1.setClimatizador(true);
		mifurgoneta1.setAsientos_cuero(true);
		
		System.out.println(micoche1.dime_datos_generales() + " " + micoche1.getColor());
		System.out.println(mifurgoneta1.dime_datos_generales() + " " + mifurgoneta1.dimDatosFurgoneta());
	}

}
