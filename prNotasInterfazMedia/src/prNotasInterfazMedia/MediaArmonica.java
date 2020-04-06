package prNotasInterfazMedia;

public class MediaArmonica implements CalculoMedia{
	public MediaArmonica() {
		super();
	}
	
	public double calcular(Alumno[] alns) throws AlumnoException{
		if(alns.length<1) {
			throw new AlumnoException("No hay alumnos registrados");
		}
		double media = 0;
		int k = 0;
		for(Alumno aln : alns) {
			if(aln.getCalificacion() > 0) {
				media+= 1/aln.getCalificacion();
				k++;
			}
		}
		
		if(k == 0) {
			throw new AlumnoException("No hay alumnos con nota mayor que cero");
		}
		
		return k/media;
	}
}
