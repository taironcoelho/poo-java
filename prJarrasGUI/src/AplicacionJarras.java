import prJarrasGUI.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AplicacionJarras {
	public static void main(String[] args) {
		VistaJarras panel = new PanelJarras();
		ControladorJarra ctr = new ControladorJarra(panel);
		panel.controlador(ctr);
		JFrame ventana = new JFrame("Jarras");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setContentPane((JPanel) panel);
		ventana.pack();
		ventana.setVisible(true);
	}
}