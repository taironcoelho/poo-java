package prCuentasGUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DefaultCaret;

public class PanelCuenta3 extends JPanel implements VistaCuenta, ActionListener {
	private JTextField cantidad;
	private JLabel saldo;
	private JTextArea mensaje;
	private JButton ingresar, extraer, borrar;
	private JButton[] botonera = new JButton[10];

	public PanelCuenta3() {
		// componentes del panel
		cantidad = new JTextField(10);
		cantidad.setHorizontalAlignment(JTextField.RIGHT);
		cantidad.setEditable(false);
		saldo = new JLabel(" ");
		saldo.setHorizontalAlignment(JTextField.RIGHT);
		mensaje = new JTextArea();
		mensaje.setEditable(false);
		DefaultCaret caret = (DefaultCaret) mensaje.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		JScrollPane scMensaje = new JScrollPane(mensaje);
		ingresar = new JButton("Ingresar");
		extraer = new JButton("Extraer");
		borrar = new JButton("Borrar");
		borrar.addActionListener(this);
		borrar.setActionCommand("BORRAR");
		for (int cont = 0; cont <= 9; cont++) {
			botonera[cont] = new JButton(Integer.toString(cont));
			botonera[cont].addActionListener(this);
			botonera[cont].setActionCommand(Integer.toString(cont));
		}
		// distribuicion de los componentes en el panel principal
		setLayout(new GridLayout(2, 1));
		// componente panel arriba
		JPanel panelArriba = new JPanel();
		panelArriba.setLayout(new BorderLayout());
		panelArriba.add(cantidad, BorderLayout.NORTH);
		panelArriba.add(saldo, BorderLayout.SOUTH);
		JPanel botones = new JPanel();
		botones.setLayout(new GridLayout(4, 3, 1, 1));
		for (int cont = 1; cont <= 9; cont++) {
			botones.add(botonera[cont]);
		}
		botones.add(botonera[0]);
		botones.add(new JLabel(""));
		botones.add(borrar);
		JPanel acciones = new JPanel();
		acciones.setLayout(new GridLayout(2, 1, 5, 5));
		acciones.add(ingresar);
		acciones.add(extraer);
		JPanel central = new JPanel();
		central.setLayout(new BorderLayout());
		central.add(botones, BorderLayout.WEST);
		central.add(new JLabel(" "), BorderLayout.CENTER);
		central.add(acciones, BorderLayout.EAST);
		panelArriba.add(central, BorderLayout.CENTER);
		// anyadimos los componentes del panel principal
		add(panelArriba);
		add(scMensaje);
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
		mensaje.append(msg + "\n");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if (comando.equals("BORRAR")) {
			cantidad.setText("0");
		} else {
			String c = cantidad.getText();
			int i = Integer.parseInt(comando);
			cantidad.setText(Integer.toString(i + 10 * Integer.parseInt(c.equals("") ? "0" : c)));
		}
	}
}
