
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

import prNotasInterfazMedia.*;

//--------------------------------------------------------------------------

public class JUnitTestRunnerPr41Ej2 {
	//----------------------------------------------------------------------
	//--JUnitTest-----------------------------------------------------------
	//----------------------------------------------------------------------
	public static class JUnitTestAlumnoException {
		private AlumnoException ae1;
		@BeforeClass
		public static void beforeClass() {
			// Code executed before the first test method
			System.out.println("Start of AlumnoException JUnit Test");
		}
		@AfterClass
		public static void  afterClass() {
			// Code executed after the last test method
			System.out.println("End of AlumnoException JUnit Test");
		}
		@Before
		public void setUp() {
			// Code executed before each test
			ae1 = new AlumnoException("Mensaje de Error 1");
		}
		@After
		public void tearDown() {
			// Code executed after each test
		}
		@Test(timeout = 1000)
		public void alumnoExceptionCtorTest1() {
			assertTrue("\n> Error: AlumnoException extends Exception:", ((Object)ae1 instanceof Exception));
			assertFalse("\n> Error: AlumnoException extends RuntimeException:", ((Object)ae1 instanceof RuntimeException));
			assertEquals("\n> Error: new AlumnoException(\"Mensaje de Error 1\"): getMessage():", "Mensaje de Error 1", ae1.getMessage());
		}
		@Test(timeout = 1000)
		public void alumnoExceptionCtorTest2() {
			AlumnoException ae2 = new AlumnoException();
			assertTrue("\n> Error: AlumnoException extends Exception:", ((Object)ae2 instanceof Exception));
			assertFalse("\n> Error: AlumnoException extends RuntimeException:", ((Object)ae2 instanceof RuntimeException));
			assertEquals("\n> Error: new AlumnoException(): getMessage():", null, ae2.getMessage());
		}
		@Test(timeout = 1000)
		public void alumnoExceptionToStringTest1() {
			precond("Mensaje de Error 1", ae1.getMessage());
			assertEquals("\n> Error: ae1.toString():",
						 normalize("prNotas.AlumnoException : Mensaje de Error 1"),
						 normalize(ae1.toString()));
		}
		//------------------------------------------------------------------
	}
	//----------------------------------------------------------------------
	//--JUnitTest-----------------------------------------------------------
	//----------------------------------------------------------------------
	public static class JUnitTestAlumno {
		private Alumno an1;
		@BeforeClass
		public static void beforeClass() {
			// Code executed before the first test method
			System.out.println("Start of Alumno JUnit Test");
		}
		@AfterClass
		public static void  afterClass() {
			// Code executed after the last test method
			System.out.println("End of Alumno JUnit Test");
		}
		@Before
		public void setUp() throws Exception {
			// Code executed before each test
			an1 = new Alumno("22456784F", "Gonzalez Perez, Juan", 5.5);
		}
		@After
		public void tearDown() {
			// Code executed after each test
		}
		@Test(timeout = 1000)
		public void alumnoCtorTest1() {
			assertEquals("\n> Error: new Alumno(\"22456784F\", \"Gonzalez Perez, Juan\", 5.5): DNI:", "22456784F", an1.getDni());
			assertEquals("\n> Error: new Alumno(\"22456784F\", \"Gonzalez Perez, Juan\", 5.5): Nombre:", "Gonzalez Perez, Juan", an1.getNombre());
			assertEquals("\n> Error: new Alumno(\"22456784F\", \"Gonzalez Perez, Juan\", 5.5): Calificacion:", 5.5, an1.getCalificacion(), 1e-6);
		}
		@Test(timeout = 1000)
		public void alumnoCtorTest2() throws Exception {
			Alumno an2 = new Alumno("22456784F", "Gonzalez Perez, Juan");
			assertEquals("\n> Error: new Alumno(\"22456784F\", \"Gonzalez Perez, Juan\"): DNI:", "22456784F", an2.getDni());
			assertEquals("\n> Error: new Alumno(\"22456784F\", \"Gonzalez Perez, Juan\"): Nombre:", "Gonzalez Perez, Juan", an2.getNombre());
			assertEquals("\n> Error: new Alumno(\"22456784F\", \"Gonzalez Perez, Juan\"): Calificacion:", 0.0, an2.getCalificacion(), 1e-6);
		}
		@Test(timeout = 1000)
		public void alumnoCtorTestX1() {
			try {
				Alumno an2 = new Alumno("22456784F", "Gonzalez Perez, Juan", -1.0);
				fail("\n> Error: new Alumno(\"22456784F\", \"Gonzalez Perez, Juan\", -1.0): No se lanzo ninguna excepcion");
			} catch (AlumnoException e) {
				//assertEquals("\n> Error: new Alumno(\"22456784F\", \"Gonzalez Perez, Juan\", -1.0): exception.getMessage():", "calificacion negativa", e.getMessage());
			} catch (Exception e) {
				fail("\n> Error: new Alumno(\"22456784F\", \"Gonzalez Perez, Juan\", -1.0): la excepcion lanzada no es AlumnoException");
			}
		}
		@Test(timeout = 1000)
		public void alumnoEqualsTest1() throws Exception {
			precond("22456784F", an1.getDni());
			precond("Gonzalez Perez, Juan", an1.getNombre());
			precond(5.5, an1.getCalificacion(), 1e-6);
			//------------------------
			Alumno an2 = new Alumno("22456784F", "Gonzalez Perez, Juan", 7.7);
			precond("22456784F", an2.getDni());
			precond("Gonzalez Perez, Juan", an2.getNombre());
			precond(7.7, an2.getCalificacion(), 1e-6);
			assertTrue("\n> Error: an1.equals(an2): ", an1.equals(an2));
			//------------------------
			Alumno an3 = new Alumno("22456784f", "Gonzalez Perez, Juan", 7.7);
			precond("22456784f", an3.getDni());
			precond("Gonzalez Perez, Juan", an3.getNombre());
			precond(7.7, an3.getCalificacion(), 1e-6);
			assertTrue("\n> Error: an1.equals(an3): ", an1.equals(an3));
			//------------------------
			Alumno an4 = new Alumno("22456784F", "gonzalez perez, juan", 5.5);
			precond("22456784F", an4.getDni());
			precond("gonzalez perez, juan", an4.getNombre());
			precond(5.5, an4.getCalificacion(), 1e-6);
			assertFalse("\n> Error: an1.equals(an4): ", an1.equals(an4));
			//------------------------
			Alumno an5 = new Alumno("11111111A", "Gonzalez Perez, Juan", 5.5);
			precond("11111111A", an5.getDni());
			precond("Gonzalez Perez, Juan", an5.getNombre());
			precond(5.5, an5.getCalificacion(), 1e-6);
			assertFalse("\n> Error: an1.equals(an5): ", an1.equals(an5));
			//------------------------
			assertFalse("\n> Error: an1.equals(null): ", an1.equals(null));
			assertFalse("\n> Error: an1.equals(\"Esto es un String\"): ", an1.equals("Esto es un String"));
		}
		@Test(timeout = 1000)
		public void alumnoHashCodeTest1() throws Exception {
			precond("22456784F", an1.getDni());
			precond("Gonzalez Perez, Juan", an1.getNombre());
			precond(5.5, an1.getCalificacion(), 1e-6);
			int an1HashCode = an1.hashCode();
			//------------------------
			Alumno an2 = new Alumno("22456784F", "Gonzalez Perez, Juan", 7.7);
			precond("22456784F", an2.getDni());
			precond("Gonzalez Perez, Juan", an2.getNombre());
			precond(7.7, an2.getCalificacion(), 1e-6);
			assertEquals("\n> Error: an2.hashCode(): ", an1HashCode, an2.hashCode());
			//------------------------
			Alumno an3 = new Alumno("22456784f", "Gonzalez Perez, Juan", 7.7);
			precond("22456784f", an3.getDni());
			precond("Gonzalez Perez, Juan", an3.getNombre());
			precond(7.7, an3.getCalificacion(), 1e-6);
			assertEquals("\n> Error: an3.hashCode(): ", an1HashCode, an3.hashCode());
			//------------------------
			Alumno an4 = new Alumno("22456784F", "gonzalez perez, juan", 5.5);
			precond("22456784F", an4.getDni());
			precond("gonzalez perez, juan", an4.getNombre());
			precond(5.5, an4.getCalificacion(), 1e-6);
			assertNotEquals("\n> Error: an4.hashCode(): ", an1HashCode, an4.hashCode());
			//------------------------
			Alumno an5 = new Alumno("11111111A", "Gonzalez Perez, Juan", 5.5);
			precond("11111111A", an5.getDni());
			precond("Gonzalez Perez, Juan", an5.getNombre());
			precond(5.5, an5.getCalificacion(), 1e-6);
			assertNotEquals("\n> Error: an5.hashCode(): ", an1HashCode, an5.hashCode());
		}
		@Test(timeout = 1000)
		public void alumnoToStringTest1() {
			precond("22456784F", an1.getDni());
			precond("Gonzalez Perez, Juan", an1.getNombre());
			precond(5.5, an1.getCalificacion(), 1e-6);
			assertEquals("\n> Error: an1.toString():",
						 normalize("Gonzalez Perez, Juan 22456784F"),
						 normalize(an1.toString()));
		}
		//------------------------------------------------------------------
	}
	//----------------------------------------------------------------------
	//--JUnitTest-----------------------------------------------------------
	//----------------------------------------------------------------------
	public static class JUnitTestMediaAritmetica {
		private static final Alumno[] emptyValues = new Alumno[0];
		private static final Alumno[] inputValues = crearAlumnos();
		private MediaAritmetica op1;
		private static Alumno[] crearAlumnos() {
			Alumno[] alumnos = new Alumno[0];
			try {
				alumnos = new Alumno[]{
					new Alumno("25653443S", "Garcia Gomez, Juan", 8.1),
					new Alumno("23322443K", "Lopez Turo, Manuel", 4.3),
					new Alumno("24433522M", "Merlo Martinez, Juana", 5.3),
					new Alumno("53553421D", "Santana Medina, Petra", 0.0),
					new Alumno("42424312G", "Lopez Gama, Luisa", 7.1)
				};
			} catch (Exception e) {
				fail("\n> Error: crearAlumnos: lanza excepcion no esperada");
			}
			return alumnos;
		}
		@BeforeClass
		public static void beforeClass() {
			// Code executed before the first test method
			System.out.println("Start of MediaAritmetica JUnit Test");
		}
		@AfterClass
		public static void  afterClass() {
			// Code executed after the last test method
			System.out.println("End of MediaAritmetica JUnit Test");
		}
		@Before
		public void setUp() {
			// Code executed before each test
			op1 = new MediaAritmetica();
		}
		@After
		public void tearDown() {
			// Code executed after each test
		}
		@Test(timeout = 1000)
		public void mediaAritmeticaCtorTest1() {
			assertTrue("\n> Error: MediaAritmetica implements CalculoMedia:", ((Object)op1 instanceof CalculoMedia));
		}
		@Test(timeout = 1000)
		public void mediaAritmeticaCalcularTest1() throws Exception {
			assertEquals("\n> Error: new MediaAritmetica.calcular():", 4.96, op1.calcular(inputValues), 1e-6);
		}
		@Test(timeout = 1000)
		public void mediaAritmeticaCalcularTest2() {
			try {
				double valor = op1.calcular(emptyValues);
				fail("\n> Error: op1.calcular(emptyValues): No se lanzo ninguna excepcion");
			} catch (AlumnoException e) {
				//assertEquals("\n> Error: op1.calcular(emptyValues): exception.getMessage():", "no hay alumnos", e.getMessage());
			} catch (Exception e) {
				fail("\n> Error: op1.calcular(emptyValues): la excepcion lanzada no es AlumnoException");
			}
		}
		//------------------------------------------------------------------
	}
	//----------------------------------------------------------------------
	//--JUnitTest-----------------------------------------------------------
	//----------------------------------------------------------------------
	public static class JUnitTestMediaArmonica {
		private static final Alumno[] emptyValues = new Alumno[0];
		private static final Alumno[] inputValues = crearAlumnos();
		private MediaArmonica op1;
		private static Alumno[] crearAlumnos() {
			Alumno[] alumnos = new Alumno[0];
			try {
				alumnos = new Alumno[]{
					new Alumno("25653443S", "Garcia Gomez, Juan", 8.1),
					new Alumno("23322443K", "Lopez Turo, Manuel", 4.3),
					new Alumno("24433522M", "Merlo Martinez, Juana", 5.3),
					new Alumno("53553421D", "Santana Medina, Petra", 0.0),
					new Alumno("42424312G", "Lopez Gama, Luisa", 7.1)
				};
			} catch (Exception e) {
				fail("\n> Error: crearAlumnos: lanza excepcion no esperada");
			}
			return alumnos;
		}
		@BeforeClass
		public static void beforeClass() {
			// Code executed before the first test method
			System.out.println("Start of MediaArmonica JUnit Test");
		}
		@AfterClass
		public static void  afterClass() {
			// Code executed after the last test method
			System.out.println("End of MediaArmonica JUnit Test");
		}
		@Before
		public void setUp() {
			// Code executed before each test
			op1 = new MediaArmonica();
		}
		@After
		public void tearDown() {
			// Code executed after each test
		}
		@Test(timeout = 1000)
		public void mediaArmonicaCtorTest1() {
			assertTrue("\n> Error: MediaArmonica implements CalculoMedia:", ((Object)op1 instanceof CalculoMedia));
		}
		@Test(timeout = 1000)
		public void mediaArmonicaCalcularTest1() throws Exception {
			assertEquals("\n> Error: new MediaArmonica.calcular():", 5.834823, op1.calcular(inputValues), 1e-6);
		}
		@Test(timeout = 1000)
		public void mediaArmonicaCalcularTest2() {
			try {
				double valor = op1.calcular(emptyValues);
				fail("\n> Error: op1.calcular(emptyValues): No se lanzo ninguna excepcion");
			} catch (AlumnoException e) {
				//assertEquals("\n> Error: op1.calcular(emptyValues): exception.getMessage():", "no hay alumnos", e.getMessage());
			} catch (Exception e) {
				fail("\n> Error: op1.calcular(emptyValues): la excepcion lanzada no es AlumnoException");
			}
		}
		//------------------------------------------------------------------
	}
	//----------------------------------------------------------------------
	//--JUnitTest-----------------------------------------------------------
	//----------------------------------------------------------------------
	public static class JUnitTestMediaSinExtremos {
		private static final Alumno[] emptyValues = new Alumno[0];
		private static final Alumno[] inputValues = crearAlumnos();
		private MediaSinExtremos op1;
		private static Alumno[] crearAlumnos() {
			Alumno[] alumnos = new Alumno[0];
			try {
				alumnos = new Alumno[]{
					new Alumno("25653443S", "Garcia Gomez, Juan", 8.1),
					new Alumno("23322443K", "Lopez Turo, Manuel", 4.3),
					new Alumno("24433522M", "Merlo Martinez, Juana", 5.3),
					new Alumno("53553421D", "Santana Medina, Petra", 0.0),
					new Alumno("42424312G", "Lopez Gama, Luisa", 7.1)
				};
			} catch (Exception e) {
				fail("\n> Error: crearAlumnos: lanza excepcion no esperada");
			}
			return alumnos;
		}
		@BeforeClass
		public static void beforeClass() {
			// Code executed before the first test method
			System.out.println("Start of MediaSinExtremos JUnit Test");
		}
		@AfterClass
		public static void  afterClass() {
			// Code executed after the last test method
			System.out.println("End of MediaSinExtremos JUnit Test");
		}
		@Before
		public void setUp() {
			// Code executed before each test
			op1 = new MediaSinExtremos(5.0, 9.0);
		}
		@After
		public void tearDown() {
			// Code executed after each test
		}
		@Test(timeout = 1000)
		public void mediaSinExtremosCtorTest1() {
			assertTrue("\n> Error: MediaSinExtremos implements CalculoMedia:", ((Object)op1 instanceof CalculoMedia));
		}
		@Test(timeout = 1000)
		public void mediaSinExtremosCalcularTest1() throws Exception {
			assertEquals("\n> Error: new MediaSinExtremos.calcular():", 6.833333, op1.calcular(inputValues), 1e-6);
		}
		@Test(timeout = 1000)
		public void mediaSinExtremosCalcularTest2() {
			try {
				double valor = op1.calcular(emptyValues);
				fail("\n> Error: op1.calcular(emptyValues): No se lanzo ninguna excepcion");
			} catch (AlumnoException e) {
				//assertEquals("\n> Error: op1.calcular(emptyValues): exception.getMessage():", "no hay alumnos", e.getMessage());
			} catch (Exception e) {
				fail("\n> Error: op1.calcular(emptyValues): la excepcion lanzada no es AlumnoException");
			}
		}
		//------------------------------------------------------------------
	}
	//----------------------------------------------------------------------
	//--JUnitTest-----------------------------------------------------------
	//----------------------------------------------------------------------
	public static class JUnitTestAsignatura {
		private static final String nmAsg = "Algebra";
		private static final String[] inputData = {
			"25653443S;Garcia Gomez, Juan;8.1",
			"23322443K;Lopez Turo, Manuel;4.3",
			"24433522M;Merlo Martinez, Juana;5.3",
			"53553421D;Santana Medina, Petra;-7.1",
			"55343442L,Godoy Molina, Marina;6.3",
			"34242432J;Fernandez Vara, Pedro;2.k",
			"42424312G;Lopez Gama, Luisa;7.1"
		};
		private static final Alumno[] inputValues = crearAlumnos();
		private static final String[] inputErrors = {
			"ERROR. Calificacion negativa: 53553421D;Santana Medina, Petra;-7.1",
			"ERROR. Faltan datos: 55343442L,Godoy Molina, Marina;6.3",
			"ERROR. Calificacion no numerica: 34242432J;Fernandez Vara, Pedro;2.k"
		};
		private static Alumno[] crearAlumnos() {
			Alumno[] alumnos = new Alumno[0];
			try {
				alumnos = new Alumno[]{
					new Alumno("25653443S", "Garcia Gomez, Juan", 8.1),
					new Alumno("23322443K", "Lopez Turo, Manuel", 4.3),
					new Alumno("24433522M", "Merlo Martinez, Juana", 5.3),
					new Alumno("42424312G", "Lopez Gama, Luisa", 7.1)
				};
			} catch (Exception e) {
				fail("\n> Error: crearAlumnos: lanza excepcion no esperada");
			}
			return alumnos;
		}
		private Asignatura asg1;
		@BeforeClass
		public static void beforeClass() {
			// Code executed before the first test method
			System.out.println("Start of Asignatura JUnit Test");
		}
		@AfterClass
		public static void  afterClass() {
			// Code executed after the last test method
			System.out.println("End of Asignatura JUnit Test");
		}
		@Before
		public void setUp() {
			// Code executed before each test
			asg1 = new Asignatura(nmAsg, inputData);
		}
		@After
		public void tearDown() {
			// Code executed after each test
		}
		@Test(timeout = 1000)
		public void asignaturaCtorTest1() {
			assertArrayEquals("\n> Error: new Asignatura(): asg1.getAlumnos():", inputValues, asg1.getAlumnos());
			assertArrayEqualsNorm("\n> Error: new Asignatura(): asg1.getErrores():", inputErrors, asg1.getErrores());
		}
		/*@Test(timeout = 1000)
		public void asignaturaCalcMediaTest1() throws Exception {
			assertEquals("\n> Error: asg1.getMedia():", 6.20, asg1.getMedia(), 1e-6);
		}
		@Test(timeout = 1000)
		public void asignaturaCalcMediaTest2() {
			try {
				String[] datos = { "xxx" };
				Asignatura asg2 = new Asignatura(nmAsg, datos);
				double valor = asg2.getMedia();
				fail("\n> Error: getMedia(): No se lanzo ninguna excepcion");
			} catch (AlumnoException e) {
				//assertEquals("\n> Error: getMedia(): exception.getMessage():", "No hay alumnos", e.getMessage());
			} catch (Exception e) {
				fail("\n> Error: getMedia(): la excepcion lanzada no es AlumnoException");
			}
		}*/
		@Test(timeout = 1000)
		public void asignaturaCalcMediaAritmeticaTest1() throws Exception {
			MediaAritmetica mediaAritmetica = new MediaAritmetica();
			assertEquals("\n> Error: asg1.getMedia(new MediaAritmetica()):", 6.20, asg1.getMedia(mediaAritmetica), 1e-6);
		}
		@Test(timeout = 1000)
		public void asignaturaCalcMediaAritmeticaTest2() {
			try {
				String[] datos = { "xxx" };
				Asignatura asg2 = new Asignatura(nmAsg, datos);
				MediaAritmetica mediaAritmetica = new MediaAritmetica();
				double valor = asg2.getMedia(mediaAritmetica);
				fail("\n> Error: getMedia(new MediaAritmetica()): No se lanzo ninguna excepcion");
			} catch (AlumnoException e) {
				//assertEquals("\n> Error: getMedia(new MediaAritmetica()): exception.getMessage():", "No hay alumnos", e.getMessage());
			} catch (Exception e) {
				fail("\n> Error: getMedia(new MediaAritmetica()): la excepcion lanzada no es AlumnoException");
			}
		}
		@Test(timeout = 1000)
		public void asignaturaGetCalificacionTest1() throws Exception {
			assertEquals("\n> Error: asg1.getCalificacion(Garcia Gomez, Juan):", 8.1, asg1.getCalificacion(inputValues[0]), 1e-6);
			assertEquals("\n> Error: asg1.getCalificacion(Lopez Turo, Manuel):", 4.3, asg1.getCalificacion(inputValues[1]), 1e-6);
			assertEquals("\n> Error: asg1.getCalificacion(Merlo Martinez, Juana):", 5.3, asg1.getCalificacion(inputValues[2]), 1e-6);
			assertEquals("\n> Error: asg1.getCalificacion(Lopez Gama, Luisa):", 7.1, asg1.getCalificacion(inputValues[3]), 1e-6);
		}
		@Test(timeout = 1000)
		public void asignaturaGetCalificacionTest2() {
			try {
				Alumno an2 = new Alumno("34242432J", "Fernandez Vara, Pedro");
				double valor = asg1.getCalificacion(an2);
				fail("\n> Error: asg1.getCalificacion(Fernandez Vara, Pedro): No se lanzo ninguna excepcion");
			} catch (AlumnoException e) {
				//assertEquals("\n> Error: asg1.getCalificacion(Fernandez Vara, Pedro): exception.getMessage():", "El alumno Fernandez Vara, Pedro 34242432J no se encuentra", e.getMessage());
			} catch (Exception e) {
				fail("\n> Error: asg1.getCalificacion(Fernandez Vara, Pedro): la excepcion lanzada no es AlumnoException");
			}
		}
		@Test(timeout = 1000)
		public void asignaturaToStringTest1() {
			assertEquals("\n> Error: asg1.toString():",
						 normalize("Algebra: { [Garcia Gomez, Juan 25653443S, Lopez Turo, Manuel 23322443K, Merlo Martinez, Juana 24433522M, Lopez Gama, Luisa 42424312G], [ERROR. Calificacion negativa: 53553421D;Santana Medina, Petra;-7.1, ERROR. Faltan datos: 55343442L,Godoy Molina, Marina;6.3, ERROR. Calificacion no numerica: 34242432J;Fernandez Vara, Pedro;2.k] }"),
						 normalize(asg1.toString()));
		}
		//------------------------------------------------------------------
	}
	//----------------------------------------------------------------------
	//--JUnitTestSuite------------------------------------------------------
	//----------------------------------------------------------------------
	@RunWith(Suite.class)
	@Suite.SuiteClasses({ JUnitTestAlumnoException.class ,
				JUnitTestAlumno.class ,
				JUnitTestMediaAritmetica.class ,
				JUnitTestMediaArmonica.class ,
				JUnitTestMediaSinExtremos.class ,
				JUnitTestAsignatura.class
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
}
//--------------------------------------------------------------------------
