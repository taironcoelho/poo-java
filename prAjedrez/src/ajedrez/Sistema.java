package ajedrez;

import java.io.PrintWriter;
import java.util.*;

public interface Sistema {
	public abstract void emparejar(List<Jugador> jugadores);
	
	public abstract List<Emparejamiento> getParejas();
	
	public abstract void presentarEmparejamientosConsola();
	
	public abstract void presentarEmparejamientos(PrintWriter pw);
	
}
