package regata;

import java.util.Comparator;

public class SatBarco implements Comparator<Barco>{

	public int compare(Barco b1, Barco b2) {
		int res;
		double d1 = b1.getPosicion().distancia(new Posicion(0.0,0.0));
		double d2 = b2.getPosicion().distancia(new Posicion(0.0,0.0));
		
		res = Double.compare(d1, d2);
		if(res == 0) {
			res = b1.compareTo(b2);
		}
		
		return res;
	}
}
