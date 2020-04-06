package prJarrasGUI;

import java.awt.event.ActionListener;

public interface VistaJarras {
	public static final String INICIAR = "INICIAR";
	public static final String LLENAR_A = "LLENAR_A";
	public static final String LLENAR_B = "LLENAR_B";
	public static final String VACIAR_A = "VACIAR_A";
	public static final String VACIAR_B = "VACIAR_B";
	public static final String VOLCAR_A_EN_B = "VOLCAR_A_EN_B";
	public static final String VOLCAR_B_EN_A = "VOLCAR_B_EN_A";
	public static final String FINALIZAR = "FINALIZAR";

	/**
	 * Pasamos el controlador.
	 * 
	 * @param ctr
	 *            controlador
	 */
	public void controlador(ActionListener ctr);

	/**
	 * Obtenemos la capacidad inicial de la jarra A.
	 * 
	 * @return int con la capacidad inicial de la jarra A.
	 */
	public int capacidadInicialA();

	/**
	 * Obtenemos la capacidad inicial de la jarra B
	 * 
	 * @return int con la capacidad inicial de la jarra B.
	 */
	public int capacidadInicialB();

	/**
	 * 4 Mostramos un mensaje de error.
	 * 
	 * @param mensaje
	 *            String con el mensaje a mostrar.
	 */
	public void error(String mensaje);

	/**
	 * Mostramos un mensaje de información.
	 * 
	 * @param mensaje
	 *            String con el mensaje a mostrar.
	 */
	public void ok(String mensaje);

	/**
	 * Habilitamos o deshabilitamos el modo inicialización de jarras o trasvases
	 * 
	 * @param b
	 *            true para habilitar el modo inicialización; false para el modo
	 *            trasvases
	 */
	public void habilitarInicio(boolean b);

	/**
	 * Establecemos la capacidad de la jarra A.
	 * 
	 * @param c
	 *            int con la capacidad de la jarra A
	 */
	public void capacidadA(int c);

	/**
	 * Establecemos la capacidad de la jarra B.
	 * 
	 * @param c
	 *            int con la capacidad de la jarra B.
	 */
	public void capacidadB(int c);

	/**
	 * Establecemos el contenido de la jarra A.
	 * 
	 * @param c
	 *            int con el contenido de la jarra A.
	 */
	public void contenidoA(int c);

	/**
	 * Establecemos el contenido de la jarra B.
	 * 
	 * @param c
	 *            int con el contenido de la jarra B.
	 */
	public void contenidoB(int c);

	/**
	 * Añadimos un mensaje al histórico.
	 * 
	 * @param mensaje
	 *            String con el mensaje a añadir.
	 */
	public void anyadirAHistorico(String mensaje);

	/**
	 * Limpiamos el histórico.
	 */
	public void limpiar();
}