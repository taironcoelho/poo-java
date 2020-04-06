package prCuentasGUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PanelCuenta1 extends JPanel implements VistaCuenta {
	private JTextField cantidad;
	private JLabel mensaje, saldo;
	private JButton ingresar, extraer, peticionSaldo;

	public PanelCuenta1() {
		// componentes del panel
		cantidad = new JTextField(10);
		saldo = new JLabel(" ");
		mensaje = new JLabel(" ");
		ingresar = new JButton("Ingresar");
		extraer = new JButton("Extraer");
		peticionSaldo = new JButton("Saldo");
		// distribuicion de los componentes en el panel
		setLayout(new BorderLayout());
		// zona central
		JPanel panelCentral = new JPanel();
		panelCentral.setLayout(new GridLayout(2, 2));
		panelCentral.add(new JLabel("Cantidad: "));
		panelCentral.add(cantidad);
		panelCentral.add(new JLabel("Saldo: "));
		panelCentral.add(saldo);
		add(panelCentral, BorderLayout.CENTER);
		// zona este
		JPanel panelEste = new JPanel();
		panelEste.setLayout(new GridLayout(3, 1));
		panelEste.add(ingresar);
		panelEste.add(extraer);
		panelEste.add(peticionSaldo);
		add(panelEste, BorderLayout.EAST);
		// zona sur
		add(mensaje, BorderLayout.SOUTH);
	}

	@Override
	public void controlador(ActionListener ctr) {
		ingresar.addActionListener(ctr);
		ingresar.setActionCommand(INGRESO);
		extraer.addActionListener(ctr);
		extraer.setActionCommand(GASTO);
		peticionSaldo.addActionListener(ctr);
		peticionSaldo.setActionCommand(SALDO);
	}

	@Override
	public double obtenerCantidad() {
		// puede lanzar una NumberFormatException
		return Double.parseDouble(cantidad.getText());
	}

	@Override
	public void saldo(double cantidad) {
		saldo.setText(String.format("%12.2f", cantidad));
	}

	@Override
	public void mensaje(String msg) {
		mensaje.setText(msg);
	}
}
