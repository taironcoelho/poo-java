package ajedrez;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PanelTorneo extends JPanel implements VistaTorneo {
	private JTextField jtfFicheroEntrada;
	private JTextField jtfFicheroSalida;
	private JButton jbLee;
	private JButton jbRonda;
	private JButton jbGuarda;
	private JTextArea jtaTexto;
	private JLabel jlMensaje;
	
	public PanelTorneo() {
		setLayout(new BorderLayout());
		jtfFicheroEntrada = new JTextField(20);
		jtfFicheroEntrada.setBorder(BorderFactory.createTitledBorder("Nombre Fichero Entrada"));
		jtfFicheroSalida = new JTextField(20);
		jtfFicheroSalida.setBorder(BorderFactory.createTitledBorder("Nombre Fichero Salida"));
		JPanel panelNorte = new JPanel();
		panelNorte.setLayout(new FlowLayout());
		panelNorte.add(jtfFicheroEntrada);
		panelNorte.add(jtfFicheroSalida);
		add(panelNorte, BorderLayout.NORTH);

		jbLee = new JButton("Lee");
		jbRonda = new JButton("Ronda");
		jbGuarda = new JButton("Guarda");
		JPanel jpDerecho = new JPanel();
		jpDerecho.setLayout(new BoxLayout(jpDerecho, BoxLayout.Y_AXIS));
		jpDerecho.add(jbLee);
		jpDerecho.add(jbRonda);
		jpDerecho.add(jbGuarda);
		add(jpDerecho, BorderLayout.EAST);
		
		jtaTexto = new JTextArea(30,70);
		add(new JScrollPane(jtaTexto), BorderLayout.CENTER);
		
		jlMensaje = new JLabel(" ");
		add(jlMensaje, BorderLayout.SOUTH);
	}
	
	
	@Override
	public String getFicheroEntrada() {
		return jtfFicheroEntrada.getText();
	}

	@Override
	public String getFicheroSalida() {
		return jtfFicheroSalida.getText();
	}

	
	@Override
	public void agregaLinea(String linea) {
		jtaTexto.append(linea+"\n");
	}
	
	@Override
	public void limpiaPantalla() {
		jtaTexto.setText("");
	}

	@Override
	public void setMensaje(String msg) {
		jlMensaje.setText(msg);
	}
	
	public void controlador(ActionListener ctr) {
		jbLee.setActionCommand(VistaTorneo.LEE);
		jbLee.addActionListener(ctr);
		jbGuarda.setActionCommand(VistaTorneo.GUARDA);
		jbGuarda.addActionListener(ctr);
		jbRonda.setActionCommand(VistaTorneo.RONDA);
		jbRonda.addActionListener(ctr);
	}
}
