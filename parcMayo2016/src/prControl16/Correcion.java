package prControl16;

public class Correcion {
	private String observatorio;
	private double correccion;
	
	public Correcion(String obs, double corr) {
		observatorio = obs;
		correccion = corr;
	}
	
	public String getObs() {
		return observatorio;
	}
	
	public double getCo() {
		return correccion;
	}
	
	@Override
	public String toString() {
		return "("+ getObs() + ";" + getCo() + ")";
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean ok = false;
		if(obj instanceof Correcion) {
			Correcion cor = (Correcion) obj;
			ok = getObs().equalsIgnoreCase(cor.getObs());
		}
		return ok;
	}
	
	@Override
	public int hashCode() {
		return getObs().hashCode();
	}
}
