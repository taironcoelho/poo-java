package prJarras;

public class Jarra {
	
	private final int CAPACIDAD;
	private int contenido;
	
	public Jarra(int c) {
		CAPACIDAD = c;
		contenido=0;
	}
	
	public int capacidad() {
		return CAPACIDAD;
	}
	
	public int contenido() {
		return contenido;
	}
	
	public void llena() {
		contenido = CAPACIDAD;
	}
	
	public void vacia() {
		contenido=0;
	}
	
	public void llenaDesde(Jarra j) {
		int capLibre = CAPACIDAD - contenido;
		
		if(capLibre >= j.contenido) {
			contenido = contenido + j.contenido;
			j.contenido=0;
		} else {
			contenido = contenido + capLibre;
			j.contenido = j.contenido - capLibre;
		}
		/* Otra solución
		 * int c = Math.min(capLibre, j.contenido):
		 * this.contenido+=c;
		 * j.contenido-=c;
		 * */
	}
	
	@Override
	public String toString() {
		return "J("+ capacidad() + "," + contenido() + ")";
	}
}
