package prControl16;

public class Observacion {
	private String observatorio;
	private String estrella;
	private double magnitud;
	
	public Observacion(String ob, String est, double mag) {
		observatorio = ob;
		estrella = est;
		magnitud = mag;
	}

	public String getObs() {
		return observatorio;
	}
	
	public String getEst() {
		return estrella;
	}
	
	public double getMag() {
		return magnitud;
	}
	
	@Override
	public String toString() {
		return "(" + getObs() + ";" + getEst() + ";" + getMag() + ")";
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean ok = false;
		if(obj instanceof Observacion) {
			Observacion observacion = (Observacion) obj;
			ok = getObs().equalsIgnoreCase(observacion.getObs()) && getEst().equalsIgnoreCase(observacion.getEst());
		}
		return ok;
	}
	
	@Override
	public int hashCode() {
		return getObs().toLowerCase().hashCode() + getEst().toLowerCase().hashCode();
	}
}
