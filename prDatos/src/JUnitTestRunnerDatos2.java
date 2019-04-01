
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

import prDatos.*;

//--------------------------------------------------------------------------

public class JUnitTestRunnerDatos2 {
	//----------------------------------------------------------------------
	//--JUnitTest-----------------------------------------------------------
	//----------------------------------------------------------------------
	public static class JUnitTestDatos {
		private static final String[] inputData = {
			"5.5", "9.5", "Pepe", "10.5", "Maria", "12.5", "13.5",
			"Paco", "17.5", "20.5", "Ana", "25.5", "Juan", "Lola"
		};
		private static final double[] inputValues = { 5.5, 9.5, 10.5, 12.5, 13.5, 17.5, 20.5, 25.5 };
		private static final String[] inputErrors = { "Pepe", "Maria", "Paco", "Ana", "Juan", "Lola" };
		private Datos dt1;
		@BeforeClass
		public static void beforeClass() {
			// Code executed before the first test method
			System.out.println("Start of Datos JUnit Test");
		}
		@AfterClass
		public static void  afterClass() {
			// Code executed after the last test method
			System.out.println("End of Datos JUnit Test");
		}
		@Before
		public void setUp() {
			// Code executed before each test
			dt1 = new Datos(inputData, 10.0, 20.0);
		}
		@After
		public void tearDown() {
			// Code executed after each test
		}
		@Test(timeout = 1000)
		public void datosCtorTest1() {
			assertArrayEquals("\n> Error: new Datos(): dt1.getDatos():", inputValues, dt1.getDatos(), 1e-6);
			assertArrayEquals("\n> Error: new Datos(): dt1.getErrores():", inputErrors, dt1.getErrores());
		}
		@Test(timeout = 1000)
		public void datosCalcMediaTest1() throws Exception {
			assertEquals("\n> Error: Min: 10 ; Max: 20 ; dt1.calcMedia():", 13.5, dt1.calcMedia(), 1e-6);
		}
		@Test(timeout = 1000)
		public void datosCalcMediaTest2() {
			try {
				Datos dt2 = new Datos(inputData, 0.0, 4.0);
				double valor = dt2.calcMedia();
				fail("\n> Error: Min: 0 ; Max: 4 ; calcMedia(): No se lanzo ninguna excepcion");
			} catch (DatosException e) {
				//assertEquals("\n> Error: Min: 0 ; Max: 4 ; calcMedia(): exception.getMessage():", "No hay datos", e.getMessage());
			} catch (Exception e) {
				fail("\n> Error: Min: 0 ; Max: 4 ; calcMedia(): la excepcion lanzada no es DatosException");
			}
		}
		@Test(timeout = 1000)
		public void datosCalcDesvTipicaTest1() throws Exception {
			assertEquals("\n> Error: Min: 10 ; Max: 20 ; dt1.calcDesvTipica():", 2.54951, dt1.calcDesvTipica(), 1e-6);
		}
		@Test(timeout = 1000)
		public void datosCalcDesvTipicaTest2() {
			try {
				Datos dt2 = new Datos(inputData, 0.0, 4.0);
				double valor = dt2.calcDesvTipica();
				fail("\n> Error: Min: 0 ; Max: 4 ; calcDesvTipica(): No se lanzo ninguna excepcion");
			} catch (DatosException e) {
				//assertEquals("\n> Error: Min: 0 ; Max: 4 ; calcDesvTipica(): exception.getMessage():", "No hay datos", e.getMessage());
			} catch (Exception e) {
				fail("\n> Error: Min: 0 ; Max: 4 ; calcDesvTipica(): la excepcion lanzada no es DatosException");
			}
		}
		@Test(timeout = 1000)
		public void datosSetRangoTest1() throws Exception {
			dt1.setRango(" 5.7 ; 13.7 ");
			assertEquals("\n> Error: Min: 5.7 ; Max: 13.7 ; dt1.calcMedia():", 11.5, dt1.calcMedia(), 1e-6);
		}
		@Test(timeout = 1000)
		public void datosSetRangoTest2() {
			try {
				dt1.setRango(" 10 ");
				fail("\n> Error: dt1.setRango(\" 10 \"): No se lanzo ninguna excepcion");
			} catch (DatosException e) {
				//assertEquals("\n> Error: dt1.setRango(\" 10 \"): exception.getMessage():", "No hay datos", e.getMessage());
			} catch (Exception e) {
				fail("\n> Error: dt1.setRango(\" 10 \"): la excepcion lanzada no es DatosException");
			}
		}
		@Test(timeout = 1000)
		public void datosSetRangoTest3() {
			try {
				dt1.setRango(" 10 ; xxx ");
				fail("\n> Error: dt1.setRango(\" 10 ; xxx \"): No se lanzo ninguna excepcion");
			} catch (DatosException e) {
				//assertEquals("\n> Error: dt1.setRango(\" 10 ; xxx \"): exception.getMessage():", "No hay datos", e.getMessage());
			} catch (Exception e) {
				fail("\n> Error: dt1.setRango(\" 10 ; xxx \"): la excepcion lanzada no es DatosException");
			}
		}
		@Test(timeout = 1000)
		public void datosSetRangoTest4() {
			try {
				dt1.setRango(" xxx ; 10 ");
				fail("\n> Error: dt1.setRango(\" xxx ; 10 \"): No se lanzo ninguna excepcion");
			} catch (DatosException e) {
				//assertEquals("\n> Error: dt1.setRango(\" xxx ; 10 \"): exception.getMessage():", "No hay datos", e.getMessage());
			} catch (Exception e) {
				fail("\n> Error: dt1.setRango(\" xxx ; 10 \"): la excepcion lanzada no es DatosException");
			}
		}
		@Test(timeout = 1000)
		public void datosToStringTest1() {
			assertEquals("\n> Error: dt1.toString():",
						 normalize("Min: 10.0, Max: 20.0, [ 5.5, 9.5, 10.5, 12.5, 13.5, 17.5, 20.5, 25.5 ], [ Pepe, Maria, Paco, Ana, Juan, Lola ], Media: 13.5, DesvTipica: 2.5495097567963922"),
						 normalize(dt1.toString()));
		}
		@Test(timeout = 1000)
		public void datosToStringTest2() {
			Datos dt2 = new Datos(inputData, 0.0, 4.0);
			//------------------------
			assertEquals("\n> Error: dt2.toString():",
						 normalize("Min: 0.0, Max: 4.0, [ 5.5, 9.5, 10.5, 12.5, 13.5, 17.5, 20.5, 25.5 ], [ Pepe, Maria, Paco, Ana, Juan, Lola ], Media: ERROR, DesvTipica: ERROR"),
						 normalize(dt2.toString()));
		}
		//------------------------------------------------------------------
	}
	//----------------------------------------------------------------------
	//--JUnitTestSuite------------------------------------------------------
	//----------------------------------------------------------------------
	@RunWith(Suite.class)
	@Suite.SuiteClasses({ JUnitTestDatos.class
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
}
//--------------------------------------------------------------------------
