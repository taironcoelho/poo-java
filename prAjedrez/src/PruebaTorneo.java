import java.util.List;

import ajedrez.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class PruebaTorneo {

	public static void main(String[] args) {
		SistemaPuntuacion sistema = new SistemaPuntuacion();
		try {
			Torneo torneo = new Torneo(sistema, "jugadores.txt");
			torneo.ronda();
			torneo.escribirTorneoConsola();
		} catch (FileNotFoundException e) {
			//// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
