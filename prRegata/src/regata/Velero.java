package regata;

public class Velero extends Barco{

	public Velero(String n, Posicion pos, int r, int v) {
		super(n, pos, r, v);
	}
	
	@Override
	public void avanza(int mnt) {
		int vel = getVelocidad();
		int rum = getRumbo();
		
		if(rum <=45 || rum>= 315) {
			vel = vel -3;
		} else if(rum <= 225 && rum >= 145) {
			vel = vel +3;
		}
		
		posicion = posicion.posicionTrasRecorrer(mnt, rum, vel);
	}
}
