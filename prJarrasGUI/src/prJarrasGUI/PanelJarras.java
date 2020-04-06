package prJarrasGUI;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.text.DefaultCaret;

public class PanelJarras extends JPanel implements VistaJarras {
	private JTextField capacidadInicialJarraA, capacidadInicialJarraB, capacidadJarraA, capacidadJarraB,
			contenidoJarraA, contenidoJarraB;
	private JButton iniciarCap, llenarA, vaciarA, llenarB, vaciarB, trasvaseAaB, trasvaseBaA, finalizar;
	private JLabel mensaje;
	private JTextArea historico;

	public PanelJarras() {
		// panel norte
		JPanel norte = new JPanel();
		norte.setLayout(new GridLayout(1, 3, 5, 5));
		JLabel jA = new JLabel("Jarra A");
		capacidadInicialJarraA = new JTextField(5);
		iniciarCap = new JButton("Iniciar Capacidades");
		JLabel jB = new JLabel("Jarra B");
		capacidadInicialJarraB = new JTextField(5);
		JPanel izq = new JPanel();
		izq.add(jA);
		izq.add(capacidadInicialJarraA);
		JPanel der = new JPanel();
		der.add(jB);
		der.add(capacidadInicialJarraB);
		norte.add(izq);
		norte.add(iniciarCap);
		norte.add(der);
		// panel central
		// conjunto de botones para realizar proceso con jarras
		// sobre jarra A
		llenarA = new JButton("Llenar");
		vaciarA = new JButton("Vaciar");
		JPanel datosContenidoA = new JPanel();
		JLabel contenidoA = new JLabel("Contenido:");
		contenidoJarraA = new JTextField(5);
		contenidoJarraA.setEditable(false);
		datosContenidoA.add(contenidoA);
		datosContenidoA.add(contenidoJarraA);
		JPanel datosCapacidadA = new JPanel();
		JLabel capacidadA = new JLabel("Capacidad:");
		capacidadJarraA = new JTextField(5);
		capacidadJarraA.setEditable(false);
		datosCapacidadA.add(capacidadA);
		datosCapacidadA.add(capacidadJarraA);
		JPanel zonaJA = new JPanel();
		zonaJA.setLayout(new GridLayout(4, 1, 5, 5));
		zonaJA.add(llenarA);
		zonaJA.add(datosContenidoA);
		zonaJA.add(datosCapacidadA);
		zonaJA.add(vaciarA);
		// trasvases
		JPanel botonesTrasvase = new JPanel();
		botonesTrasvase.setLayout(new GridLayout(3, 1, 5, 5));
		trasvaseAaB = new JButton(new ImageIcon("TrasvaseDeAaB.JPG"));
		trasvaseBaA = new JButton(new ImageIcon("TrasvaseDeBaA.JPG"));
		// trasvaseAaB = new JButton(new
		// ImageIcon(getClass().getResource("TrasvaseDeAaB.JPG")));
		// trasvaseBaA = new JButton(new
		// ImageIcon(getClass().getResource("TrasvaseDeBaA.JPG")));
		finalizar = new JButton("Finalizar");
		botonesTrasvase.add(trasvaseAaB);
		botonesTrasvase.add(trasvaseBaA);
		botonesTrasvase.add(finalizar);
		// sobre jarra B
		llenarB = new JButton("Llenar");
		vaciarB = new JButton("Vaciar");
		JPanel datosContenidoB = new JPanel();
		JLabel contenidoB = new JLabel("Contenido:");
		contenidoJarraB = new JTextField(5);
		contenidoJarraB.setEditable(false);
		datosContenidoB.add(contenidoB);
		datosContenidoB.add(contenidoJarraB);
		JPanel datosCapacidadB = new JPanel();
		JLabel capacidadB = new JLabel("Capacidad:");
		capacidadJarraB = new JTextField(5);
		capacidadJarraB.setEditable(false);
		datosCapacidadB.add(capacidadB);
		datosCapacidadB.add(capacidadJarraB);
		JPanel zonaJB = new JPanel();
		zonaJB.setLayout(new GridLayout(4, 1, 5, 5));
		zonaJB.add(llenarB);
		zonaJB.add(datosContenidoB);
		zonaJB.add(datosCapacidadB);
		zonaJB.add(vaciarB);
		// creacion area de proceso
		JPanel proceso = new JPanel();
		proceso.setLayout(new GridLayout(1, 3, 5, 5));
		proceso.add(zonaJA);
		proceso.add(botonesTrasvase);
		proceso.add(zonaJB);
		// area de texto en panel central
		historico = new JTextArea();
		historico.setEditable(false);
		DefaultCaret caret = (DefaultCaret) historico.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		JScrollPane scHistorico = new JScrollPane(historico);
		// creacion de panel central
		JPanel central = new JPanel();
		central.setLayout(new GridLayout(2, 1, 5, 5));
		central.add(proceso);
		central.add(scHistorico);
		// panel sur
		mensaje = new JLabel();
		// panel principal
		setLayout(new BorderLayout());
		add(norte, BorderLayout.NORTH);
		add(central, BorderLayout.CENTER);
		add(mensaje, BorderLayout.SOUTH);
	}

	@Override
	public void controlador(ActionListener ctr) {
		iniciarCap.addActionListener(ctr);
		iniciarCap.setActionCommand(INICIAR);
		finalizar.addActionListener(ctr);
		finalizar.setActionCommand(FINALIZAR);
		llenarA.addActionListener(ctr);
		llenarA.setActionCommand(LLENAR_A);
		llenarB.addActionListener(ctr);
		llenarB.setActionCommand(LLENAR_B);
		vaciarA.addActionListener(ctr);
		vaciarA.setActionCommand(VACIAR_A);
		vaciarB.addActionListener(ctr);
		vaciarB.setActionCommand(VACIAR_B);
		trasvaseAaB.addActionListener(ctr);
		trasvaseAaB.setActionCommand(VOLCAR_A_EN_B);
		trasvaseBaA.addActionListener(ctr);
		trasvaseBaA.setActionCommand(VOLCAR_B_EN_A);
	}

	@Override
	public int capacidadInicialA() {
		return Integer.parseInt(capacidadInicialJarraA.getText());
	}

	@Override
	public int capacidadInicialB() {
		return Integer.parseInt(capacidadInicialJarraB.getText());
	}

	@Override
	public void error(String mensaje) {
		this.mensaje.setForeground(Color.RED);
		this.mensaje.setText(mensaje);
	}

	@Override
	public void ok(String mensaje) {
		this.mensaje.setForeground(Color.BLUE);
		this.mensaje.setText(mensaje);
	}

	@Override
	public void habilitarInicio(boolean b) {
		iniciarCap.setEnabled(b);
		capacidadInicialJarraA.setEnabled(b);
		capacidadInicialJarraB.setEnabled(b);
		llenarA.setEnabled(!b);
		llenarB.setEnabled(!b);
		vaciarA.setEnabled(!b);
		vaciarB.setEnabled(!b);
		trasvaseAaB.setEnabled(!b);
		trasvaseBaA.setEnabled(!b);
		finalizar.setEnabled(!b);
	}

	@Override
	public void capacidadA(int c) {
		capacidadJarraA.setText(String.valueOf(c));
	}

	@Override
	public void capacidadB(int c) {
		capacidadJarraB.setText(String.valueOf(c));
	}

	@Override
	public void contenidoA(int c) {
		contenidoJarraA.setText(String.valueOf(c));
	}

	@Override
	public void contenidoB(int c) {
		contenidoJarraB.setText(String.valueOf(c));
	}

	@Override
	public void anyadirAHistorico(String mensaje) {
		historico.append(mensaje + "\n");
	}

	@Override
	public void limpiar() {
		historico.setText("");
		capacidadInicialJarraA.setText("");
		capacidadInicialJarraB.setText("");
		contenidoJarraA.setText("");
		contenidoJarraB.setText("");
		capacidadJarraA.setText("");
		capacidadJarraB.setText("");
	}
}
