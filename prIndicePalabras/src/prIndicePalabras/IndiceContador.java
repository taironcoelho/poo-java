package prIndicePalabras;

import java.io.PrintWriter;
import java.util.*;

public class IndiceContador extends IndiceAbstracto{
	private SortedMap<String, Integer> indice;
	
	public IndiceContador() {
		indice = new TreeMap<String, Integer>();
	}
	@Override
	public void resolver(String delimitadores) {
		indice.clear();
		for(String frase:frases) {
			try(Scanner sc = new Scanner(frase)){
				sc.useDelimiter(delimitadores);
				anyadir(sc);
			}
		}
		
	}
	
	private void anyadir(Scanner sc) {
		while(sc.hasNext()) {
			String str = sc.next().toLowerCase();
			Integer n = indice.get(str);
			if(n == null) {
				n = 0;
			}
			n++;
			indice.put(str, n);
		}
	}


	@Override
	public void presentarIndice(PrintWriter pw) {
		for(Map.Entry<String, Integer> e: indice.entrySet()) {
			pw.println(e.getKey() + " " + e.getValue());
		}
		
	}

}
