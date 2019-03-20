package prLibreria;

import java.util.Arrays;

public class Libreria {
	protected static final int CAP_INICIAL = 8;
	private int numLibs;
	private Libro[] libs;
	
	public Libreria() {
		this(CAP_INICIAL);
	}
	
	public Libreria(int t) {
		libs = new Libro[t];
		numLibs = 0;
	}
	
	public void addLibro(String autor, String titulo, double precioBase) {
		Libro addLibro = new Libro(autor,titulo, precioBase);
		anyadirLibro(addLibro);
	}
	
	protected void anyadirLibro(Libro libro) {
		int pos = buscarLibro(libro.getAutor(), libro.getTitulo());
		if(0<=pos && pos<numLibs) {
			libs[pos] = libro;
		} else {
			anyadirFinal(libro);
		}
	}
	
	private int buscarLibro(String buscaAutor, String buscaTitulo) {
		int i=0;
		while((i<numLibs) && ! (buscaAutor.equalsIgnoreCase(libs[i].getAutor()) &&  buscaTitulo.equalsIgnoreCase(libs[i].getTitulo()))) {
			++i;
		}
		if(i == numLibs) {
			i=-1;
		}
		return i;
	}
	
	public double getPrecioBase(String buscaAutor, String buscaTitulo) {
		int pos = buscarLibro(buscaAutor, buscaTitulo);
		if(0<=pos) {
			return libs[pos].getPrecioBase();
		}
		return 0.0;
	}
	
	public double getPrecioFinal(String buscaAutor, String buscaTitulo) {
		int pos = buscarLibro(buscaAutor, buscaTitulo);
		if(0<=pos) {
			return libs[pos].getPrecioFinal();
		}
		return 0.0;
	}
	
	private void anyadirFinal(Libro libro) {
		if(numLibs == libs.length) {
			libs = Arrays.copyOf(libs, 2*libs.length);
		}
		libs[numLibs] = libro;
		++numLibs;
	}
	
	public void remLibro(String buscaAutor, String buscaTitulo) {
		int pos = buscarLibro(buscaAutor, buscaTitulo);
		eliminarPosicion(pos);
	}
	
	private void eliminarPosicion(int pos) {
		if(0<=pos && pos<numLibs) {
			System.arraycopy(libs, pos+1, libs, pos, numLibs-(pos+1));
			libs[numLibs-1] = null;
			--numLibs;
		}
	}
	
	@Override
	public String toString() {
		String res = "";
		if(numLibs > 0) {
			res += libs[0].toString();
			for(int i=1; i< numLibs;i++) {
				res+= "," + libs[i].toString();
			}
		}	
		return "[" +  res + "]";
	}
}