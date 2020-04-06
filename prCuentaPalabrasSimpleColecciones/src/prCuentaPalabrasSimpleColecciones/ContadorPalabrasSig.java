package prCuentaPalabrasSimpleColecciones;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class ContadorPalabrasSig extends ContadorPalabras{
	private Set<String> noSignificativas;
	
	public ContadorPalabrasSig(Collection<String> palsNS) {
		super();
		noSignificativas = new HashSet<>();
		for(String pal: palsNS) {
			noSignificativas.add(pal.toUpperCase());
		}
	}
	
	public ContadorPalabrasSig(String filNoSig, String del) throws IOException{
		super();
		noSignificativas = new HashSet<>();
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
			noSignificativas.add(sc.nextLine().toUpperCase());
		}
	}
	
	@Override
	protected void incluye(String pal) {
		if(! noSignificativas.contains(pal.toUpperCase())) {
			super.incluye(pal);
		} 
	}
}
