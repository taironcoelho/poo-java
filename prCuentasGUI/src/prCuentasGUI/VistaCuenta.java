package prCuentasGUI;

import java.awt.event.*;

public interface VistaCuenta {
	String INGRESO = "INGRESO";
	String GASTO = "GASTO";
	String SALDO = "SALDO";

	/**
	 * Obtenemos la cantidad a ingresar o extraer
	 * 
	 * @return double con la cantidad a ingresar
	 */
	double obtenerCantidad();

	/**
	 * Establecemos el saldo de la cuenta.
	 * 
	 * @param saldo
	 *            double con el saldo de la cuenta.
	 */
	void saldo(double saldo);

	/**
	 * Mostramos un mensaje de información.
	 * 
	 * @param msg
	 *            String con el mensaje a mostrar.
	 */
	void mensaje(String msg);

	/**
	 * Pasamos el controlador.
	 * 
	 * @param ctr
	 *            controlador
	 */
	void controlador(ActionListener ctr);
}