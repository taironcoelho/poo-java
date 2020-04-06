package prDatosAbiertos;

import java.util.StringJoiner;

public class DatosBus {
	private final String codBus; // código de autobus
	private final double codLinea; // código de línea
	private final int sentido; // sentido de travesía (ida:1, vuelta:2)
	private final double lon; // longitud
	private final double lat; // latitud
	private final String codParIni; // código de parada inicial
	private final String lastUpdate;// fecha y hora de la última actualización

	public DatosBus(String bus, double linea, int sent, double ln, double lt, String par, String ludt) {
		codBus = bus;
		codLinea = linea;
		sentido = sent;
		lon = ln;
		lat = lt;
		codParIni = par;
		lastUpdate = ludt;
	}

	public String getCodBus() {
		return codBus;
	}

	public double getCodLinea() {
		return codLinea;
	}

	public int getSentido() {
		return sentido;
	}

	public double getLon() {
		return lon;
	}

	public double getLat() {
		return lat;
	}

	public String getCodParIni() {
		return codParIni;
	}

	public String getLastUpdate() {
		return lastUpdate;
	}

	@Override
	public String toString() {
		StringJoiner sj = new StringJoiner(", ", "(", ")");
		sj.add(codBus);
		sj.add(String.valueOf(codLinea));
		sj.add(String.valueOf(sentido));
		sj.add(String.valueOf(lon));
		sj.add(String.valueOf(lat));
		sj.add(codParIni);
		sj.add(lastUpdate);
		return sj.toString();
	}

	@Override
	public boolean equals(Object o) {
		boolean ok = false;
		if (o instanceof DatosBus) {
			DatosBus x = (DatosBus) o;
			ok = this.codBus.equals(x.codBus);
		}
		return ok;
	}

	@Override
	public int hashCode() {
		return codBus.hashCode();
	}
}