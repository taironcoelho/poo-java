import ajedrez.Jugador;

// Programa de prueba para la clase Jugador. La salida debería ser:
//
// (1300,5) Marta Olivenza --> Eduardo Canales, Maria Rodriguez, Carmelo Sanchez
// ARO del jugador Marta Olivenza es 1176.6666666666667

// (1500,5) Alberto Plaza --> Virginia Robles, Aurora Rios, Antonio Torres
// ARO del jugador Alberto Plaza es 1683.3333333333333

// Alberto Plaza mayor que Marta Olivenza
public class PruebaJugador {
    
	public static void main(String[] args) {
		Jugador j1 = new Jugador ("Marta Olivenza",1300);
		j1.agregarContrincante(new Jugador("Eduardo Canales",1000));
		j1.agregarContrincante(new Jugador("Maria Rodriguez",1300));
		j1.agregarContrincante(new Jugador("Carmelo Sanchez",1230));
		j1.incPuntuacion(5);
		for (Jugador jug:j1.getContrincantes()) {
			jug.incPuntuacion(1);
		}
		System.out.println(j1);
		System.out.println("ARO del jugador " + j1.getNombre() + " es " + j1.getMediaRatingContricantes());
		
		Jugador j2 = new Jugador ("Alberto Plaza",1500);
		j2.agregarContrincante(new Jugador("Virginia Robles",1250));
		j2.agregarContrincante(new Jugador("Aurora Rios",1800));
		j2.agregarContrincante(new Jugador("Antonio Torres",2000));
		j2.incPuntuacion(5);
		for (Jugador jug:j2.getContrincantes()) {
			jug.incPuntuacion(1);
		}
		System.out.println();
		System.out.println(j2);
		System.out.println("ARO del jugador " + j2.getNombre() + " es " + j2.getMediaRatingContricantes());
		System.out.println();
		
		int iguales=j1.compareTo(j2);
		if (iguales==0) {
			System.out.println("Jugadores Iguales");
		} else if (iguales>0) {
			System.out.println(j1.getNombre() + " mayor que " + j2.getNombre());
		} else {
			System.out.println(j2.getNombre() + " mayor que " + j1.getNombre());
		}
	}

}
