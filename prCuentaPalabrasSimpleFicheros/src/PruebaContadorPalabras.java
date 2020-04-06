import prCuentaPalabrasSimpleFicheros.ContadorPalabras;

public class PruebaContadorPalabras {
	
	public static void main(String args[]) {
		String [] datos = {
				"Esta es la primera frase del ejemplo",
				"y esta es la segunda frase"
		};
		
		ContadorPalabras palabras = new ContadorPalabras(5);
		palabras.incluyeTodas(datos, "[ ]");
		
		System.out.println(palabras.toString());
	}
}
