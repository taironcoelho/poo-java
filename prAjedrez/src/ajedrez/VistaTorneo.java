package ajedrez;

import java.awt.event.ActionListener;

public interface VistaTorneo {

	String LEE    = "L"; 	// Comando de Leer
	String RONDA = "R"; 	// Comando de pasar a la siguiente ronda
	String GUARDA = "G";	// Comando de Guardar
	
	/**
	 * Fichero de entrada
	 * @return el nombre del fichero de entrada
	 */
	String getFicheroEntrada();

	/**
	 * Fichero de Salida
	 * @return el nombre del fichero de salida
	 */
	String getFicheroSalida();

	/**
	 * Agrega Linea
	 * @param linea  La linea a agregar. 
	 * Agrega automaticamente un salto de linea.
	 */
	void agregaLinea(String linea);

	/**
	 * Vacia el area de texto
	 */
	void limpiaPantalla();

	/**
	 * Escribe un mensaje en la parte inferior de la pantalla
	 * @param msg
	 */
	void setMensaje(String msg);

	/**
	 * Resgistra un controlador en los botones
	 * @param ctr el controlador a registrar
	 */
	void controlador(ActionListener ctr);
}