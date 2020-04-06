package prJarrasGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorJarra implements ActionListener{
	private VistaJarras vista;
	private Jarra jarraA;
	private Jarra jarraB;

	public ControladorJarra(VistaJarras v) {
		vista = v;
		vista.habilitarInicio(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String c = e.getActionCommand();
			switch (c) {
				case VistaJarras.INICIAR:
					iniciar();
				break;
				case VistaJarras.LLENAR_A:
					llenarA();
				break;
				case VistaJarras.LLENAR_B:
					llenarB();
				break;
				case VistaJarras.VACIAR_A:
					vaciarA();
				break;
				case VistaJarras.VACIAR_B:
					vaciarB();
				break;
				case VistaJarras.VOLCAR_A_EN_B:
					volcarAenB();
				break;
				case VistaJarras.VOLCAR_B_EN_A:
					volcarBenA();
				break;
				case VistaJarras.FINALIZAR:
					finalizar();
				break;
			}
		} catch (NumberFormatException ex) {
			vista.error("Capacidad errónea");
		} catch (Exception ex) {
			vista.error(ex.getMessage());
		}	
	}
	
	private void iniciar() {
		int capA = vista.capacidadInicialA();
		int capB = vista.capacidadInicialB();

		jarraA = new Jarra(capA);	
		jarraB = new Jarra(capB);		
		vista.ok("Jarras creadas con éxito");
		vista.limpiar();
		vista.habilitarInicio(false);
		vista.anyadirAHistorico("Crear JarraA("+capA+")");
		vista.anyadirAHistorico("Crear JarraB("+capB+")");
		actualizarEstado();	
	}
	
	private void llenarA() {
		jarraA.llena();
		vista.ok("Llenamos la jarra A");
		vista.anyadirAHistorico("Llenamos la jarra A");
		actualizarEstado();
	}
	
	private void llenarB() {
		jarraB.llena();
		vista.ok("Llenamos la jarra B");
		vista.anyadirAHistorico("Llenamos la jarra B");
		vista.contenidoB(jarraB.contenido());
	}
	
	private void vaciarA() {
		jarraA.vacia();
		vista.ok("Vaciamos la jarra A");
		vista.anyadirAHistorico("Vaciamos la jarra A");
		actualizarEstado();
	}
	
	private void vaciarB() {
		jarraB.vacia();
		vista.ok("Vaciamos la jarra B");
		vista.anyadirAHistorico("Vaciamos la jarra B");
		actualizarEstado();
	}
	
	private void volcarAenB() {
		jarraB.llenaDesde(jarraA);
		vista.ok("Volcamos el contenido de la jarra A en la jarra B");
		vista.anyadirAHistorico("Volcamos el contenido de la jarra A en la jarra B");
		actualizarEstado();
	}
	
	private void volcarBenA() {
		jarraA.llenaDesde(jarraB);
		vista.ok("Volcamos el contenido de la jarra B en la jarra A");
		vista.anyadirAHistorico("Volcamos el contenido de la jarra B en la jarra A");
		actualizarEstado();
	}
	
	private void finalizar() {
		vista.ok("Fin de transferencias");
		vista.habilitarInicio(true);
		vista.limpiar();
	}
	
	private void actualizarEstado() {
		vista.contenidoA(jarraA.contenido());
		vista.contenidoB(jarraB.contenido());
		vista.capacidadA(jarraA.capacidad());
		vista.capacidadB(jarraB.capacidad());
	}
}
