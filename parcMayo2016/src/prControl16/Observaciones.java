package prControl16;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class Observaciones {
	private static int TAM=16;
	private int numObs;
	private Observacion[] obs;
	
	public Observaciones() {
		obs = new Observacion[TAM];
		numObs = 0;
	}
	
	public Observaciones(int tam) {
		obs = new Observacion[tam];
		numObs = 0;
	}
	
	public void addObs(Observacion ob) {
		int pos = buscaObs(ob);
		if(pos>= 0) {
			obs[pos] = ob;
		} else {
			if(obs.length == numObs) {
				obs = Arrays.copyOf(obs, obs.length*2);
			}
			obs[numObs] = ob;
			numObs++;
		}
	}
	
	public void addObs(String linea) {
		String[] proc = linea.split("\\s*[;]\\s*");
		try {
			Observacion ob = new Observacion(proc[0], proc[1], Double.parseDouble(proc[2]));
			addObs(ob);
		} catch(IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}
	}
	
	private int buscaObs(Observacion ob) {
		int pos = -1;
		for(int i=0; i<numObs; i++) {
			if(obs[i].equals(ob)) {
				pos = i;
			}
		}
		return pos;
	}
	
	public int getNObs() {
		return numObs;
	}
	
	public Observacion getObs(int pos) {
		return obs[pos];
	}
	
	public double getMoe(String ob, String est) {
		Observacion obsTemp = new Observacion(ob, est, 0.0);
		int pos = -1;
		for(int i=0;i<numObs-1;i++) {
			if(obs[i].equals(obsTemp)) {
				pos = i;
			}
		}
		if(pos<=0) {
			throw new NoSuchElementException();
		}
		return obs[pos].getMag();
	}
	
	public double getMe(String est) {
		int cont = 0;
		double med = 0;
		for(int i=0; i<numObs; i++) {
			if(est.equalsIgnoreCase(obs[i].getEst())) {
				med+= obs[i].getMag();
				cont++;
			}
		}
		if(cont == 0) {
			throw new NoSuchElementException();
		}
		
		return med/cont;
	}
	
	@Override
	public String toString() {
		StringJoiner sj = new StringJoiner(", ", "[", "]");
		for(int i=0;i<numObs;i++) {
			sj.add(obs[i].toString());
		}

		return sj.toString();
	}
}
