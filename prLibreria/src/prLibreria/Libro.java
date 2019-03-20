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
		return precioBase + (precioBase*getIVA())/100.0;
	}
	
	@Override
	public String toString() {
		return "(" + getAutor() + "; " + getTitulo() + "; " 
				+ getPrecioBase() + "; " + getIVA() + " %; " + getPrecioFinal() + ")";
	}
	
	public static double getIVA() {
		return porcIVA;
	}
	
	public static void setIVA(double IVA) {
		porcIVA= IVA;
	}
	
}