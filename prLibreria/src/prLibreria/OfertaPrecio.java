package prLibreria;

public class OfertaPrecio implements OfertaFlex{
	private double porcDescuento;
	private double umbralPrecio;
	
	public OfertaPrecio(double pD, double uP) {
		porcDescuento = pD;
		umbralPrecio = uP;
	}
	
	@Override
	public double getDescuento(Libro lib) {
		double ret = 0.0;
		if(lib.getPrecioBase() >= getUmbralPrecio()) {
			ret = getPorcDescuento();
		}
		return ret;
	}
	
	private double getPorcDescuento() {
		return porcDescuento;
	}
	
	private double getUmbralPrecio() {
		return umbralPrecio;
	}
	
	@Override
	public String toString(){
		return getPorcDescuento() + "%(" + getUmbralPrecio() +")";
	}
}
