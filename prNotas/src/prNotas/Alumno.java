package prNotas;

public class Alumno {
	private String nombre;
	private String dni;
	private double nota;
	
	public Alumno(String d, String nomb, double n) throws AlumnoException{
		if(n<0.0) {
			throw new AlumnoException("Nota invalida!");
		}
		nombre = nomb;
		dni = d;
		nota = n;
	}
	
	public Alumno(String d, String nomb) {
		nombre = nomb;
		dni = d;
		nota = 0.0;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getDni() {
		return dni;
	}
	
	public double getCalificacion() {
		return nota;
	}
	
	@Override
	public String toString() {
		return getNombre()+" " + getDni();
	}
	
	@Override
	public int hashCode() {
		return nombre.hashCode() + dni.toLowerCase().hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		boolean ok = false;
		if (o instanceof Alumno) {
			Alumno x = (Alumno)o;
			ok = this.nombre.equals(x.nombre) && this.dni.equalsIgnoreCase(x.dni);
		}
		return ok;
	}
}
