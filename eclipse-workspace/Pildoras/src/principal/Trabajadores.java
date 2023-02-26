package principal;

public interface Trabajadores {

	double establece_bonus(double gratificacion); //por convencion no se pone el public abstract, se da por supuesto
	
	double bonus_base=1500; //por defecto son public static final
}
