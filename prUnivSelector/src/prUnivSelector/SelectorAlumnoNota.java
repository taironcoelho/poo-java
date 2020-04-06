package prUnivSelector;

public class SelectorAlumnoNota implements SelectorAlumno {
	private final double min;
	private final double max;
	
	public SelectorAlumnoNota(double n, double x) {
		min = n;
		max = x;
	}
	
	@Override
	public boolean esSeleccionable(Alumno a) {
		return (min <= a.getNota() && a.getNota() <= max);
	}
}
