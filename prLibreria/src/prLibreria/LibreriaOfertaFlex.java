package prLibreria;
import java.util.Arrays;

public class LibreriaOfertaFlex extends Libreria {
	private OfertaFlex oferta;
	
	public LibreriaOfertaFlex(OfertaFlex o) {
		this(CAP_INICIAL, o);
	}
	
	public LibreriaOfertaFlex(int cap, OfertaFlex o) {
		super(cap);
		oferta = o;
	}
	
	public void setOferta(OfertaFlex o) {
		oferta = o;
	}
	
	public OfertaFlex getOferta() {
		return oferta;
	}
	
	@Override
	public void addLibro(String a, String t, double p) {
		Libro lb = new Libro(a, t, p);
		double desc = oferta.getDescuento(lb);
		if (desc != 0) {
			anyadirLibro(new LibroOferta(a, t, p, desc));
		} else {
			anyadirLibro(lb);
		}
	}
	
	@Override
	public String toString() {
		return oferta.toString() + "\n" + super.toString();
	}
}