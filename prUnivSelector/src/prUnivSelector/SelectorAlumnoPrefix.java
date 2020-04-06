package prUnivSelector;

public class SelectorAlumnoPrefix implements SelectorAlumno {
	private final String prefix;
	
	public SelectorAlumnoPrefix(String p) {
		if ((p == null)||(p.trim().length() == 0)) {
			throw new IllegalArgumentException("Bad Args");
		}
		prefix = p.trim();
	}
	
	@Override
	public boolean esSeleccionable(Alumno a) {
		return (a.getNombre().length() >= prefix.length())
				&& prefix.equalsIgnoreCase(a.getNombre().substring(0, prefix.length()));
	}
}
