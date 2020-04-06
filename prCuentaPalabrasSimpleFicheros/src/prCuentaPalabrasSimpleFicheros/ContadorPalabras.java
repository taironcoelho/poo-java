package prCuentaPalabrasSimpleFicheros;

import java.util.Arrays;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class ContadorPalabras {
	private static final int TAM_INICIAL = 10;
	private int numPalabras;
	private PalabraEnTexto palabras[];
	
	public ContadorPalabras() {
		palabras = new PalabraEnTexto[TAM_INICIAL];
		numPalabras = 0;
	}
	
	public ContadorPalabras(int tam) {
		palabras = new PalabraEnTexto[tam];
		numPalabras = 0;
	}
	
	private int esta(String pal) {
		int pos = -1;
		int i = 0;
		PalabraEnTexto p = new PalabraEnTexto(pal);
		for(PalabraEnTexto plb: palabras) {
			if(p.equals(plb)) {
				pos = i;
			}
			i++;
		}
		return pos;
	}
	
	protected void incluye(String pal) {
		int pos = esta(pal);
		if(pos>=0) {
			palabras[pos].incrementa();
		} else {
			if(palabras.length == numPalabras) {
				palabras = Arrays.copyOf(palabras, numPalabras+1);
			}
			palabras[numPalabras] = new PalabraEnTexto(pal);
			numPalabras++;
		}
	}
	
	private void incluyeTodas(String linea, String del) {
		String[] pals = linea.split(del);
	
		for(String palabra: pals) {
			if(palabra.length() > 0) { //Ignora si vacio
				incluye(palabra);
			}
		}
	}
	
	public void incluyeTodas(String[] texto, String del) {
		for(String linea:texto) {
			incluyeTodas(linea, del);
		}
	}
	
	public void incluyeTodasFichero(String nomFich, String del) throws IOException{
		try(Scanner sc1= new Scanner(new File(nomFich))){
			leerFichero(sc1, del);
		}
	}
	
	private void leerFichero(Scanner sc, String del) {
		while(sc.hasNextLine()) {
			String linea = sc.nextLine();
			incluyeTodas(linea, del);
		}
	}
	
	public PalabraEnTexto encuentra(String pal) {
		int pos = esta(pal);
		if(pos<0) {
			throw new NoSuchElementException("No Existe la palabra "+ pal);
		} 
		
		return palabras[pos];
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(20*numPalabras);
		sb.append("[");
		if(numPalabras>0) {
			sb.append(palabras[0].toString());
			for(int i = 1; i< numPalabras; i++) {
				sb.append(", ");
				sb.append(palabras[i].toString());	
			}
			
		}
		sb.append("]");
		
		return sb.toString();
	}	
	
	public void presentaPalabras(String fichero) throws IOException{
		try(PrintWriter pw = new PrintWriter(new File(fichero))){
			presentaPalabras(pw);
		}
	}
	
	public void presentaPalabras(PrintWriter pw) {
		for(int i=0; i<numPalabras; i++) {
			pw.println(palabras[i].toString());
		}
	}
}
