package prLibreria;
import java.util.Arrays;

public class LibreriaOferta extends Libreria{
	
	private double porcDescuento;
	private String[] autoresOferta;
	
	public LibreriaOferta(double d, String[] a) {
		this(CAP_INICIAL, d, a);
	}
	
	public LibreriaOferta(int cap, double d, String[] a) {
		super(cap);
		porcDescuento = d;
		autoresOferta = a;
	}

	public void setOferta(double d, String[] a) {
		porcDescuento = d;
		autoresOferta = a;
	}
	
	public String[] getOferta() {
		return autoresOferta;
	}
	
	public double getDescuento() {
		return porcDescuento;
	}
	
	@Override
	public void addLibro(String autor, String titulo, double precioBase) {
		int pos = buscarAutor(autor);
		if(0<=pos && pos<autoresOferta.length) {
			anyadirLibro(new LibroOferta(autor, titulo, precioBase, porcDescuento));
		} else {
			anyadirLibro(new Libro(autor, titulo, precioBase));
		}
	}
	
	public int buscarAutor(String autor) {
		int i=0;
		while((i<autoresOferta.length) && ! (autor.equalsIgnoreCase(autoresOferta[i]))) {
			++i;
		}
		if (i == autoresOferta.length) {
			i = -1;
		}
		return i;
	}
	
	@Override
	public String toString() {
		String str = getDescuento() + "%" + Arrays.toString(autoresOferta);
		return str + "\n" + super.toString();
	}
}
