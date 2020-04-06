package ajedrez;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SistemaARO extends SistemaAbstracto {

	// Ordena la lista de participantes por el orden natural de Jugadores (ARO y nombre)
	// Una vez ordenados va emparejando el primero de  la primera mitad de la lista con 
	// el primero de la segunda, etc. Si el número de jugadores es impar, descansa el 
	// último de la lista, que quedará sin emparejar.
	
	@Override
	public void emparejar(List<Jugador> jugadores) {
			limpiarEmparejamientos();
			List<Jugador> ranking = new ArrayList<>();
			ranking.addAll(jugadores);
			Collections.sort(ranking);
			int tam = ranking.size() / 2;
			for (int i = 0; i < tam; i++) {
				agregarEmparejamiento(new Emparejamiento(ranking.get(i), ranking.get(i+tam)));
			}
		}
	}
	
