import prCuentaPalabrasSimpleFicheros.PalabraEnTexto;

public class PruebaPalabraEnTexto {

	public static void main(String args[]) {
		PalabraEnTexto p1 = new PalabraEnTexto("gorra");
		PalabraEnTexto p2 = new PalabraEnTexto("GORRA");
		
		p1.incrementa();
		
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		
		if(p1.equals(p2)) {
			System.out.println("Las palabras son iguales");
		}
	}
}
