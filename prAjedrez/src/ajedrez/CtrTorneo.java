package ajedrez;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class CtrTorneo implements ActionListener{
	
	private VistaTorneo vista;
	private Torneo torneo;

	public CtrTorneo(VistaTorneo v) {
		vista = v;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String c = e.getActionCommand();
		
		switch(c) {
		case VistaTorneo.LEE:
			try {
				torneo = new Torneo(new SistemaPuntuacion(), vista.getFicheroEntrada());
				vista.limpiaPantalla();
				for(Jugador jugador: torneo.getJugadores()) {
					vista.agregaLinea(jugador.toString());
				}
				
				vista.setMensaje("Torneo creado");
			} catch (FileNotFoundException e1) {
				vista.setMensaje("Error");
			}
			break;
		case VistaTorneo.GUARDA:
			try {
				torneo.escribirTorneo(vista.getFicheroSalida());
			} catch (FileNotFoundException e1) {
				vista.setMensaje("ERROR");
			}
			vista.setMensaje("Fichero creado");
			break;
		case VistaTorneo.RONDA:
			torneo.ronda();
			vista.limpiaPantalla();
			
			for(Jugador jugador: torneo.getJugadores()) {
				vista.agregaLinea(jugador.toString());
			}
			
			vista.setMensaje("Ronda realizada");
			
			break;
		}
	}

}
