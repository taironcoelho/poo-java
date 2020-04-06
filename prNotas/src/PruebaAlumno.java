import prNotas.*;

public class PruebaAlumno {
	public static void main(String[] args) {
		try {
			Alumno al1 = new Alumno("Gonzalez Perez, Juan", "22456784F", 5.5);
			Alumno al2 = new Alumno("Gonzalez Perez, Juan", "33456777S", 3.4);
			Alumno al3 = new Alumno("Ana Rosa", "22B", 7.8);
			
			System.out.println("Alumno: " + al1.toString() + " Nota: " + al1.getCalificacion());
			System.out.println("Alumno: " + al2.toString() + " Nota: " + al2.getCalificacion());
		} catch(AlumnoException e) {
			System.out.println(e.getMessage());
		}
	}
}
