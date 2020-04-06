package prIndicePalabras;

import java.io.PrintWriter;
import java.util.*;

public abstract class IndiceAbstracto implements Indice{

	protected List<String> frases;
	
	public IndiceAbstracto() {
		frases = new LinkedList<String>();
	}
	
	@Override
	public void agregarFrase(String frase) {
		frases.add(frase);
	}
	
	@Override
	public void presentarIndiceConsola() {
		try(PrintWriter pw = new PrintWriter(System.out, true)){
			presentarIndice(pw);
		}
	}
}
