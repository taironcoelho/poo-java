package ajedrez;

import java.util.*;

public class Jugador implements Comparable<Jugador>{
	private String nombre;
	private int rating;
	private int pontuacion;
	private List<Jugador> contricantes;
	
	public Jugador(String n, int r) {
		nombre = n;
		rating = r;
		pontuacion = 0;
		
		contricantes = new LinkedList<Jugador>();
	}
	
	public int getRating() {
		return rating;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getPuntuacion() {
		return pontuacion;
	}
	
	public List<Jugador> getContrincantes(){
		return contricantes;
	}
	
	public void incPuntuacion(int n) {
		pontuacion = pontuacion + n;
	}
	
	public double getMediaRatingContricantes() {
		double media = 0.0;
		if(!contricantes.isEmpty()) {
			int i = 0;
			for(Jugador j:getContrincantes()) {
				i++;
				media = media + j.getRating();
			}
			media = media/i;
		}
		return media;
	}
	
	public void agregarContrincante(Jugador jug) {
		if(!contricantes.contains(jug)) {
			contricantes.add(jug);
		}
	}
	
	@Override
	public boolean equals(Object o) {
		boolean ok = false;
		if(o instanceof Jugador) {
			Jugador j = (Jugador) o;
			ok = (this.getMediaRatingContricantes() == j.getMediaRatingContricantes()) && (this.getNombre().equalsIgnoreCase(j.getNombre()));
		}	
		return ok;
	}
	
	@Override
	public int hashCode() {
		return this.getNombre().toLowerCase().hashCode() + Double.hashCode(this.getMediaRatingContricantes());
	}
	
	@Override
	public int compareTo(Jugador j) {
		int resultado = Double.compare(this.getMediaRatingContricantes(), j.getMediaRatingContricantes());
		
		if(resultado == 0) {
			resultado = this.getNombre().compareToIgnoreCase(j.getNombre());
		}
		
		return resultado;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		StringJoiner sj = new StringJoiner(", ","","");
		sb.append("(" + getRating()+", "+getPuntuacion()+ ") "+getNombre()+" --> ");
		for(Jugador j: getContrincantes()) {
			sj.add(j.getNombre());
		}
		sb.append(sj.toString());
		return sb.toString();
	}
}
