package prCuentasGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorCuentas implements ActionListener{
	
	private VistaCuenta vista;
	private Cuenta cuenta;
	
	public ControladorCuentas(VistaCuenta v, Cuenta c) {
		vista = v;
		cuenta = c;
		saldo();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String c = e.getActionCommand();
			switch (c) {
				case VistaCuenta.INGRESO:
					ingreso();
				break;
				case VistaCuenta.GASTO:
					extraer();
				break;
				case VistaCuenta.SALDO:
					saldo();
				break;
			}
		} catch (NumberFormatException ex) {
			vista.mensaje("Error: Cantidad errónea");
		} catch (Exception ex) {
			vista.mensaje(ex.getMessage());
		}
	}
	
	private void ingreso() {
		double cantidad = vista.obtenerCantidad();
		cuenta.ingresa(cantidad);
		vista.mensaje("Ingreso de "+ cantidad + " realizado con éxito");
		vista.saldo(cuenta.saldo());
	}
	
	private void extraer() {
		double cantidad = cuenta.extrae(vista.obtenerCantidad());
		vista.mensaje("Extracción de "+ cantidad + " realizada con éxito");
		vista.saldo(cuenta.saldo());
	}
	
	private void saldo() {
		vista.saldo(cuenta.saldo());
		vista.mensaje("Actualización de saldo realizada con éxito");
	}

}
