package regata;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Regata {
	private SortedSet<Barco> participantes;
	
	public Regata() {
		participantes = new TreeSet<Barco>();
	}
	
	public void agrega(Barco b) {
		if(!participantes.contains(b)) {
			participantes.add(b);
		}
	}
	
	public void avanza(int mnt) {
		for(Barco b:participantes) {
			b.avanza(mnt);
		}
	}
	
	public Set<Barco> getParticipantes(){
		return participantes;
	}
	
	public Set<Barco> ordenadosPorDistancia() {
		Set<Barco> set = new TreeSet<>(new SatBarco());
		set.addAll(participantes);
		return set;
	}
	
	public boolean velocidadSuperiorA(int velocidad) {
		boolean ret = false;
		
		Iterator<Barco> it = participantes.iterator();
		
		while(!ret && it.hasNext()) {
			if(it.next().getVelocidad() >= velocidad) {
				ret = true;
			}
		}
		return ret;
	}
	
	public List<Barco> dentroDelCirculo(Posicion p, int km){
		List<Barco> ret = new LinkedList<>();
			
		for(Barco b: getParticipantes()) {
			if(b.getPosicion().distancia(p) <= km) {
				ret.add(b);
			}
		}
		
		return ret;
	}
	
	public Map<Integer, Set<Barco>> barcosPorVelocidad(){
		SortedMap<Integer, Set<Barco>> ret = new TreeMap<Integer, Set<Barco>>();
		int cota;
		for(Barco b: getParticipantes()) {
			cota = b.getVelocidad()/10;	
			Set<Barco> barcos = ret.get(cota);	
			
			if(barcos == null) {
				barcos = new TreeSet<Barco>();
			}
			barcos.add(b);
			ret.put(cota, barcos);
		}
		
		return ret;
	}

	public Barco creaBarcoString(String linea) {
		try(Scanner sc = new Scanner(linea)){
			sc.useDelimiter("[ ,]+");
			//while(sc.hasNext()) {
				String n = sc.next();	 
				double lat = sc.nextDouble();
				double lon = sc.nextDouble();
				Posicion pos = new Posicion(lat, lon);
				int r = sc.nextInt();
				int v = sc.nextInt();
				return new Barco(n,pos, r, v);
			//}
			
		} catch (InputMismatchException e) {
			throw new RegataException("Algun dato numerico es erroneo en " + linea);
		} catch (NoSuchElementException e) {
			throw new RegataException("Faltan datos  en " + linea);			
		} 
	}
	
	public void leeFichero(String fichero) throws FileNotFoundException {
		try(Scanner sc = new Scanner(new File(fichero))){
			lee(sc);
		}
	}
	
	private void lee(Scanner sc) {
		while(sc.hasNextLine()) {
			agrega(creaBarcoString(sc.nextLine()));
		}
	}
	
	public void escribeFichero(String fichero) throws FileNotFoundException {
		try(PrintWriter pw = new PrintWriter(new File(fichero))){
			escribe(pw);
		}
	}
	
	public void escribe(PrintWriter pw) {
		StringJoiner sj = new StringJoiner(", ", "[", "]");
		for(Barco b:getParticipantes()) {
			sj.add(b.toString());
		}
		pw.print(sj.toString());
	}
	
	@Override
	public String toString() {
		StringJoiner sj = new StringJoiner(", ", "[", "]");
		for(Barco b:getParticipantes()) {
			sj.add(b.toString());
		}
		return sj.toString();
	}
}
