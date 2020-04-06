package prIndicePalabras;

import java.io.PrintWriter;

public interface Indice {
	public abstract void agregarFrase(String frase);
	
	public abstract void resolver(String delimitadores);
	
	public abstract void presentarIndiceConsola();
	
	public abstract void presentarIndice(PrintWriter pw);
}
