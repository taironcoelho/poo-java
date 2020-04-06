
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

import prIndicePalabras.*;

//--------------------------------------------------------------------------

public class JUnitTestRunnerIndiceLineas {
	//----------------------------------------------------------------------
	//--JUnitTest-----------------------------------------------------------
	//----------------------------------------------------------------------
	public static class JUnitTestIndiceLineas {
		private static final String[] inputData = {
			"Guerra tenia una jarra y Parra tenia una perra, pero la perra de Parra rompio la jarra de Guerra.",
			"Guerra pego con la porra a la perra de Parra. !Oiga usted buen hombre de Parra! Por que ha pegado con la porra a la perra de Parra.",
			"Porque si la perra de Parra no hubiera roto la jarra de Guerra, Guerra no hubiera pegado con la porra a la perra de Parra."
		};
		private static final String delimiters = "[ .,:;\\-\\!\\?]+";
		private IndiceLineas cp1;
		@BeforeClass
		public static void beforeClass() {
			// Code executed before the first test method
			System.out.println("Start of IndiceLineas JUnit Test");
		}
		@AfterClass
		public static void  afterClass() {
			// Code executed after the last test method
			System.out.println("End of IndiceLineas JUnit Test");
		}
		@Before
		public void setUp() {
			// Code executed before each test
			cp1 = new IndiceLineas();
		}
		@After
		public void tearDown() {
			// Code executed after each test
		}
		@Test(timeout = 1000)
		public void indiceLineasCtorTest1() throws Exception {
			try {
				assertTrue("\n> Error: IndiceLineas implements Indice:", ((Object)cp1 instanceof Indice));
				assertTrue("\n> Error: IndiceLineas extends IndiceAbstracto:", ((Object)cp1 instanceof IndiceAbstracto));
				try (java.io.PrintWriter pw = new java.io.PrintWriter("outputData.txt")) {
					cp1.presentarIndice(pw);
				}
				assertEquals("\n> Error: presentarIndice():",
							 normalize(""),
							 normalize(loadFile("outputData.txt")));
			} finally {
				deleteFile("outputData.txt");
			}
		}
		@Test(timeout = 1000)
		public void indiceLineaspresentarIndicePWTest1() throws Exception {
			try {
				for (String x : inputData) {
					cp1.agregarFrase(x);
				}
				cp1.resolver(delimiters);
				try (java.io.PrintWriter pw = new java.io.PrintWriter("outputData.txt")) {
					cp1.presentarIndice(pw);
				}
				assertEquals("\n> Error: presentarIndice():",
							 normalize("a <2,3> buen <2> con <2,3> de <1,2,3> guerra <1,2,3> ha <2> hombre <2> hubiera <3> jarra <1,3> la <1,2,3> no <3> oiga <2> parra <1,2,3> pegado <2,3> pego <2> pero <1> perra <1,2,3> por <2> porque <3> porra <2,3> que <2> rompio <1> roto <3> si <3> tenia <1> una <1> usted <2> y <1>"),
							 normalize(loadFile("outputData.txt")));
			} finally {
				deleteFile("outputData.txt");
			}
		}
		@Test(timeout = 1000)
		public void indiceLineaspresentarIndiceCsTest1() {
			for (String x : inputData) {
				cp1.agregarFrase(x);
			}
			cp1.resolver(delimiters);
			SysOutCapture sysOutCapture = new SysOutCapture();
			String sysOutString = "";
			try {
				sysOutCapture.sysOutCapture();
				cp1.presentarIndiceConsola();
			} finally {
				sysOutString = sysOutCapture.sysOutRelease();
			}
			assertEquals("\n> Error: presentarIndiceConsola():",
						 normalize("a <2,3> buen <2> con <2,3> de <1,2,3> guerra <1,2,3> ha <2> hombre <2> hubiera <3> jarra <1,3> la <1,2,3> no <3> oiga <2> parra <1,2,3> pegado <2,3> pego <2> pero <1> perra <1,2,3> por <2> porque <3> porra <2,3> que <2> rompio <1> roto <3> si <3> tenia <1> una <1> usted <2> y <1>"),
						 normalize(sysOutString));
		}
		//------------------------------------------------------------------
	}
	//----------------------------------------------------------------------
	//--JUnitTestSuite------------------------------------------------------
	//----------------------------------------------------------------------
	@RunWith(Suite.class)
	@Suite.SuiteClasses({ JUnitTestIndiceLineas.class
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
	private static void precondNorm(String expectedValue, String currValue) {
		precond(normalize(expectedValue), normalize(currValue));
	}
	private static void assertEqualsNorm(String msg, String expectedValue, String currValue) {
		assertEquals(msg, normalize(expectedValue), normalize(currValue));
	}
	private static void assertArrayEqualsNorm(String msg, String[] expectedValue, String[] currValue) {
		assertEquals(msg, expectedValue.length, currValue.length);
		for (int i = 0; i < expectedValue.length; ++i) {
			assertEquals(msg, normalize(expectedValue[i]), normalize(currValue[i]));
		}
	}
	//----------------------------------------------------------------------
	private static void deleteFile(String filename) {
		new java.io.File(filename).delete();
	}
	private static void createFile(String filename, String inputData) throws Exception {
		try (java.io.PrintWriter pw = new java.io.PrintWriter(filename)) {
			pw.println(inputData);
		}
	}
	private static void createFile(String filename, String[] inputData) throws Exception {
		try (java.io.PrintWriter pw = new java.io.PrintWriter(filename)) {
			for (String linea : inputData) {
				pw.println(linea);
			}
		}
	}
	private static String loadFile(String filename) throws Exception {
		java.util.StringJoiner sj = new java.util.StringJoiner("\n");
		try (java.util.Scanner sc = new java.util.Scanner(new java.io.File(filename))) {
			while (sc.hasNextLine()) {
				sj.add(sc.nextLine());
			}
		}
		return sj.toString();
	}
	//----------------------------------------------------------------------
	//----------------------------------------------------------------------
	private static class SysOutCapture {
		//--------------------------------
		private static final java.io.PrintWriter sysoutpw = new java.io.PrintWriter(System.out, true);
		private static final java.io.PrintStream sysout = System.out;
		//--------------------------------
		private java.io.PrintStream sysoutOld;
		private java.io.PrintStream sysoutstr;
		private java.io.ByteArrayOutputStream baos;
		private int estado;
		//--------------------------------
		public SysOutCapture() {
			sysoutstr = null ;
			baos = null;
			sysoutOld = null ;
			estado = 0;
		}
		//--------------------------------
		public void sysOutCapture() throws RuntimeException {
			if (estado != 0) {
				throw new RuntimeException("sysOutCapture:BadState");
			} else {
				estado = 1;
				try {
					sysoutOld = System.out;
					baos = new java.io.ByteArrayOutputStream();
					sysoutstr = new java.io.PrintStream(baos);
					System.setOut(sysoutstr);
				} catch (Throwable e) {
					throw new RuntimeException("sysOutCapture:InternalError");
				}
			}
		}
		//--------------------------------
		public String sysOutRelease() throws RuntimeException {
			String result = null;
			if (estado != 1) {
				throw new RuntimeException("sysOutRelease:BadState");
			} else {
				estado = 0;
				try {
					if (sysoutstr != null) {
						sysoutstr.flush();
					}
					if (baos != null) {
						baos.flush();
						result = new String(baos.toByteArray(),
											//java.nio.charset.StandardCharsets.UTF_8);
											java.nio.charset.StandardCharsets.ISO_8859_1);
					}
				} catch (Throwable e) {
					throw new RuntimeException("sysOutRelease:InternalError1");
				} finally {
					try {
						System.setOut(sysoutOld);
						if (sysoutstr != null) {
							sysoutstr.close();
							sysoutstr = null;
						}
						if (baos != null) {
							baos.close();
							baos = null;
						}
					} catch (Throwable e) {
						throw new RuntimeException("sysOutRelease:InternalError2");
					}
				}
			}
			return result;
		}
		//--------------------------------
	}
	//----------------------------------------------------------------------
}
//--------------------------------------------------------------------------
