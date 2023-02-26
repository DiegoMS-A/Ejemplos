package principal;

public class Coche {

	private int ruedas; // con private solo manipulable por metodos
	private int largo;
	private int ancho;
	private int motor;
	private int peso_plataforma;
	private String color;
	private int peso_total;
	private boolean asientos_cuero, climatizador;

	public Coche() {

		ruedas = 4;
		largo = 2000;
		ancho = 300;
		motor = 1600;
		peso_plataforma = 500;
	}
	
	public String dime_datos_generales() {
		return "La plataforma del vehiculo tiene " + ruedas + " ruedas. " + "Mide " + largo/1000 + 
				" metros con un ancho de " + ancho + " cm y un peso de plataforma de " + peso_plataforma;
			
	}

	public int getRuedas() {
		return ruedas;
	}

	public void setRuedas(int ruedas) {
		this.ruedas = ruedas;
	}

	public int getLargo() {
		return largo;
	}

	public void setLargo(int largo) {
		this.largo = largo;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getMotor() {
		return motor;
	}

	public void setMotor(int motor) {
		this.motor = motor;
	}

	public int getPeso_plataforma() {
		return peso_plataforma;
	}

	public void setPeso_plataforma(int peso_plataforma) {
		this.peso_plataforma = peso_plataforma;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPeso_total() {
		return peso_total;
	}

	public void setPeso_total(int peso_total) {
		this.peso_total = peso_total;
	}

	public boolean isAsientos_cuero() {
		return asientos_cuero;
	}

	public void setAsientos_cuero(boolean asientos_cuero) {
		this.asientos_cuero = asientos_cuero;
	}

	public boolean isClimatizador() {
		return climatizador;
	}

	public void setClimatizador(boolean cliatizador) {
		this.climatizador = cliatizador;
	}
	
	
}
