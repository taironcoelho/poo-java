package prCuentaPalabrasSimpleColecciones;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class ContadorPalabras {
	private SortedSet<PalabraEnTexto> palabras;
	
	public ContadorPalabras() {
		palabras = new TreeSet<PalabraEnTexto>();
	}
	
	protected void incluye(String pal) {
		try {
			PalabraEnTexto palabra = encuentra(pal);
			palabra.incrementa();
		} catch (NoSuchElementException ex) {
			palabras.add(new PalabraEnTexto(pal));
		}
		
	}
	
	public PalabraEnTexto encuentra(String pal) {
		boolean ok = false;
		PalabraEnTexto p = new PalabraEnTexto(pal);
		PalabraEnTexto ret = null;
		if(!palabras.contains(p)) {
			throw new NoSuchElementException();
		}
		
		Iterator<PalabraEnTexto> it = palabras.iterator();
		while(!ok && it.hasNext()) {
			ret = it.next();
			ok = ret.equals(p);
		}
		
		return ret;
	}
	
	private void incluyeTodas(String linea, String del) {
		try(Scanner sc = new Scanner(linea)) {
			sc.useDelimiter(del);
			while(sc.hasNext()) {
				incluye(sc.next());
			}
		}
	}
	
	public void incluyeTodas(String[] texto, String del) {
		for(String linea: texto) {
			incluyeTodas(linea,del);
		}
	}
	
	public void incluyeTodasFichero(String nomFich, String del) throws FileNotFoundException {
		try(Scanner sc1 = new Scanner(new File(nomFich))) {
			leerFichero(sc1, del);
		}
	}
	
	private void leerFichero(Scanner sc, String del) {
		sc.useDelimiter(del);
		while(sc.hasNextLine()) {
			incluyeTodas(sc.nextLine(), del);
		}
	}
	
	@Override
	public String toString() {
		StringJoiner sj = new StringJoiner(", ", "[", "]");
		for(PalabraEnTexto pal: palabras) {
			sj.add(pal.toString());
		}
		
		return sj.toString();
	}
	
	public void presentaPalabras(String fichero) throws FileNotFoundException {
		try(PrintWriter pw = new PrintWriter(new File(fichero))){
			presentaPalabras(pw);
		}
	}
	
	public void presentaPalabras(PrintWriter pw) {
		for(PalabraEnTexto pal: palabras) {
			pw.println(pal.toString());
		}
	}
}
