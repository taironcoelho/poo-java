package prLibreria;

public class Libreria {
	private static final int CAP_INICIAL = 8;
	private int numLibs;
	private Libro[] libros;
	
	public Libreria() {
		this(CAP_INICIAL);
	}
	
	public Libreria(int t) {
		libros = new Libro[t];
		numLibs = 0;
	}
	
	public void addLibro(String autor, String titulo, double precioBase) {
		Libro addLibro = new Libro(autor,titulo, precioBase);
		anyadirLibro(addLibro);
	}
	
	private void anyadirLibro(Libro libro) {
		
	}
	
	private int buscarLibro(String buscaAutor, String buscaTitulo) {
		int i=0;
		while((i<numLibs) && (buscaAutor.equals(libros[i].getAutor()) ||  buscaTitulo.equals(libros[i].getTitulo()))) {
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
			return libros[pos].getPrecioBase();
		}
		return 0.0;
	}
	
	public double getPrecioFinal(String buscaAutor, String buscaTitulo) {
		int pos = buscarLibro(buscaAutor, buscaTitulo);
		if(0<=pos) {
			return libros[pos].getPrecioFinal();
		}
		return 0.0;
	}
	
	private void eliminarLibro(int pos) {
		
	}
	
	@Override
	public String toString() {
		String res = "[(" + libros[0].toString();
		for(int i=1; i<libros.length;i++) {
			res+= "," + libros[i].toString();
		}
		res+="]";
		return res;
	}
}
