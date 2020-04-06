package regata;

public class Barco implements Comparable<Barco>{
	protected String nombre;
	protected int rumbo;
	protected int velocidad;
	protected Posicion posicion;
	
	public Barco(String n, Posicion pos, int r, int v) {
		if(r<0 && r>359) {
			throw new RegataException();
		}
		nombre = n;
		rumbo = r;
		posicion = pos;
		velocidad = v;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getRumbo() {
		return rumbo;
	}
	
	public int getVelocidad() {
		return velocidad;
	}
	
	public Posicion getPosicion() {
		return posicion;
	}
	
	public void avanza(int mnt) {
		posicion = posicion.posicionTrasRecorrer(mnt, getRumbo(), getVelocidad());
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getNombre());
		sb.append(": ");
		sb.append("l= ");
		sb.append(getPosicion().getLatitud()+" L= ");
		sb.append(getPosicion().getLongitud() + " R= ");
		sb.append(getRumbo() + " V= ");
		sb.append(getVelocidad()+"");
		
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object o) {
		boolean ok = false;
		if(o instanceof Barco) {
			Barco x  = (Barco) o;
			ok = this.getNombre().equalsIgnoreCase(x.getNombre());
		}
		return ok;
	}
	
	@Override
	public int hashCode() {
		return this.getNombre().toLowerCase().hashCode();
	}
	
	@Override
	public int compareTo(Barco b) {
		return this.getNombre().compareToIgnoreCase(b.getNombre());
	}
}
