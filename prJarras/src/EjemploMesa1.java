import prJarras.Mesa;

public class EjemploMesa1 {
	public static void main (String [ ] args) {

		Mesa mesaA = new Mesa(5,7);
		mesaA.llena(1);
		mesaA.llenaDesde(1);
		mesaA.llena(1);
		mesaA.llenaDesde(1);
		mesaA.vacia(2);
		mesaA.llenaDesde(1);
		mesaA.llena(1);
		mesaA.llenaDesde(1);
		System.out.println(mesaA.toString());
	}
}
