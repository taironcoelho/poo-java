package prCuentaPalabrasSimpleColecciones;

public class PalabraEnTexto implements Comparable<PalabraEnTexto>{
	
	private String palabra;
	private int nVeces;
	
	public PalabraEnTexto(String pal) {
		palabra = pal.toUpperCase();
		nVeces = 1;
	}
	
	public String getPalabra() {
		return palabra;
	}
	
	public void incrementa() {
		nVeces++;
	}
	
	@Override
	public boolean equals(Object o) {
		boolean ok = false;
		if(o instanceof PalabraEnTexto) {
			PalabraEnTexto pal = (PalabraEnTexto) o;
			ok = this.getPalabra().equals(pal.getPalabra());
		}
		return ok;
	}
	
	@Override
	public int hashCode() {
		return palabra.hashCode();
	}
	
	@Override
	public String toString() {
		return palabra + ": " + nVeces;
	}

	@Override
	public int compareTo(PalabraEnTexto pal) {
		int v = this.getPalabra().compareToIgnoreCase(pal.getPalabra());
		return v;
	}
}
