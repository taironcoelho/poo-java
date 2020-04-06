package ajedrez;

import java.util.*;

public class SistemaPuntuacion extends SistemaAbstracto{

	public SistemaPuntuacion() {
		super();
	}
	
	@Override
	public void emparejar(List<Jugador> jugadores) {
		SortedMap<Integer, List<Jugador>> lista = new TreeMap<Integer, List<Jugador>>();
		int puntuacion;
		List<Jugador> jugs;
		
		for(Jugador jug:jugadores) {
			puntuacion = jug.getPuntuacion();
			jugs = lista.get(puntuacion);
			if(jugs == null) {
				jugs = new ArrayList<Jugador>();
			}
			jugs.add(jug);
			lista.put(puntuacion, jugs);
		}
		
		limpiarEmparejamientos();
		Jugador blancas;
		Jugador negras;
		for(Map.Entry<Integer, List<Jugador>> listaJugadores: lista.entrySet()) {
			Collections.shuffle(listaJugadores.getValue());
			
			int tam = listaJugadores.getValue().size()/2;

			for (int i = 0; i < tam; i++) {
				agregarEmparejamiento(new Emparejamiento(listaJugadores.getValue().get(i), listaJugadores.getValue().get(i+tam)));
			}
		}
		
	}
	

}
