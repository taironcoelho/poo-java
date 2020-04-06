package prJarrasGUI;

public class Jarra {
	private final int capacidad;
	private int contenido;

	public Jarra(int c) {
		if (c < 0) {
			throw new RuntimeException("Capacidad negativa");
		}
		capacidad = c;
		contenido = 0;
	}

	public int capacidad() {
		return capacidad;
	}

	public int contenido() {
		return contenido;
	}

	public void llena() {
		contenido = capacidad;
	}

	public void vacia() {
		contenido = 0;
	}

	public void llenaDesde(Jarra j) {
		int c = Math.min(j.contenido, (this.capacidad - this.contenido));
		j.contenido -= c;
		this.contenido += c;
	}

	@Override
	public String toString() {
		return "Jarra(" + capacidad + ", " + contenido + ")";
	}
}
