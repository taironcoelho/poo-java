
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

import prCuentasGUI.*;

public class CuentaDemo {
    public static void main(String args[]) {
    	// el modelo
		Cuenta cuenta;
		try {
			cuenta = new Cuenta(Double.parseDouble(args[0]));
		} catch (Exception e) {
			cuenta = new Cuenta(0);
		}
    	
    	// la vista
        //VistaCuenta vistaCuenta = new PanelCuenta1();
        //VistaCuenta vistaCuenta = new PanelCuenta2();
    	VistaCuenta vistaCuenta = new PanelCuenta3();
    	
    	// el controlador
    	ActionListener ctrCuenta = new ControladorCuentas(vistaCuenta,cuenta);
    	
    	// registro del controlador en la vista
    	vistaCuenta.controlador(ctrCuenta);
    	
    	// crear la ventana para visualizar la vista
		JFrame ventana = new JFrame("Control de Cuentas");  	
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setContentPane((JPanel) vistaCuenta);		 
		ventana.pack();	
		ventana.setVisible(true);       
    }
}
