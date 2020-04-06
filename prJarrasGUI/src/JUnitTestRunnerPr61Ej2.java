
//--------------------------------------------------------------------------
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
//--------------------------------------------------------------------------

import prJarrasGUI.*;

//--------------------------------------------------------------------------
public class JUnitTestRunnerPr61Ej2 {
	//----------------------------------------------------------------------
	//-- VistaControlador --------------------------------------------------
	//----------------------------------------------------------------------
	public static class VistaControlador implements VistaJarras {
		private boolean vistaHabilitarInicio;
		private String userInputCapacidadJarraA;
		private String userInputCapacidadJarraB;
		private String vistaOutputCapacidadJarraA;
		private String vistaOutputCapacidadJarraB;
		private String vistaOutputContenidoJarraA;
		private String vistaOutputContenidoJarraB;
		private String vistaOutputMensaje;
		private String vistaOutputHistorico;
		private ControladorJarra ctrl;
		private java.awt.event.ActionEvent iniciarEvent;
		private java.awt.event.ActionEvent llenarAEvent;
		private java.awt.event.ActionEvent llenarBEvent;
		private java.awt.event.ActionEvent vaciarAEvent;
		private java.awt.event.ActionEvent vaciarBEvent;
		private java.awt.event.ActionEvent transfABEvent;
		private java.awt.event.ActionEvent transfBAEvent;
		private java.awt.event.ActionEvent finalizarEvent;
		public VistaControlador() {
			vistaHabilitarInicio = false;
			userInputCapacidadJarraA = "";
			userInputCapacidadJarraB = "";
			vistaOutputCapacidadJarraA = "";
			vistaOutputCapacidadJarraB = "";
			vistaOutputContenidoJarraA = "";
			vistaOutputContenidoJarraB = "";
			vistaOutputMensaje = "";
			vistaOutputHistorico = "";
		    iniciarEvent = new java.awt.event.ActionEvent(this, java.awt.event.ActionEvent.ACTION_FIRST+1, VistaJarras.INICIAR);
		    llenarAEvent = new java.awt.event.ActionEvent(this, java.awt.event.ActionEvent.ACTION_FIRST+2, VistaJarras.LLENAR_A);
		    llenarBEvent = new java.awt.event.ActionEvent(this, java.awt.event.ActionEvent.ACTION_FIRST+3, VistaJarras.LLENAR_B);
		    vaciarAEvent = new java.awt.event.ActionEvent(this, java.awt.event.ActionEvent.ACTION_FIRST+4, VistaJarras.VACIAR_A);
		    vaciarBEvent = new java.awt.event.ActionEvent(this, java.awt.event.ActionEvent.ACTION_FIRST+5, VistaJarras.VACIAR_B);
		    transfABEvent = new java.awt.event.ActionEvent(this, java.awt.event.ActionEvent.ACTION_FIRST+6, VistaJarras.VOLCAR_A_EN_B);
		    transfBAEvent = new java.awt.event.ActionEvent(this, java.awt.event.ActionEvent.ACTION_FIRST+7, VistaJarras.VOLCAR_B_EN_A);
		    finalizarEvent = new java.awt.event.ActionEvent(this, java.awt.event.ActionEvent.ACTION_FIRST+8, VistaJarras.FINALIZAR);
		    ctrl = new ControladorJarra(this);
		}
		@Override public void controlador(java.awt.event.ActionListener c) { /*empty*/ }
		@Override public int capacidadInicialA() { return Integer.parseInt(userInputCapacidadJarraA); }
		@Override public int capacidadInicialB() { return Integer.parseInt(userInputCapacidadJarraB); }
		@Override public void error(String x) { vistaOutputMensaje = "E["+x+"]"; }
		@Override public void ok(String x) { vistaOutputMensaje = "O["+x+"]"; }
		@Override public void habilitarInicio(boolean x) { vistaHabilitarInicio = x; }
		@Override public void capacidadA(int x) { vistaOutputCapacidadJarraA = Integer.toString(x); }
		@Override public void capacidadB(int x) { vistaOutputCapacidadJarraB = Integer.toString(x); }
		@Override public void contenidoA(int x) { vistaOutputContenidoJarraA = Integer.toString(x); }
		@Override public void contenidoB(int x) { vistaOutputContenidoJarraB = Integer.toString(x); }
		@Override public void anyadirAHistorico(String x) { vistaOutputHistorico += " H["+x+"]"; }
		@Override public void limpiar() { vistaOutputHistorico += " L[limpiar]"; }
		//----------------------------
		public void setUserInputCapacidadJarraA(String x) { userInputCapacidadJarraA = x; }
		public void setUserInputCapacidadJarraB(String x) { userInputCapacidadJarraB = x; }
		public boolean getVistaHabilitarInicio() { return vistaHabilitarInicio; }
		public String getVistaOutputCapacidadJarraA() { return vistaOutputCapacidadJarraA; }
		public String getVistaOutputCapacidadJarraB() { return vistaOutputCapacidadJarraB; }
		public String getVistaOutputContenidoJarraA() { return vistaOutputContenidoJarraA; }
		public String getVistaOutputContenidoJarraB() { return vistaOutputContenidoJarraB; }
		public String getVistaOutputMensaje() { return vistaOutputMensaje; }
		public String getVistaOutputHistorico() { return vistaOutputHistorico; }
		//----------------------------
		public void pulsaIniciar() { ctrl.actionPerformed(iniciarEvent); }
		public void pulsaLlenarA() { ctrl.actionPerformed(llenarAEvent); }
		public void pulsaLlenarB() { ctrl.actionPerformed(llenarBEvent); }
		public void pulsaVaciarA() { ctrl.actionPerformed(vaciarAEvent); }
		public void pulsaVaciarB() { ctrl.actionPerformed(vaciarBEvent); }
		public void pulsaTransfAB() { ctrl.actionPerformed(transfABEvent); }
		public void pulsaTransfBA() { ctrl.actionPerformed(transfBAEvent); }
		public void pulsaFinalizar() { ctrl.actionPerformed(finalizarEvent); }
	}
	//----------------------------------------------------------------------
	//--JUnitTest-----------------------------------------------------------
	//----------------------------------------------------------------------
	public static class JUnitTestVistaControlador {
		private VistaControlador vc1;
		@BeforeClass
		public static void beforeClass() {
			// Code executed before the first test method
			System.out.println("Start of VistaControlador JUnit Test");
		}
		@AfterClass
		public static void  afterClass() {
			// Code executed after the last test method
			System.out.println("End of VistaControlador JUnit Test");
		}
		@Before
		public void setUp() {
			// Code executed before each test
			vc1 = new VistaControlador();
		}
		@After
		public void tearDown() {
			// Code executed after each test
		}
		private void assertEstado(String msg, String cpa, String cpb, String cta, String ctb, String m, String h) {
			assertEquals("\n> Error: "+msg+":HabilitarInicio():", false, vc1.getVistaHabilitarInicio());
			assertEquals("\n> Error: "+msg+":CapacidadJarraA", cpa, vc1.getVistaOutputCapacidadJarraA());
			assertEquals("\n> Error: "+msg+":CapacidadJarraB", cpb, vc1.getVistaOutputCapacidadJarraB());
			assertEquals("\n> Error: "+msg+":ContenidoJarraA", cta, vc1.getVistaOutputContenidoJarraA());
			assertEquals("\n> Error: "+msg+":ContenidoJarraB", ctb, vc1.getVistaOutputContenidoJarraB());
			assertEquals("\n> Error: "+msg+":Mensaje", normalize(m), normalize(vc1.getVistaOutputMensaje()));
			assertEquals("\n> Error: "+msg+":Historico", normalize(h), normalize(vc1.getVistaOutputHistorico()));
		}
		@Test(timeout = 1000)
		public void vistaControladorCtorTest1() {
			assertEquals("\n> Error: ControladorJarras(): habilitarInicio():", true, vc1.getVistaHabilitarInicio());
		}
		@Test(timeout = 1000)
		public void vistaControladorIniciarTest1() {
			assertEquals("\n> Error: ControladorJarras(): habilitarInicio():", true, vc1.getVistaHabilitarInicio());
			vc1.setUserInputCapacidadJarraA("7");
			vc1.setUserInputCapacidadJarraB("4");
			vc1.pulsaIniciar();
			assertEstado("Iniciar", "7", "4", "0", "0",
						 "O[Jarras creadas con exito]",
						 "L[limpiar] H[Crear JarraA(7)] H[Crear JarraB(4)]");
		}
		@Test(timeout = 1000)
		public void vistaControladorIniciarTest2() {
			assertEquals("\n> Error: ControladorJarras(): habilitarInicio():", true, vc1.getVistaHabilitarInicio());
			vc1.setUserInputCapacidadJarraA("-7");
			vc1.setUserInputCapacidadJarraB("4");
			vc1.pulsaIniciar();
			assertEquals("\n> Error: ControladorJarras(): habilitarInicio():", true, vc1.getVistaHabilitarInicio());
			assertEquals("\n> Error: Iniciar:Mensaje",
						 normalize("E[Capacidad negativa]"),
						 normalize(vc1.getVistaOutputMensaje()));
		}
		@Test(timeout = 1000)
		public void vistaControladorIniciarTest3() {
			assertEquals("\n> Error: ControladorJarras(): habilitarInicio():", true, vc1.getVistaHabilitarInicio());
			vc1.setUserInputCapacidadJarraA("7");
			vc1.setUserInputCapacidadJarraB("-4");
			vc1.pulsaIniciar();
			assertEquals("\n> Error: ControladorJarras(): habilitarInicio():", true, vc1.getVistaHabilitarInicio());
			assertEquals("\n> Error: Iniciar:Mensaje",
						 normalize("E[Capacidad negativa]"),
						 normalize(vc1.getVistaOutputMensaje()));
		}
		@Test(timeout = 1000)
		public void vistaControladorIniciarTest4() {
			assertEquals("\n> Error: ControladorJarras(): habilitarInicio():", true, vc1.getVistaHabilitarInicio());
			vc1.setUserInputCapacidadJarraA("xxx");
			vc1.setUserInputCapacidadJarraB("4");
			vc1.pulsaIniciar();
			assertEquals("\n> Error: ControladorJarras(): habilitarInicio():", true, vc1.getVistaHabilitarInicio());
			assertEquals("\n> Error: Iniciar:Mensaje",
						 normalize("E[Capacidad erronea]"),
						 normalize(vc1.getVistaOutputMensaje()));
		}
		@Test(timeout = 1000)
		public void vistaControladorIniciarTest5() {
			assertEquals("\n> Error: ControladorJarras(): habilitarInicio():", true, vc1.getVistaHabilitarInicio());
			vc1.setUserInputCapacidadJarraA("7");
			vc1.setUserInputCapacidadJarraB("xxx");
			vc1.pulsaIniciar();
			assertEquals("\n> Error: ControladorJarras(): habilitarInicio():", true, vc1.getVistaHabilitarInicio());
			assertEquals("\n> Error: Iniciar:Mensaje",
						 normalize("E[Capacidad erronea]"),
						 normalize(vc1.getVistaOutputMensaje()));
		}
		@Test(timeout = 1000)
		public void vistaControladorLlenarATest1() {
			assertEquals("\n> Error: ControladorJarras(): habilitarInicio():", true, vc1.getVistaHabilitarInicio());
			vc1.setUserInputCapacidadJarraA("7");
			vc1.setUserInputCapacidadJarraB("4");
			vc1.pulsaIniciar();
			assertEstado("Iniciar", "7", "4", "0", "0",
						 "O[Jarras creadas con exito]",
						 "L[limpiar] H[Crear JarraA(7)] H[Crear JarraB(4)]");
			vc1.pulsaLlenarA();
			assertEstado("llenarJarraA", "7", "4", "7", "0",
						 "O[Llenamos la jarra A]",
						 "L[limpiar] H[Crear JarraA(7)] H[Crear JarraB(4)] H[Llenamos la jarra A]");
		}
		@Test(timeout = 1000)
		public void vistaControladorLlenarBTest1() {
			assertEquals("\n> Error: ControladorJarras(): habilitarInicio():", true, vc1.getVistaHabilitarInicio());
			vc1.setUserInputCapacidadJarraA("7");
			vc1.setUserInputCapacidadJarraB("4");
			vc1.pulsaIniciar();
			assertEstado("Iniciar", "7", "4", "0", "0",
						 "O[Jarras creadas con exito]",
						 "L[limpiar] H[Crear JarraA(7)] H[Crear JarraB(4)]");
			vc1.pulsaLlenarB();
			assertEstado("llenarJarraB", "7", "4", "0", "4",
						 "O[Llenamos la jarra B]",
						 "L[limpiar] H[Crear JarraA(7)] H[Crear JarraB(4)] H[Llenamos la jarra B]");
		}
		@Test(timeout = 1000)
		public void vistaControladorLlenarAVaciarATest1() {
			assertEquals("\n> Error: ControladorJarras(): habilitarInicio():", true, vc1.getVistaHabilitarInicio());
			vc1.setUserInputCapacidadJarraA("7");
			vc1.setUserInputCapacidadJarraB("4");
			vc1.pulsaIniciar();
			assertEstado("Iniciar", "7", "4", "0", "0",
						 "O[Jarras creadas con exito]",
						 "L[limpiar] H[Crear JarraA(7)] H[Crear JarraB(4)]");
			vc1.pulsaLlenarA();
			assertEstado("llenarJarraA", "7", "4", "7", "0",
						 "O[Llenamos la jarra A]",
						 "L[limpiar] H[Crear JarraA(7)] H[Crear JarraB(4)] H[Llenamos la jarra A]");
			vc1.pulsaVaciarA();
			assertEstado("vaciarJarraA", "7", "4", "0", "0",
						 "O[Vaciamos la jarra A]",
						 "L[limpiar] H[Crear JarraA(7)] H[Crear JarraB(4)] H[Llenamos la jarra A] H[Vaciamos la jarra A]");
		}
		@Test(timeout = 1000)
		public void vistaControladorLlenarBVaciarBTest1() {
			assertEquals("\n> Error: ControladorJarras(): habilitarInicio():", true, vc1.getVistaHabilitarInicio());
			vc1.setUserInputCapacidadJarraA("7");
			vc1.setUserInputCapacidadJarraB("4");
			vc1.pulsaIniciar();
			assertEstado("Iniciar", "7", "4", "0", "0",
						 "O[Jarras creadas con exito]",
						 "L[limpiar] H[Crear JarraA(7)] H[Crear JarraB(4)]");
			vc1.pulsaLlenarB();
			assertEstado("llenarJarraB", "7", "4", "0", "4",
						 "O[Llenamos la jarra B]",
						 "L[limpiar] H[Crear JarraA(7)] H[Crear JarraB(4)] H[Llenamos la jarra B]");
			vc1.pulsaVaciarB();
			assertEstado("vaciarJarraB", "7", "4", "0", "0",
						 "O[Vaciamos la jarra B]",
						 "L[limpiar] H[Crear JarraA(7)] H[Crear JarraB(4)] H[Llenamos la jarra B] H[Vaciamos la jarra B]");
		}
		@Test(timeout = 1000)
		public void vistaControladorLlenarATransferirBTest1() {
			assertEquals("\n> Error: ControladorJarras(): habilitarInicio():", true, vc1.getVistaHabilitarInicio());
			vc1.setUserInputCapacidadJarraA("7");
			vc1.setUserInputCapacidadJarraB("4");
			vc1.pulsaIniciar();
			assertEstado("Iniciar", "7", "4", "0", "0",
						 "O[Jarras creadas con exito]",
						 "L[limpiar] H[Crear JarraA(7)] H[Crear JarraB(4)]");
			vc1.pulsaLlenarA();
			assertEstado("llenarJarraA", "7", "4", "7", "0",
						 "O[Llenamos la jarra A]",
						 "L[limpiar] H[Crear JarraA(7)] H[Crear JarraB(4)] H[Llenamos la jarra A]");
			vc1.pulsaTransfAB();
			assertEstado("pulsaTransfAB", "7", "4", "3", "4",
						 "O[Volcamos el contenido de la jarra A en la jarra B]",
						 "L[limpiar] H[Crear JarraA(7)] H[Crear JarraB(4)] H[Llenamos la jarra A] H[Volcamos el contenido de la jarra A en la jarra B]");
		}
		@Test(timeout = 1000)
		public void vistaControladorLlenarBTransferirATest1() {
			assertEquals("\n> Error: ControladorJarras(): habilitarInicio():", true, vc1.getVistaHabilitarInicio());
			vc1.setUserInputCapacidadJarraA("7");
			vc1.setUserInputCapacidadJarraB("4");
			vc1.pulsaIniciar();
			assertEstado("Iniciar", "7", "4", "0", "0",
						 "O[Jarras creadas con exito]",
						 "L[limpiar] H[Crear JarraA(7)] H[Crear JarraB(4)]");
			vc1.pulsaLlenarB();
			assertEstado("llenarJarraB", "7", "4", "0", "4",
						 "O[Llenamos la jarra B]",
						 "L[limpiar] H[Crear JarraA(7)] H[Crear JarraB(4)] H[Llenamos la jarra B]");
			vc1.pulsaTransfBA();
			assertEstado("pulsaTransfBA", "7", "4", "4", "0",
						 "O[Volcamos el contenido de la jarra B en la jarra A]",
						 "L[limpiar] H[Crear JarraA(7)] H[Crear JarraB(4)] H[Llenamos la jarra B] H[Volcamos el contenido de la jarra B en la jarra A]");
		}
		@Test(timeout = 1000)
		public void vistaControladorFinalizarTest1() {
			assertEquals("\n> Error: ControladorJarras(): habilitarInicio():", true, vc1.getVistaHabilitarInicio());
			vc1.setUserInputCapacidadJarraA("7");
			vc1.setUserInputCapacidadJarraB("4");
			vc1.pulsaIniciar();
			assertEstado("Iniciar", "7", "4", "0", "0",
						 "O[Jarras creadas con exito]",
						 "L[limpiar] H[Crear JarraA(7)] H[Crear JarraB(4)]");
			vc1.pulsaFinalizar();
			assertEquals("\n> Error: Finalizar: habilitarInicio():", true, vc1.getVistaHabilitarInicio());
			assertEquals("\n> Error: Finalizar:Mensaje",
						 normalize("O[Fin de transferencias]"),
						 normalize(vc1.getVistaOutputMensaje()));
		}
		//------------------------------------------------------------------
	}
	//----------------------------------------------------------------------
	//--JUnitTestSuite------------------------------------------------------
	//----------------------------------------------------------------------
	@RunWith(Suite.class)
	@Suite.SuiteClasses({ JUnitTestVistaControlador.class 
				})
				public static class JUnitTestSuite { /*empty*/ }
	//----------------------------------------------------------------------
	//--JUnitTestRunner-----------------------------------------------------
	//----------------------------------------------------------------------
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(JUnitTestSuite.class);
		
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		if (result.wasSuccessful()) {
			System.out.println("JUnit Test Succeeded");
		} else {
			System.out.println("> Error: JUnit Test Failed");
		}
	}
	//----------------------------------------------------------------------
	//-- Utils -------------------------------------------------------------
	//----------------------------------------------------------------------
	private static char normalizeUnicode(char ch) {
		switch (ch) {
		case '\n':
		case '\r':
		case '\t':
		case '\f':
			ch = ' ';
			break;
		case '\u00C0':
		case '\u00C1':
		case '\u00C2':
		case '\u00C3':
		case '\u00C4':
		case '\u00C5':
		case '\u00C6':
			ch = 'A';
			break;
		case '\u00C7':
			ch = 'C';
			break;
		case '\u00C8':
		case '\u00C9':
		case '\u00CA':
		case '\u00CB':
			ch = 'E';
			break;
		case '\u00CC':
		case '\u00CD':
		case '\u00CE':
		case '\u00CF':
			ch = 'I';
			break;
		case '\u00D0':
			ch = 'D';
			break;
		case '\u00D1':
			ch = 'N';
			break;
		case '\u00D2':
		case '\u00D3':
		case '\u00D4':
		case '\u00D5':
		case '\u00D6':
			ch = 'O';
			break;
		case '\u00D9':
		case '\u00DA':
		case '\u00DB':
		case '\u00DC':
			ch = 'U';
			break;
		case '\u00DD':
			ch = 'Y';
			break;
		case '\u00E0':
		case '\u00E1':
		case '\u00E2':
		case '\u00E3':
		case '\u00E4':
		case '\u00E5':
		case '\u00E6':
			ch = 'a';
			break;
		case '\u00E7':
			ch = 'c';
			break;
		case '\u00E8':
		case '\u00E9':
		case '\u00EA':
		case '\u00EB':
			ch = 'e';
			break;
		case '\u00EC':
		case '\u00ED':
		case '\u00EE':
		case '\u00EF':
			ch = 'i';
			break;
		case '\u00F0':
			ch = 'd';
			break;
		case '\u00F1':
			ch = 'n';
			break;
		case '\u00F2':
		case '\u00F3':
		case '\u00F4':
		case '\u00F5':
		case '\u00F6':
			ch = 'o';
			break;
		case '\u00F9':
		case '\u00FA':
		case '\u00FB':
		case '\u00FC':
			ch = 'u';
			break;
		case '\u00FD':
		case '\u00FF':
			ch = 'y';
			break;
		}
		return ch;
	}
	//----------------------------------------------------------------------
	private static String normalize(String s1) {
		int sz = s1 == null ? 16 : s1.length() == 0 ? 16 : 2*s1.length();
		StringBuilder sb = new StringBuilder(sz);
		sb.append(' ');
		if (s1 != null) {
			for (int i = 0; i < s1.length(); ++i) {
				char ch = normalizeUnicode(s1.charAt(i));
				char sbLastChar = sb.charAt(sb.length()-1);
				if (Character.isLetter(ch)) {
					if ( ! Character.isLetter(sbLastChar)) {
						if ( ! Character.isSpaceChar(sbLastChar)) {
							sb.append(' ');
						}
					}
					sb.append(ch);
				} else if (Character.isDigit(ch)) {
					if ((i >= 2)
						&& (s1.charAt(i-1) == '.')
						&& Character.isDigit(s1.charAt(i-2))) {
						sb.setLength(sb.length()-2); // "9 ."
						sb.append('.');
					} else if ((i >= 2)
							   && ((s1.charAt(i-1) == 'e')||(s1.charAt(i-1) == 'E'))
							   && Character.isDigit(s1.charAt(i-2))) {
						sb.setLength(sb.length()-2); // "9 e"
						sb.append('e');
					} else if ((i >= 3)
							   && (s1.charAt(i-1) == '+')
							   && ((s1.charAt(i-2) == 'e')||(s1.charAt(i-2) == 'E'))
							   && Character.isDigit(s1.charAt(i-3))) {
						sb.setLength(sb.length()-4); // "9 e +"
						sb.append('e');
					} else if ((i >= 3)
							   && (s1.charAt(i-1) == '-')
							   && ((s1.charAt(i-2) == 'e')||(s1.charAt(i-2) == 'E'))
							   && Character.isDigit(s1.charAt(i-3))) {
						sb.setLength(sb.length()-4); // "9 e -"
						sb.append("e-");
					} else if ( (sbLastChar != '-') && ! Character.isDigit(sbLastChar)) {
						if ( ! Character.isSpaceChar(sbLastChar)) {
							sb.append(' ');
						}
					}
					sb.append(ch);
				} else if (Character.isSpaceChar(ch)) {
					if ( ! Character.isSpaceChar(sbLastChar)) {
						sb.append(' ');
					}
				} else {
					if ( ! Character.isSpaceChar(sbLastChar)) {
						sb.append(' ');
					}
					sb.append(ch);
				}
			}
		}
		if (Character.isSpaceChar(sb.charAt(sb.length()-1))) {
			sb.setLength(sb.length()-1);
		}
		if ((sb.length() > 0) && Character.isSpaceChar(sb.charAt(0))) {
			sb.deleteCharAt(0);
		}
		return sb.toString();
	}
	//----------------------------------------------------------------------
	private static final String precondMessage = "\n> Aviso: No se pudo realizar el test debido a errores en otros metodos";
	//----------------------------------------------------------------------
	private static void precond(boolean expectedValue, boolean currValue) {
		if (expectedValue != currValue) {
			fail(precondMessage);
		}
	}
	private static void precond(char expectedValue, char currValue) {
		if (expectedValue != currValue) {
			fail(precondMessage);
		}
	}
	private static void precond(short expectedValue, short currValue) {
		if (expectedValue != currValue) {
			fail(precondMessage);
		}
	}
	private static void precond(int expectedValue, int currValue) {
		if (expectedValue != currValue) {
			fail(precondMessage);
		}
	}
	private static void precond(long expectedValue, long currValue) {
		if (expectedValue != currValue) {
			fail(precondMessage);
		}
	}
	private static void precond(float expectedValue, float currValue, float delta) {
		if (Math.abs(expectedValue - currValue) > delta) {
			fail(precondMessage);
		}
	}
	private static void precond(double expectedValue, double currValue, double delta) {
		if (Math.abs(expectedValue - currValue) > delta) {
			fail(precondMessage);
		}
	}
	private static void precond(Object expectedValue, Object currValue) {
		if ((expectedValue == null)||(currValue == null)) {
			if (expectedValue != currValue) {
				fail(precondMessage);
			}
		} else if ( ! expectedValue.equals(currValue)) {
			fail(precondMessage);
		}
	}
	//----------------------------------------------------------------------
	private static void assertEqualsNorm(String msg, String expectedValue, String currValue) {
		assertEquals(msg, normalize(expectedValue), normalize(currValue));
	}
	//----------------------------------------------------------------------
}
//--------------------------------------------------------------------------
