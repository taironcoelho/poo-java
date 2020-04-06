package prTxt;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;

public class Texto {
	private static final int TAM = 8;
	private int nlineas;
	private String[] lista;
	
	public Texto() {
		nlineas = 0;
		lista = new String[TAM];
	}
	
	public void anyadirTexto(String txt) {
		if (txt == null) {
			throw new RuntimeException("Argumentos erróneos");
		}
		if (nlineas == lista.length) {
			lista = Arrays.copyOf(lista, 2*lista.length);
		}
		lista[nlineas] = txt;
		++nlineas;
	}
	
	public void reemplazar(String antiguo, String nuevo) {
		if ((antiguo == null)||(nuevo == null)||(antiguo.length() == 0)) {
			throw new RuntimeException("Argumentos erroneos");
		}
		for (int i = 0; i < nlineas; ++i) {
			lista[i] = reemplazarEnLinea(lista[i], antiguo, nuevo);
		}
	}
	
	public void cargarDeFichero(String nombreFich) throws IOException {
		try (Scanner sc = new Scanner(new File(nombreFich))) { //Como utiliza Try com recurso sc.close se realizará automatico
			while (sc.hasNextLine()) {
				String linea = sc.nextLine();
				anyadirTexto(linea);
			}
		}
	}
	
	public void guardarEnFichero(String nombreFich) throws IOException {
		try (PrintWriter pw = new PrintWriter(new File(nombreFich))) {
			for (int i = 0; i < nlineas; ++i) {
				pw.println(lista[i]);
			}
		}
	}
	
	@Override
	public String toString() {
		StringJoiner sj = new StringJoiner("\n");
		for (int i = 0; i < nlineas; ++i) {
			sj.add(lista[i]);
		}
		return sj.toString();
	}
	
	private String reemplazarEnLinea(String linea, String antiguo, String nuevo) {
		StringBuilder sb = new StringBuilder(linea);
		int i = 0;
		while (i+antiguo.length() <= sb.length()) {
			if (antiguo.equalsIgnoreCase(sb.substring(i, i+antiguo.length()))) {
				sb.replace(i, i+antiguo.length(), nuevo);
				i += nuevo.length();
			} else {
				++i;
			}
		}
		return sb.toString();
	}
}
