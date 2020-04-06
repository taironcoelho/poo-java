package prCuentasGUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelCuenta2 extends JPanel implements VistaCuenta {
	private JTextField cantidad;
	private JLabel mensaje, saldo;
	private JButton ingresar, extraer;

	public PanelCuenta2() {
		// componentes del panel
		cantidad = new JTextField(10);
		cantidad.setHorizontalAlignment(JTextField.RIGHT);
		saldo = new JLabel(" ");
		saldo.setHorizontalAlignment(JTextField.CENTER);
		mensaje = new JLabel(" ");
		ingresar = new JButton("Ingresar");
		extraer = new JButton("Extraer");
		// zona izquierda
		JPanel panelIzq = new JPanel();
		panelIzq.setLayout(new GridLayout(2, 1));
		panelIzq.add(cantidad);
		JPanel acciones = new JPanel();
		acciones.setLayout(new GridLayout(1, 2, 5, 5));
		acciones.add(ingresar);
		acciones.add(extraer);
		panelIzq.add(acciones);
		// zona derecha
		JPanel panelDer = new JPanel();
		panelDer.setLayout(new BorderLayout());
		panelDer.add(saldo, BorderLayout.CENTER);
		panelDer.add(mensaje, BorderLayout.SOUTH);
		// distribuicion de los componentes en el panel
		setLayout(new GridLayout(1, 2));
		add(panelIzq);
		add(panelDer);
	}

	@Override
	public void controlador(ActionListener ctr) {
		ingresar.addActionListener(ctr);
		ingresar.setActionCommand(INGRESO);
		extraer.addActionListener(ctr);
		extraer.setActionCommand(GASTO);
	}

	@Override
	public double obtenerCantidad() {
		// puede lanzar una NumberFormatException
		return Double.parseDouble(cantidad.getText());
	}

	@Override
	public void saldo(double cantidad) {
		saldo.setText(String.format("Saldo %12.2f", cantidad));
	}

	@Override
	public void mensaje(String msg) {
		mensaje.setText(msg);
	}
}
