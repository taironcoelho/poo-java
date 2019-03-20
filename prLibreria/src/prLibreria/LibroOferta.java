package prLibreria;

public class LibroOferta extends Libro{
	
	private double porcDescuento;
	
	public LibroOferta(String a, String t, double pB, double pD) {
		super(a,t,pB);
		porcDescuento = pD;
	}
	
	public double getDescuento() {
		return porcDescuento;
	}
	
	private double getPrecioOferta() {
		double p= getPrecioBase();
		p-= p * getDescuento()/100;
		return p;
	}
	
	@Override
	public double getPrecioFinal() {
		double p = getPrecioOferta();
		p+= p * getIVA()/100;
		return p;
	}
	
	@Override
	public String toString() {
		return "(" + getAutor() + "; " + getTitulo() + "; " 
				+ getPrecioBase() + "; " + getDescuento() + " %; " + getPrecioOferta() + "; " + getIVA() + " %; " + getPrecioFinal() + ")";
	}
}
