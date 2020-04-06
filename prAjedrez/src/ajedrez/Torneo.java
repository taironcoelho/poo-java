package ajedrez;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Torneo {
	private Sistema sistema;
	private List<Jugador> jugadores;
	
	public Torneo(Sistema s, String fichero) throws FileNotFoundException {
		sistema = s;
		jugadores = new ArrayList<>();
		leerJugadores(fichero);
	}
	
	private void leerJugadores(String fichero) throws FileNotFoundException {
		try(Scanner sc = new Scanner(new File(fichero))){
			leerJugadores(sc);
		}
	}
	
	private void leerJugadores(Scanner sc) {
		while(sc.hasNextLine()) {
			String linea = sc.nextLine();
			try(Scanner sc1 = new Scanner(linea)){
				sc1.useDelimiter(":");
				while(sc1.hasNext()) {
					jugadores.add(new Jugador(sc1.next(), sc1.nextInt()));
				}
			}
		}
	}
	
	public List<Jugador> getJugadores(){
		return jugadores;
	}
	
	public void ronda() {
		sistema.emparejar(getJugadores());
		List<Emparejamiento> parejas = sistema.getParejas();
		
		for(Emparejamiento e:parejas) {
			e.setResultado(new Random().nextInt(2));
		}
		actualizarPuntuaciones(parejas);
	}
	
	private void actualizarPuntuaciones(List<Emparejamiento> emp) {
		for(Emparejamiento e: emp) {
			switch(e.getResultado()) {
			case 0:
				e.getBlancas().incPuntuacion(1);
				e.getNegras().incPuntuacion(1);
				break;
			case 1:
				e.getBlancas().incPuntuacion(2);
				break;
			case 2:
				e.getNegras().incPuntuacion(2);
				break;
			}
		}
	}
	
	public void escribirTorneo(String fichero) throws FileNotFoundException {
		try(PrintWriter pw = new PrintWriter(new File(fichero))){
			escribirTorneo(pw);
		}
	}
	
	public void escribirTorneoConsola () {
		try(PrintWriter pw = new PrintWriter(System.out)){
			escribirTorneo(pw);
		}
	}
	
	private void escribirTorneo(PrintWriter pw) {
		for(Jugador jug: jugadores) {
			pw.println(jug.toString());
		}
	}
}
