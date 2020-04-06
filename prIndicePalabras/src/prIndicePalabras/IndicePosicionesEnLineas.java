package prIndicePalabras;

import java.io.PrintWriter;
import java.util.*;

public class IndicePosicionesEnLineas extends IndiceAbstracto{
	private SortedMap<String, SortedMap<Integer, SortedSet<Integer>>> indice;

	public IndicePosicionesEnLineas() {
		indice = new TreeMap<String, SortedMap<Integer, SortedSet<Integer>>>();
	}
	
	@Override
	public void resolver(String delimitadores) {
		int i=0;
		for(String frase: frases) {
			i++;
			try(Scanner sc = new Scanner(frase)){
				sc.useDelimiter(delimitadores);
				incluye(sc, i);
			}
		}
	}
	
	private void incluye(Scanner sc, int nLinea) {
		int pos = 0;
		while(sc.hasNext()) {
			pos++;
			String palabra = sc.next().toLowerCase();
			SortedMap<Integer, SortedSet<Integer>> lineas = indice.get(palabra);
			
			if(lineas == null) {
				lineas = new TreeMap<Integer, SortedSet<Integer>>();
			}
			SortedSet<Integer> posiciones = lineas.get(nLinea);
			
			if(posiciones == null) {
				posiciones = new TreeSet<Integer>();
			}		
			
			if(!posiciones.contains(pos)) {
				posiciones.add(pos);
			}
			
			lineas.put(nLinea, posiciones);
			indice.put(palabra, lineas);
		}
	}

	@Override
	public void presentarIndice(PrintWriter pw) {
		StringBuilder sb = new StringBuilder();

		for(Map.Entry<String, SortedMap<Integer, SortedSet<Integer>>> e: indice.entrySet()) {
			sb.append(e.getKey());	
			sb.append("\n\t");
			sb.append(lineasToString(e.getValue()));	
			sb.append("\n");
		}
		pw.println(sb.toString());
		
	}
	
	private String lineasToString(Map<Integer, SortedSet<Integer>> lineas) {
		StringBuilder sb = new StringBuilder();
		for(Map.Entry<Integer, SortedSet<Integer>> linea: lineas.entrySet()) {
			sb.append(linea.getKey()+" ");
			sb.append(posicionesToString(linea.getValue()));
			sb.append("\n\t");
		}
		return sb.toString();
	}
	
	private String posicionesToString(Set<Integer> posiciones) {
		StringJoiner sj = new StringJoiner(",","<",">");
		for(int p:posiciones) {
			sj.add(""+p);
		}
		return sj.toString();
	}
}
