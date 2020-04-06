package regata;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class CtrRegata implements ActionListener{
	VistaRegata vista;
	Regata regata;
	
	public CtrRegata(VistaRegata v) {
		vista = v;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String c = e.getActionCommand();
		
		switch(c) {
			case VistaRegata.LEE:
			try {
				String fichero = vista.getFicheroEntrada();
				regata = new Regata();
				regata.leeFichero(fichero);
				vista.limpiaPantalla();
				for(Barco b: regata.getParticipantes()) {
					vista.agregaLinea(b.toString());
				}
				vista.setMensaje("Fichero leido");
			} catch (FileNotFoundException e1) {
				vista.limpiaPantalla();
				vista.setMensaje(e1.getMessage());
			}
				break;
			case VistaRegata.AVANZA:
				regata.avanza(10);
				vista.limpiaPantalla();
				for(Barco b: regata.getParticipantes()) {
					vista.agregaLinea(b.toString());
				}
				vista.setMensaje("Regata avanzada");
				break;
			case VistaRegata.GUARDA:
				
				try {
					String fichero = vista.getFicheroSalida();
					regata.escribeFichero(fichero);
					vista.limpiaPantalla();
					vista.setMensaje("Guardado con suceso");
				} catch (FileNotFoundException e1) {
					vista.limpiaPantalla();
					vista.setMensaje(e1.getMessage());
				}
				
				break;
		}
		
	}

}
