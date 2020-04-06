

import java.util.List;

import ajedrez.Jugador;
import ajedrez.SistemaARO;
import ajedrez.SistemaPuntuacion;

import java.util.ArrayList;

public class PruebaSistema {

	public static void main(String[] args) {
		List<Jugador> jugadores = new ArrayList<>();
		jugadores.add(new Jugador("Eduardo Canales",1000));
		jugadores.add(new Jugador("Maria Rodriguez",1300));
		jugadores.add(new Jugador("Carmelo Sanchez",1230));
		jugadores.add(new Jugador("Antonia Davila",1400));
		jugadores.add(new Jugador("Juan Antonio Garcia",1150));
		jugadores.add(new Jugador("Jose Maria Rocha",740));
		jugadores.add(new Jugador("Francisco Osuna",1100));
		jugadores.add(new Jugador("Cristina Cabello",1200));
				
		System.out.println("\nCriterio puntuación");
		System.out.println("============================");
		SistemaPuntuacion sp = new SistemaPuntuacion();
		sp.emparejar(jugadores);
		sp.presentarEmparejamientosConsola();
		
		System.out.println("\nCriterio ARO");
		System.out.println("============================");
		SistemaARO sa = new SistemaARO();
		sa.emparejar(jugadores);
		sa.presentarEmparejamientosConsola();
	}

}
