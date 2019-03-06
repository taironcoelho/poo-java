
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

import prJarras.Jarra;
import prJarras.Mesa;

//--------------------------------------------------------------------------

public class JUnitTestRunnerMesa {
	//----------------------------------------------------------------------
	//--JUnitTest-----------------------------------------------------------
	//----------------------------------------------------------------------
	public static class JUnitTestJarra {
		private Jarra j5;
		@BeforeClass
		public static void beforeClass() {
			// Code executed before the first test method
			System.out.println("Start of Jarra JUnit Test");
		}
		@AfterClass
		public static void  afterClass() {
			// Code executed after the last test method
			System.out.println("End of Jarra JUnit Test");
		}
		@Before
		public void setUp() {
			// Code executed before each test
			j5 = new Jarra(5);
		}
		@After
		public void tearDown() {
			// Code executed after each test
		}
		@Test(timeout = 1000)
		public void jarraCtorTest1() {
			assertEquals("\n> Error: new Jarra(5): Capacidad:", 5, j5.capacidad());
			assertEquals("\n> Error: new Jarra(5): Contenido:", 0, j5.contenido());
		}
		@Test(timeout = 1000)
		public void jarraLlenaTest1() {
			if ((j5.capacidad() == 5)&&(j5.contenido() == 0)) {
				j5.llena();
				assertEquals("\n> Error: j50.llena(): Capacidad:", 5, j5.capacidad());
				assertEquals("\n> Error: j50.llena(): Contenido:", 5, j5.contenido());
			} else {
				fail("\n> Aviso: No se pudo realizar el test debido a errores en otros métodos");
			}
		}
		@Test(timeout = 1000)
		public void jarraVaciaTest1() {
			j5.llena();
			if ((j5.capacidad() == 5)&&(j5.contenido() == 5)) {
				j5.vacia();
				assertEquals("\n> Error: j55.vacia(): Capacidad:", 5, j5.capacidad());
				assertEquals("\n> Error: j55.vacia(): Contenido:", 0, j5.contenido());
			} else {
				fail("\n> Aviso: No se pudo realizar el test debido a errores en otros métodos");
			}
		}
		@Test(timeout = 1000)
		public void jarraLlenaDesdeTest1() {
			Jarra j2 = new Jarra(2);
			j2.llena();
			if ((j5.capacidad() == 5)&&(j5.contenido() == 0)
				&&(j2.capacidad() == 2)&&(j2.contenido() == 2)) {
				j5.llenaDesde(j2);
				assertEquals("\n> Error: j50.llenaDesde(j22): j5.Capacidad:", 5, j5.capacidad());
				assertEquals("\n> Error: j50.llenaDesde(j22): j5.Contenido:", 2, j5.contenido());
				assertEquals("\n> Error: j50.llenaDesde(j22): j2.Capacidad:", 2, j2.capacidad());
				assertEquals("\n> Error: j50.llenaDesde(j22): j2.Contenido:", 0, j2.contenido());
			} else {
				fail("\n> Aviso: No se pudo realizar el test debido a errores en otros métodos");
			}
		}
		@Test(timeout = 1000)
		public void jarraLlenaDesdeTest2() {
			Jarra j2 = new Jarra(2);
			j5.llena();
			if ((j5.capacidad() == 5)&&(j5.contenido() == 5)
				&&(j2.capacidad() == 2)&&(j2.contenido() == 0)) {
				j2.llenaDesde(j5);
				assertEquals("\n> Error: j20.llenaDesde(j55): j5.Capacidad:", 5, j5.capacidad());
				assertEquals("\n> Error: j20.llenaDesde(j55): j5.Contenido:", 3, j5.contenido());
				assertEquals("\n> Error: j20.llenaDesde(j55): j2.Capacidad:", 2, j2.capacidad());
				assertEquals("\n> Error: j20.llenaDesde(j55): j2.Contenido:", 2, j2.contenido());
			} else {
				fail("\n> Aviso: No se pudo realizar el test debido a errores en otros métodos");
			}
		}
		@Test(timeout = 1000)
		public void jarraLlenaDesdeTest3() {
			Jarra j2 = new Jarra(2);
			j2.llena();
			if ((j5.capacidad() == 5)&&(j5.contenido() == 0)
				&&(j2.capacidad() == 2)&&(j2.contenido() == 2)) {
				j5.llenaDesde(j2);
				assertEquals("\n> Error: j50.llenaDesde(j22): j5.Capacidad:", 5, j5.capacidad());
				assertEquals("\n> Error: j50.llenaDesde(j22): j5.Contenido:", 2, j5.contenido());
				assertEquals("\n> Error: j50.llenaDesde(j22): j2.Capacidad:", 2, j2.capacidad());
				assertEquals("\n> Error: j50.llenaDesde(j22): j2.Contenido:", 0, j2.contenido());
				j2.llena();
				if ((j5.capacidad() == 5)&&(j5.contenido() == 2)
					&&(j2.capacidad() == 2)&&(j2.contenido() == 2)) {
					j5.llenaDesde(j2);
					assertEquals("\n> Error: j52.llenaDesde(j22): j5.Capacidad:", 5, j5.capacidad());
					assertEquals("\n> Error: j52.llenaDesde(j22): j5.Contenido:", 4, j5.contenido());
					assertEquals("\n> Error: j52.llenaDesde(j22): j2.Capacidad:", 2, j2.capacidad());
					assertEquals("\n> Error: j52.llenaDesde(j22): j2.Contenido:", 0, j2.contenido());
					j2.llena();
					if ((j5.capacidad() == 5)&&(j5.contenido() == 4)
						&&(j2.capacidad() == 2)&&(j2.contenido() == 2)) {
						j5.llenaDesde(j2);
						assertEquals("\n> Error: j54.llenaDesde(j22): j5.Capacidad:", 5, j5.capacidad());
						assertEquals("\n> Error: j54.llenaDesde(j22): j5.Contenido:", 5, j5.contenido());
						assertEquals("\n> Error: j54.llenaDesde(j22): j2.Capacidad:", 2, j2.capacidad());
						assertEquals("\n> Error: j54.llenaDesde(j22): j2.Contenido:", 1, j2.contenido());
					} else {
						fail("\n> Aviso: No se pudo realizar el test debido a errores en otros métodos");
					}
				} else {
					fail("\n> Aviso: No se pudo realizar el test debido a errores en otros métodos");
				}
			} else {
				fail("\n> Aviso: No se pudo realizar el test debido a errores en otros métodos");
			}
		}
		@Test(timeout = 1000)
		public void jarraToStringTest1() {
			if ((j5.capacidad() == 5)&&(j5.contenido() == 0)) {
				assertEquals("\n> Error: j50.toString():",
							 normalize("J(5,0)"),
							 normalize(j5.toString()));
			} else {
				fail("\n> Aviso: No se pudo realizar el test debido a errores en otros métodos");
			}
		}
		@Test(timeout = 1000)
		public void jarraToStringTest2() {
			j5.llena();
			if ((j5.capacidad() == 5)&&(j5.contenido() == 5)) {
				assertEquals("\n> Error: new j55.toString():",
							 normalize("J(5,5)"),
							 normalize(j5.toString()));
			} else {
				fail("\n> Aviso: No se pudo realizar el test debido a errores en otros métodos");
			}
		}
		//------------------------------------------------------------------
	}
	//----------------------------------------------------------------------
	//--JUnitTest-----------------------------------------------------------
	//----------------------------------------------------------------------
	public static class JUnitTestMesa {
		private Mesa m1;
		@BeforeClass
		public static void beforeClass() {
			// Code executed before the first test method
			System.out.println("Start of Mesa JUnit Test");
		}
		@AfterClass
		public static void  afterClass() {
			// Code executed after the last test method
			System.out.println("End of Mesa JUnit Test");
		}
		@Before
		public void setUp() {
			// Code executed before each test
			m1 = new Mesa(5, 2);
		}
		@After
		public void tearDown() {
			// Code executed after each test
		}
		@Test(timeout = 1000)
		public void mesaCtorTest1() {
			assertEquals("\n> Error: new Mesa(5,2): Capacidad-J1:", 5, m1.capacidad(1));
			assertEquals("\n> Error: new Mesa(5,2): Contenido-J1:", 0, m1.contenido(1));
			assertEquals("\n> Error: new Mesa(5,2): Capacidad-J2:", 2, m1.capacidad(2));
			assertEquals("\n> Error: new Mesa(5,2): Contenido-J2:", 0, m1.contenido(2));
		}
		@Test(timeout = 1000)
		public void mesaCtorTest2() {
			Jarra j5 = new Jarra(5);
			Jarra j2 = new Jarra(2);
			if ((j5.capacidad() == 5)&&(j5.contenido() == 0)
				&&(j2.capacidad() == 2)&&(j2.contenido() == 0)) {
				Mesa m2 = new Mesa(j5, j2);
				assertEquals("\n> Error: new Mesa(j5,j2): Capacidad-J1:", 5, m2.capacidad(1));
				assertEquals("\n> Error: new Mesa(j5,j2): Contenido-J1:", 0, m2.contenido(1));
				assertEquals("\n> Error: new Mesa(j5,j2): Capacidad-J2:", 2, m2.capacidad(2));
				assertEquals("\n> Error: new Mesa(j5,j2): Contenido-J2:", 0, m2.contenido(2));
			} else {
				fail("\n> Aviso: No se pudo realizar el test debido a errores en otros métodos");
			}
		}
		@Test(timeout = 1000)
		public void mesaCtorTest3() {
			Jarra j5 = new Jarra(5);
			Jarra j2 = new Jarra(2);
			Mesa m2 = new Mesa(j5, j2);
			j5.llena();
			j2.llena();
			if ((j5.capacidad() == 5)&&(j5.contenido() == 5)
				&&(j2.capacidad() == 2)&&(j2.contenido() == 2)) {
				assertEquals("\n> Error: new Mesa(j5,j2): Capacidad-J1:", 5, m2.capacidad(1));
				assertEquals("\n> Error: new Mesa(j5,j2): Contenido-J1:", 5, m2.contenido(1));
				assertEquals("\n> Error: new Mesa(j5,j2): Capacidad-J2:", 2, m2.capacidad(2));
				assertEquals("\n> Error: new Mesa(j5,j2): Contenido-J2:", 2, m2.contenido(2));
			} else {
				fail("\n> Aviso: No se pudo realizar el test debido a errores en otros métodos");
			}
		}
		@Test(timeout = 1000)
		public void mesaLlenaTest1() {
			if ((m1.capacidad(1) == 5)&&(m1.contenido(1) == 0)
				&&(m1.capacidad(2) == 2)&&(m1.contenido(2) == 0)) {
				m1.llena(1);
				assertEquals("\n> Error: m5020.llena(1): Capacidad-J1:", 5, m1.capacidad(1));
				assertEquals("\n> Error: m5020.llena(1): Contenido-J1:", 5, m1.contenido(1));
				assertEquals("\n> Error: m5020.llena(1): Capacidad-J2:", 2, m1.capacidad(2));
				assertEquals("\n> Error: m5020.llena(1): Contenido-J2:", 0, m1.contenido(2));
			} else {
				fail("\n> Aviso: No se pudo realizar el test debido a errores en otros métodos");
			}
		}
		@Test(timeout = 1000)
		public void mesaLlenaTest2() {
			if ((m1.capacidad(1) == 5)&&(m1.contenido(1) == 0)
				&&(m1.capacidad(2) == 2)&&(m1.contenido(2) == 0)) {
				m1.llena(2);
				assertEquals("\n> Error: m5020.llena(2): Capacidad-J1:", 5, m1.capacidad(1));
				assertEquals("\n> Error: m5020.llena(2): Contenido-J1:", 0, m1.contenido(1));
				assertEquals("\n> Error: m5020.llena(2): Capacidad-J2:", 2, m1.capacidad(2));
				assertEquals("\n> Error: m5020.llena(2): Contenido-J2:", 2, m1.contenido(2));
			} else {
				fail("\n> Aviso: No se pudo realizar el test debido a errores en otros métodos");
			}
		}
		@Test(timeout = 1000)
		public void mesaVaciaTest1() {
			m1.llena(1);
			m1.llena(2);
			if ((m1.capacidad(1) == 5)&&(m1.contenido(1) == 5)
				&&(m1.capacidad(2) == 2)&&(m1.contenido(2) == 2)) {
				m1.vacia(1);
				assertEquals("\n> Error: m5522.vacia(1): Capacidad-J1:", 5, m1.capacidad(1));
				assertEquals("\n> Error: m5522.vacia(1): Contenido-J1:", 0, m1.contenido(1));
				assertEquals("\n> Error: m5522.vacia(1): Capacidad-J2:", 2, m1.capacidad(2));
				assertEquals("\n> Error: m5522.vacia(1): Contenido-J2:", 2, m1.contenido(2));
			} else {
				fail("\n> Aviso: No se pudo realizar el test debido a errores en otros métodos");
			}
		}
		@Test(timeout = 1000)
		public void mesaVaciaTest2() {
			m1.llena(1);
			m1.llena(2);
			if ((m1.capacidad(1) == 5)&&(m1.contenido(1) == 5)
				&&(m1.capacidad(2) == 2)&&(m1.contenido(2) == 2)) {
				m1.vacia(2);
				assertEquals("\n> Error: m5522.vacia(2): Capacidad-J1:", 5, m1.capacidad(1));
				assertEquals("\n> Error: m5522.vacia(2): Contenido-J1:", 5, m1.contenido(1));
				assertEquals("\n> Error: m5522.vacia(2): Capacidad-J2:", 2, m1.capacidad(2));
				assertEquals("\n> Error: m5522.vacia(2): Contenido-J2:", 0, m1.contenido(2));
			} else {
				fail("\n> Aviso: No se pudo realizar el test debido a errores en otros métodos");
			}
		}
		@Test(timeout = 1000)
		public void mesaLlenaDesdeTest1() {
			m1.llena(2);
			if ((m1.capacidad(1) == 5)&&(m1.contenido(1) == 0)
				&&(m1.capacidad(2) == 2)&&(m1.contenido(2) == 2)) {
				m1.llenaDesde(2);
				assertEquals("\n> Error: m5022.llenaDesde(2): Capacidad-J1:", 5, m1.capacidad(1));
				assertEquals("\n> Error: m5022.llenaDesde(2): Contenido-J1:", 2, m1.contenido(1));
				assertEquals("\n> Error: m5022.llenaDesde(2): Capacidad-J2:", 2, m1.capacidad(2));
				assertEquals("\n> Error: m5022.llenaDesde(2): Contenido-J2:", 0, m1.contenido(2));
			} else {
				fail("\n> Aviso: No se pudo realizar el test debido a errores en otros métodos");
			}
		}
		@Test(timeout = 1000)
		public void mesaLlenaDesdeTest2() {
			m1.llena(1);
			if ((m1.capacidad(1) == 5)&&(m1.contenido(1) == 5)
				&&(m1.capacidad(2) == 2)&&(m1.contenido(2) == 0)) {
				m1.llenaDesde(1);
				assertEquals("\n> Error: m5520.llenaDesde(1): Capacidad-J1:", 5, m1.capacidad(1));
				assertEquals("\n> Error: m5520.llenaDesde(1): Contenido-J1:", 3, m1.contenido(1));
				assertEquals("\n> Error: m5520.llenaDesde(1): Capacidad-J2:", 2, m1.capacidad(2));
				assertEquals("\n> Error: m5520.llenaDesde(1): Contenido-J2:", 2, m1.contenido(2));
			} else {
				fail("\n> Aviso: No se pudo realizar el test debido a errores en otros métodos");
			}
		}
		@Test(timeout = 1000)
		public void mesaLlenaDesdeTest3() {
			m1.llena(2);
			if ((m1.capacidad(1) == 5)&&(m1.contenido(1) == 0)
				&&(m1.capacidad(2) == 2)&&(m1.contenido(2) == 2)) {
				m1.llenaDesde(2);
				assertEquals("\n> Error: m5022.llenaDesde(2): Capacidad-J1:", 5, m1.capacidad(1));
				assertEquals("\n> Error: m5022.llenaDesde(2): Contenido-J1:", 2, m1.contenido(1));
				assertEquals("\n> Error: m5022.llenaDesde(2): Capacidad-J2:", 2, m1.capacidad(2));
				assertEquals("\n> Error: m5022.llenaDesde(2): Contenido-J2:", 0, m1.contenido(2));
				m1.llena(2);
				if ((m1.capacidad(1) == 5)&&(m1.contenido(1) == 2)
					&&(m1.capacidad(2) == 2)&&(m1.contenido(2) == 2)) {
					m1.llenaDesde(2);
					assertEquals("\n> Error: m5222.llenaDesde(2): Capacidad-J1:", 5, m1.capacidad(1));
					assertEquals("\n> Error: m5222.llenaDesde(2): Contenido-J1:", 4, m1.contenido(1));
					assertEquals("\n> Error: m5222.llenaDesde(2): Capacidad-J2:", 2, m1.capacidad(2));
					assertEquals("\n> Error: m5222.llenaDesde(2): Contenido-J2:", 0, m1.contenido(2));
					m1.llena(2);
					if ((m1.capacidad(1) == 5)&&(m1.contenido(1) == 4)
						&&(m1.capacidad(2) == 2)&&(m1.contenido(2) == 2)) {
						m1.llenaDesde(2);
						assertEquals("\n> Error: m5422.llenaDesde(2): Capacidad-J1:", 5, m1.capacidad(1));
						assertEquals("\n> Error: m5422.llenaDesde(2): Contenido-J1:", 5, m1.contenido(1));
						assertEquals("\n> Error: m5422.llenaDesde(2): Capacidad-J2:", 2, m1.capacidad(2));
						assertEquals("\n> Error: m5422.llenaDesde(2): Contenido-J2:", 1, m1.contenido(2));
					} else {
						fail("\n> Aviso: No se pudo realizar el test debido a errores en otros métodos");
					}
				} else {
					fail("\n> Aviso: No se pudo realizar el test debido a errores en otros métodos");
				}
			} else {
				fail("\n> Aviso: No se pudo realizar el test debido a errores en otros métodos");
			}
		}
		@Test(timeout = 1000)
		public void mesaToStringTest1() {
			if ((m1.capacidad(1) == 5)&&(m1.contenido(1) == 0)
				&&(m1.capacidad(2) == 2)&&(m1.contenido(2) == 0)) {
				assertEquals("\n> Error: m5020.toString():",
							 normalize("M(J(5,0),J(2,0))"),
							 normalize(m1.toString()));
			} else {
				fail("\n> Aviso: No se pudo realizar el test debido a errores en otros métodos");
			}
		}
		@Test(timeout = 1000)
		public void mesaToStringTest2() {
			m1.llena(1);
			m1.llena(2);
			if ((m1.capacidad(1) == 5)&&(m1.contenido(1) == 5)
				&&(m1.capacidad(2) == 2)&&(m1.contenido(2) == 2)) {
				assertEquals("\n> Error: m5522.toString():",
							 normalize("M(J(5,5),J(2,2))"),
							 normalize(m1.toString()));
			} else {
				fail("\n> Aviso: No se pudo realizar el test debido a errores en otros métodos");
			}
		}
		//------------------------------------------------------------------
	}
	//----------------------------------------------------------------------
	//--JUnitTestSuite------------------------------------------------------
	//----------------------------------------------------------------------
	@RunWith(Suite.class)
	@Suite.SuiteClasses({ JUnitTestJarra.class ,
				JUnitTestMesa.class
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
		case '\u00C0': // À
		case '\u00C1': // Á
		case '\u00C2': // Â
		case '\u00C3': // Ã
		case '\u00C4': // Ä
		case '\u00C5': // Å
		case '\u00C6': // Æ
			ch = 'A';
			break;
		case '\u00C7': // Ç
			ch = 'C';
			break;
		case '\u00C8': // È
		case '\u00C9': // É
		case '\u00CA': // Ê
		case '\u00CB': // Ë
			ch = 'E';
			break;
		case '\u00CC': // Ì
		case '\u00CD': // Í
		case '\u00CE': // Î
		case '\u00CF': // Ï
			ch = 'I';
			break;
		case '\u00D0': // Ð
			ch = 'D';
			break;
		case '\u00D1': // Ñ
			ch = 'N';
			break;
		case '\u00D2': // Ò
		case '\u00D3': // Ó
		case '\u00D4': // Ô
		case '\u00D5': // Õ
		case '\u00D6': // Ö
			ch = 'O';
			break;
		case '\u00D9': // Ù
		case '\u00DA': // Ú
		case '\u00DB': // Û
		case '\u00DC': // Ü
			ch = 'U';
			break;
		case '\u00DD': // Ý
			ch = 'Y';
			break;
		case '\u00E0': // à
		case '\u00E1': // á
		case '\u00E2': // â
		case '\u00E3': // ã
		case '\u00E4': // ä
		case '\u00E5': // å
		case '\u00E6': // æ
			ch = 'a';
			break;
		case '\u00E7': // ç
			ch = 'c';
			break;
		case '\u00E8': // è
		case '\u00E9': // é
		case '\u00EA': // ê
		case '\u00EB': // ë
			ch = 'e';
			break;
		case '\u00EC': // ì
		case '\u00ED': // í
		case '\u00EE': // î
		case '\u00EF': // ï
			ch = 'i';
			break;
		case '\u00F0': // ð
			ch = 'd';
			break;
		case '\u00F1': // ñ
			ch = 'n';
			break;
		case '\u00F2': // ò
		case '\u00F3': // ó
		case '\u00F4': // ô
		case '\u00F5': // õ
		case '\u00F6': // ö
			ch = 'o';
			break;
		case '\u00F9': // ù
		case '\u00FA': // ú
		case '\u00FB': // û
		case '\u00FC': // ü
			ch = 'u';
			break;
		case '\u00FD': // ý
		case '\u00FF': // ÿ
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
}
//--------------------------------------------------------------------------
