package prJarras;

public class Mesa {
	
	private Jarra[] jarras = new Jarra[2];
	
	public Mesa(Jarra a, Jarra b) {
		jarras[0] = a;
		jarras[1] = b;
	}
	
	public Mesa(int capA, int capB) {
		jarras[0] = new Jarra(capA);
		jarras[1] = new Jarra(capB);
	}
	
	public int capacidad(int id) {
		checkJarraId(id);
		return jarras[id-1].capacidad();
	}
	
	public int contenido(int id) {
		checkJarraId(id);
		return jarras[id-1].contenido();
	}
	
	public void llena(int id) {
		checkJarraId(id);
		jarras[id-1].llena();
	}
	
	public void vacia(int id) {
		checkJarraId(id);
		jarras[id-1].vacia();
	}
	
	public void llenaDesde(int id) {
		if(id == 1) {
			jarras[1].llenaDesde(jarras[0]);
		} else if(id==2) {
			jarras[0].llenaDesde(jarras[1]);
		} else {
			throw new RuntimeException("Jarra errónea");
		}
	}
	
	private void checkJarraId(int id) {
		if(id < 0 || id>2) {
			throw new RuntimeException("Jarra errónea");
		}
	}
	
	@Override
	public String toString() {
		String res = "M(" + jarras[0].toString();
		for(int i=1; i<jarras.length;i++) {
			res+= "," + jarras[i].toString();
		}
		res+=")";
		return res;
	}
}
