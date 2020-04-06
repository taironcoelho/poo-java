package prIndicePalabras;

import java.io.PrintWriter;
import java.util.*;

public class IndiceLineas extends IndiceAbstracto{

	private SortedMap<String, List<Integer>> indice;
	
	public IndiceLineas() {
		indice = new TreeMap<String, List<Integer>>();
	}
	
	@Override
	public void resolver(String delimitadores) {
		int i = 0;
		for(String frase:frases) {
			i++;
			try(Scanner sc = new Scanner(frase)){
				sc.useDelimiter(delimitadores);
				anyadir(sc, i);
			}
		}
		
	}
	
	private void anyadir(Scanner sc, int nLinea) {
		while(sc.hasNext()) {
			String palabra = sc.next().toLowerCase();
			List<Integer> lineas = indice.get(palabra);
			if(lineas == null) {
				lineas = new LinkedList<Integer>();
			}
			if(!lineas.contains(nLinea)) {
				lineas.add(nLinea);
			}
			
			indice.put(palabra, lineas);
		}
	}

	@Override
	public void presentarIndice(PrintWriter pw) {
		StringBuilder sb = new StringBuilder();

		for(Map.Entry<String, List<Integer>> e: indice.entrySet()) {
			sb.append(e.getKey() + "");			
			sb.append(indiceToString(e.getValue()));	
			sb.append("\n");
		}
		pw.println(sb.toString());
	}
	
	private String indiceToString(List<Integer> lineas) {
		StringJoiner sj = new StringJoiner(",", "<", ">");
		for(int linea: lineas) {
			sj.add(""+linea);
		}
		return sj.toString();
	}

}
