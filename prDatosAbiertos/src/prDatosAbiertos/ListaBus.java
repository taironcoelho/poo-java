package prDatosAbiertos;

import java.util.StringJoiner;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Locale;
import java.util.Optional;
import java.io.IOException;
import java.net.URL;

public class ListaBus {
	private static final int TAM = 8;
	private int ndatos;
	private DatosBus[] datos;

	public ListaBus() {
		datos = new DatosBus[TAM];
	}

	public void anyadir(DatosBus b) {
		int pos = buscarBus(b);
		if (0 <= pos && pos < ndatos) {
			datos[pos] = b;
		} else {
			if (ndatos == datos.length) {
				datos = Arrays.copyOf(datos, 2 * datos.length);
			}
			datos[ndatos] = b;
			++ndatos;
		}
	}

	private int buscarBus(DatosBus b) {
		int i = 0;
		while ((i < ndatos) && !datos[i].equals(b)) {
			++i;
		}
		if (i == ndatos) {
			i = -1;
		}
		return i;
	}

	public void cargarDatosAbiertos() throws IOException {
		String urlDatosAbiertos = "http://datosabiertos.malaga.eu/recursos/transporte/EMT/EMTLineasUbicaciones/"
				+ "lineasyubicaciones.csv";
		cargarCsvDeURL(urlDatosAbiertos);
	}

	public void cargarCsvDeURL(String stUrl) throws IOException {
		URL url = new URL(stUrl);
		try (Scanner sc = new Scanner(url.openStream())) { 
			while (sc.hasNextLine()) { // Busca una linea por vez, não descarga o arquivo
				String linea = sc.nextLine();
				try {
					anyadir(createBusCsv(linea));
				} catch (Exception e) {
					System.err.println("Error procesando [" + linea + "]");
				}
			}
		}
	}

	private DatosBus createBusCsv(String linea) {
		try (Scanner sc = new Scanner(linea)) {
			sc.useDelimiter("\",\"|\",|,\"|\"|,");
			sc.useLocale(Locale.ENGLISH);
			return new DatosBus(sc.next(), sc.nextDouble(), sc.nextInt(), sc.nextDouble(), sc.nextDouble(), sc.next(),
					sc.next());
		}
	}

	private DatosBus createBusCsvAlternativoConSplit(String linea) {
		String[] dt = linea.split("\",\"|\",|,\"|\"|,");
		if ((dt.length != 8) || (dt[0].length() != 0)) {
			throw new RuntimeException("Bad Format");
		}
		// Nótese que dt[0] es la cadena vacia porque el delimitador "
		// aparece al principio de la linea
		return new DatosBus(dt[1], Double.parseDouble(dt[2]), Integer.parseInt(dt[3]), Double.parseDouble(dt[4]),
				Double.parseDouble(dt[5]), dt[6], dt[7]);
	}

	@Override
	public String toString() {
		StringJoiner sj = new StringJoiner(";\n", "[ ", " ]");
		for (int i = 0; i < ndatos; ++i) {
			sj.add(datos[i].toString());
		}
		return sj.toString();
	}

	public Optional<DatosBus> buscarBusMasCercano(double lon, double lat) {
		Optional<DatosBus> b;
		if (ndatos == 0) {
			b = Optional.empty();
		} else {
			int idx = 0;
			double dst = Math.hypot(datos[idx].getLon() - lon, datos[idx].getLat() - lat);
			for (int i = 1; i < ndatos; ++i) {
				double d = Math.hypot(datos[i].getLon() - lon, datos[i].getLat() - lat);
				if (d < dst) {
					dst = d;
					idx = i;
				}
			}
			b = Optional.of(datos[idx]);
		}
		return b;
	}
}