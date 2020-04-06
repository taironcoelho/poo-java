import java.util.Scanner;
import java.util.Locale;
import java.util.Optional;
import prDatosAbiertos.DatosBus;
import prDatosAbiertos.ListaBus;

public class PruebaDatosAbiertos {
	private static final double centroMalagaLongitud = -4.421486050453723;
	private static final double centroMalagaLatitud = 36.71798707733797;

	public static void main(String[] args) {
		try {
			Scanner teclado = new Scanner(System.in);
			teclado.useLocale(Locale.ENGLISH);
			ListaBus lista = new ListaBus();
			lista.cargarDatosAbiertos();
			System.out.println(lista);
			double longitud = centroMalagaLongitud;
			double latitud = centroMalagaLatitud;
			while ((longitud != 0.0) || (latitud != 0.0)) {
				Optional<DatosBus> b = lista.buscarBusMasCercano(longitud, latitud);
				if (b.isPresent()) {
					System.out.println("Autobus más cercano: " + b.get());
				} else {
					System.out.println("Lista vacía");
				}
				longitud = inputNextDouble(teclado, "Introduce longitud: ");
				latitud = inputNextDouble(teclado, "Introduce latitud: ");
			}
		} catch (Exception e) {
			System.err.println("Error: " + e);
		}
	}

	private static double inputNextDouble(Scanner teclado, String msg) {
		System.out.print(msg);
		while (!teclado.hasNextDouble()) {
			teclado.next();
			System.out.print("Error. " + msg);
		}
		return teclado.nextDouble();
	}
}