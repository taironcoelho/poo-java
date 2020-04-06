import prTxt.Texto;

public class PruebaTexto {
	public static void main(String[] args) {
		try {
			Texto txt = new Texto();
			txt.anyadirTexto("Tuvo un coche rojo, que mantuvo en el garaje.");
			txt.anyadirTexto("Pepe sostuvo la bolsa en la mano.");
			txt.anyadirTexto("La fiesta estuvo muy bien.");
			txt.anyadirTexto("El coche es rojo.");
			System.out.println(txt);
			txt.guardarEnFichero("texto.txt");
			txt.reemplazar("tuvo", "tiene");
			System.out.println(txt);
			Texto txt2 = new Texto();
			txt2.cargarDeFichero("texto.txt");
			System.out.println(txt2);
		} catch (Exception e) {
			System.out.println("Error: "+e);
		}
	}
}