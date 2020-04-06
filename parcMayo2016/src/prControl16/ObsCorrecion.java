package prControl16;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class ObsCorrecion extends Observaciones{
	Correcion[] corr;
	
	public ObsCorrecion() {
		super();
	}
	
	public ObsCorrecion(int tam) {
		super(tam);
	}
	
	public ObsCorrecion(Correcion[] co) {
		super();
		corr = new Correcion[co.length];
		corr = Arrays.copyOf(co, co.length);
	}
	
	@Override
	public double getMoe(String ob, String est) {
		double moe = super.getMoe(ob, est);
		double fcor = 1;
		for(int i=0;i<corr.length;i++) {
			if(corr[i].getObs().equalsIgnoreCase(ob)){
				fcor = corr[i].getCo();
			}
		}
		return moe*fcor;
	}
	
	/*@Override
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
	}*/
	
	@Override
	public String toString() {
		String part1 = super.toString() + ",";
		
		StringJoiner sj = new StringJoiner(",","[","]");
		
		for(int i=0;i<corr.length;i++) {
			sj.add(corr[i].toString());
		}
		return part1 + sj.toString();
	}
	
}
