package ajedrez;

import java.io.PrintWriter;
import java.util.*;

public abstract class SistemaAbstracto implements Sistema {

	private List<Emparejamiento> parejas;
	
	public SistemaAbstracto() {
		parejas = new LinkedList<Emparejamiento>();
	}

	@Override
	public List<Emparejamiento> getParejas() {
		return parejas;
	}

	@Override
	public void presentarEmparejamientosConsola() {
		try(PrintWriter pw = new PrintWriter(System.out, true)){
			presentarEmparejamientos(pw);
		}

	}

	@Override
	public void presentarEmparejamientos(PrintWriter pw) {
		for(Emparejamiento emp: getParejas()) {
			pw.println(emp.toString());
		}

	}
	
	protected void limpiarEmparejamientos() {
		parejas.clear();
	}
	
	protected void agregarEmparejamiento(Emparejamiento e) {
		if(!parejas.contains(e)) {
			parejas.add(e);
		}
	}
}
