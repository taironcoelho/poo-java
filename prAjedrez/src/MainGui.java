import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ajedrez.PanelTorneo;
import ajedrez.VistaTorneo;
import ajedrez.CtrTorneo;

public class MainGui {
	public static void main(String [] args) {
		VistaTorneo vistaTorneo = new PanelTorneo();
		ActionListener ctrTorneo = new CtrTorneo(vistaTorneo);
		vistaTorneo.controlador(ctrTorneo);
		
		JFrame ventana = new JFrame("Torneo de ajedrez");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setContentPane((JPanel)vistaTorneo);
		ventana.pack();
		ventana.setVisible(true);
	}
}
