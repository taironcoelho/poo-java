import prNotas.Alumno;
import prNotas.AlumnoException;
import prNotas.Asignatura;

public class PruebaAsignatura {
	public static void main(String[] args) {
		try {
			String[] alumnos = {"12455666F;Lopez Perez, Pedro;6.7",
								"33678999D;Merlo Gomez, Isabel;5.8",
								"23555875G;Martinez Herrera, Lucia;9.1"};
			
			Asignatura asg = new Asignatura("algebra", alumnos);
			System.out.println("Media de las calificaciones: " + asg.getMedia());
			for(Alumno aln: asg.getAlumnos()) {
				System.out.println(aln.toString());
			}
			
		} catch(AlumnoException e) {
			System.out.println(e.getMessage());
		}
	}
}
