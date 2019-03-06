package prLibreria;

public class Libro {
	private static double porcIVA = 10.0;
	private String autor;
	private String titulo;
	private double precioBase;
	
	public Libro(String a, String t, double pB) {
		autor = a;
		titulo = t;
		precioBase = pB;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public double getPrecioBase() {
		return precioBase;
	}
	
	public double getPrecioFinal() {
		return precioBase + (precioBase*porcIVA)/100.0;
	}
	
	@Override
	public String toString() {
		return "(" + getAutor() + "; " + getTitulo() + "; " 
				+ getPrecioBase() + "; " + getIVA() + "; " + getPrecioFinal() + ";";
	}
	
	public double getIVA() {
		return porcIVA;
	}
	
	public void setIVA(double IVA) {
		porcIVA= IVA;
	}
	
}
