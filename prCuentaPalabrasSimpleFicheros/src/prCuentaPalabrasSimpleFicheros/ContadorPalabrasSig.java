package prCuentaPalabrasSimpleFicheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ContadorPalabrasSig{
	private String[] noSignificativas;
	private static final int TAM = 10;
	private int numPalNoSig;
	
	public ContadorPalabrasSig(String[] palsNs) {
		noSignificativas = new String[palsNs.length];
		for(int i=0;i<=palsNs.length;i++) {
			noSignificativas[i] = palsNs[i].toUpperCase();
			numPalNoSig++;
		}
	}
	
	public ContadorPalabrasSig(int n,String[] palsNs) {
		noSignificativas = new String[n];
		for(int i=0;i<=n;i++) {
			noSignificativas[i] = palsNs[i].toUpperCase();
		}
		numPalNoSig = n;
	}
	
	public ContadorPalabrasSig(String filNoSig, String del) throws IOException{
		noSignificativas = new String[TAM];
		numPalNoSig = 0;
		leerFicheroNoSig(filNoSig, del);
	}
	
	public ContadorPalabrasSig(int n, String filNoSig, String del) throws IOException{
		noSignificativas = new String[n];
		numPalNoSig = 0;
		leerFicheroNoSig(filNoSig, del);
	}
	
	private void leerFicheroNoSig(String filNoSig, String del) throws IOException{
		try(Scanner sc1 = new Scanner(new File(filNoSig))){
			leerPalabrasNoSignificativas(sc1,del);
		} 
	}
	
	private void leerPalabrasNoSignificativas(Scanner sc, String del) {
		sc.useDelimiter(del);
		while(sc.hasNextLine()) {
			noSignificativas[numPalNoSig] = sc.nextLine().toUpperCase();
			numPalNoSig++;
		}
	}
}
