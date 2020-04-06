package prCuentaPalabrasSimpleFicheros;

public class PalabraEnTexto {
	private String palabra;
	private int veces;
	
	public PalabraEnTexto(String plb) {
		palabra = plb.toUpperCase();
		veces = 1;
	}
	
	public void incrementa() {
		veces++;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean ok = false;
		if(obj instanceof PalabraEnTexto) {
			PalabraEnTexto x = (PalabraEnTexto) obj;
			ok = this.palabra.equals(x.palabra);
		}
		return ok;
	}
	
	@Override
	public int hashCode() {
		return palabra.hashCode();
	}
	
	@Override
	public String toString() {
		return palabra + ": " + veces;
	}
}
