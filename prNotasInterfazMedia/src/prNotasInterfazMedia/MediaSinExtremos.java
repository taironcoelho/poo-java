package prNotasInterfazMedia;

public class MediaSinExtremos implements CalculoMedia{
	private double min;
	private double max;
	
	public MediaSinExtremos(double min, double max) {
		this.min = min;
		this.max = max;
	}
	
	public double calcular(Alumno[] alns) throws AlumnoException{
		if(alns.length<1) {
			throw new AlumnoException("No hay alumnos registrados");
		}
		double media = 0;
		int k = 0;
		for(Alumno aln : alns) {
			if(aln.getCalificacion() > getMin() && aln.getCalificacion() < getMax()) {
				media+= aln.getCalificacion();
				k++;
			}
		}
		
		if(k == 0) {
			throw new AlumnoException("No hay alumnos que cumplan el requisito");
		}
		
		return media/k;
	}
	
	public double getMin() {
		return this.min;
	}
	
	public double getMax() {
		return this.max;
	}
}
