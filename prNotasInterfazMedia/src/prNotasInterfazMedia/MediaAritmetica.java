package prNotasInterfazMedia;

public class MediaAritmetica implements CalculoMedia{

	public MediaAritmetica() {
		super();
	}
	
	public double calcular(Alumno[] alns) throws AlumnoException{
		if(alns.length<1) {
			throw new AlumnoException("No hay alumnos registrados");
		}
		double media = 0;
		for(Alumno a: alns) {
			media+= a.getCalificacion();
		}
		return media/alns.length;
	}
}
