package prUnivSelector;
import java.util.Locale;

public class Alumno {
	
	private String nombre;
	private String dni;
	private double nota;
	
	public Alumno(String n, String d, double nt) {
		if ((n == null || n.length() == 0) ||(d == null || d.length() == 0) ||(nt < 0)) {
			throw new RuntimeException("Agumentos erróneos");
		}
		nombre = n;
		dni = d;
		nota = nt;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getDni() {
		return dni;
	}
	
	public double getNota() {
		return nota;
	}
	
	@Override
	public String toString() {
	// return "("+getNombre()+", "+getDni()+", "+getNota()+")";
		return String.format(Locale.ENGLISH, "(%s, %s, %.2f)", getNombre(), getDni(), getNota());
	}
	
	@Override
	public boolean equals(Object o) {
		boolean ok = false;
		if (o instanceof Alumno) {
			Alumno x = (Alumno)o;
			ok = this.nombre.equalsIgnoreCase(x.nombre) && this.dni.equalsIgnoreCase(x.dni);
		}
		return ok;
	}
	
	@Override
	public int hashCode() {
		return nombre.toLowerCase().hashCode() + dni.toLowerCase().hashCode();
	}
	//--------------------------------
	public boolean equalsAnterior(Object o) {
		boolean ok = false;
		if (o instanceof Alumno) {
			Alumno x = (Alumno)o;
			ok = this.nombre.equals(x.nombre)
			&& this.dni.equals(x.dni)
			&& (this.nota == x.nota);
			// && (Math.abs(this.nota - x.nota) < 1e-6);
		}
		return ok;
	}
	
	public int hashCodeAnterior() {
		return nombre.hashCode()
		+ dni.hashCode()
		+ Double.hashCode(nota);
	}
	//--------------------------------
}
