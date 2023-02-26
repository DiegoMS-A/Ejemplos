package principal;

public class Furgoneta extends Coche {//hereda de la clase coche, en Java no admite herencia multiple
	
	private int capacidad_carga;
	private int plazas_extra;

	public Furgoneta(int plazas_extra, int capacidad_carga) {
		
		super(); //llama al constructor padre de la clase coche
		this.plazas_extra = plazas_extra;
		this.capacidad_carga = capacidad_carga;
	}
	
	public String dimDatosFurgoneta() {
		
		return " La capacidad de carga es: " + capacidad_carga + " y las plazas son: " + plazas_extra;
	}
}
