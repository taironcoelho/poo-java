import prLibreria.Libreria;
import prLibreria.Libro;

public class EjemploUsoLibreria1 {
	public static void main (String [ ] args) {
		Libreria libreria = new Libreria();
		
		libreria.addLibro("george orwell", "1984", 8.20);
		libreria.addLibro("Philip K. Dick", "¿Sueñan los androides con ovejas eléctricas?", 3.50);
		libreria.addLibro("Isaac Asimov", "Fundación e Imperio", 9.40);
		libreria.addLibro("Ray Bradbury", "Fahrenheit 451", 7.40);
		libreria.addLibro("Aldous Huxley", "Un Mundo Feliz", 6.50);
		libreria.addLibro("Isaac Asimov", "La Fundación", 7.30);
		libreria.addLibro("William Gibson", "Neuromante", 8.30);
		libreria.addLibro("Isaac Asimov", "Segunda Fundación", 8.10);
		libreria.addLibro("Isaac Newton", "arithmetica universalis", 7.50);
		
		libreria.remLibro("George Orwell", "1984");
		libreria.remLibro("Aldous Huxley", "Un Mundo Feliz");
		libreria.remLibro("Isaac Newton", "Arithmetica Universalis");
		libreria.remLibro("James Gosling", "The Java Language Specification");

		System.out.println(libreria.getPrecioFinal("George Orwell", "1984"));
		System.out.println(libreria.getPrecioFinal("Philip K. Dick", "¿Sueñan los androides con ovejas eléctricas?"));
		System.out.println(libreria.getPrecioFinal("isaac asimov", "fundación e imperio"));
		System.out.println(libreria.getPrecioFinal("Ray Bradbury", "Fahrenheit 451"));
		System.out.println(libreria.getPrecioFinal("Aldous Huxley", "Un Mundo Feliz"));
		System.out.println(libreria.getPrecioFinal("Isaac Asimov", "La Fundación"));
		System.out.println(libreria.getPrecioFinal("william gibson", "neuromante"));
		System.out.println(libreria.getPrecioFinal("Isaac Asimov", "Segunda Fundación"));
		System.out.println(libreria.getPrecioFinal("Isaac Newton", "Arithmetica Universalis"));
	}
}
