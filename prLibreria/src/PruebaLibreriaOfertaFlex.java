import prLibreria.*;

public class PruebaLibreriaOfertaFlex {
	private static void addLibros(Libreria l) {
		l.addLibro("george orwell", "1984", 8.20);
		l.addLibro("Philip K. Dick", "¿Sueñan los androides con ovejas eléctricas?", 3.50);
		l.addLibro("Isaac Asimov", "Fundación e Imperio", 9.40);
		l.addLibro("Ray Bradbury", "Fahrenheit 451", 7.40);
		l.addLibro("Alex Huxley", "Un Mundo Feliz", 6.50);
		l.addLibro("Isaac Asimov", "La Fundación", 7.30);
		l.addLibro("William Gibson", "Neuromante", 8.30);
		l.addLibro("Isaac Asimov", "Segunda Fundación", 8.10);
		l.addLibro("Isaac Newton", "arithmetica universalis", 7.50);
		l.addLibro("George Orwell", "1984", 6.20);
		l.addLibro("Isaac Newton", "Arithmetica Universalis", 10.50);
	}
	
	private static void remLibros(Libreria l) {
		l.remLibro("George Orwell", "1984");
		l.remLibro("Alex Huxley", "Un Mundo Feliz");
		l.remLibro("Isaac Newton", "Arithmetica Universalis");
	}
	
	private static void printPrecios(Libreria l) {
		System.out.println("getPrecioFinal(George Orwell, 1984) "
		+ l.getPrecioFinal("George Orwell", "1984"));
		System.out.println("getPrecioFinal(Philip K. Dick, ¿Sueñan los androides con ovejas eléctricas?) "
		+ l.getPrecioFinal("Philip K. Dick", "¿Sueñan los androides con ovejas eléctricas?"));
		System.out.println("getPrecioFinal(isaac asimov, fundación e imperio) "
		+ l.getPrecioFinal("isaac asimov", "fundación e imperio"));
		System.out.println("getPrecioFinal(Ray Bradbury, Fahrenheit 451) "
		+ l.getPrecioFinal("Ray Bradbury", "Fahrenheit 451"));
		System.out.println("getPrecioFinal(Alex Huxley, Un Mundo Feliz) "
		+ l.getPrecioFinal("Alex Huxley", "Un Mundo Feliz"));
		System.out.println("getPrecioFinal(Isaac Asimov, La Fundación) "
		+ l.getPrecioFinal("Isaac Asimov", "La Fundación"));
		System.out.println("getPrecioFinal(william gibson, neuromante) "
		+ l.getPrecioFinal("william gibson", "neuromante"));
		System.out.println("getPrecioFinal(Isaac Asimov, Segunda Fundación) "
		+ l.getPrecioFinal("Isaac Asimov", "Segunda Fundación"));
		System.out.println("getPrecioFinal(Isaac Newton, Arithmetica Universalis) "
		+ l.getPrecioFinal("Isaac Newton", "Arithmetica Universalis"));
	}
	public static void main(String[] args) {
		String[] autoresOferta = { "George Orwell", "Isaac Asimov" };
		OfertaFlex oferta = new OfertaAutor(20, autoresOferta);
		Libreria l;
		try {
			l = new LibreriaOfertaFlex(Integer.parseInt(args[0]), oferta);
		} catch (Exception e) {
			l = new LibreriaOfertaFlex(oferta);
		}
		addLibros(l);
		System.out.println();
		System.out.println(l);
		System.out.println();
		remLibros(l);
		System.out.println();
		System.out.println(l);
		System.out.println();
		printPrecios(l);
	}
}
