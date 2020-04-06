package prNotas;

import java.util.Scanner;

import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Asignatura {
	private String nombre;
	private String[] errores;
	private Alumno[] alumnos;
	
	public Asignatura(String n, String[] datos) {
		procesarDatos(datos);
		nombre = n;
	}
	
	private void procesarDatos(String[] datos) {
		int na = 0;
		int ne = 0;
		alumnos = new Alumno[datos.length];
		errores = new String[datos.length];
		
		for(String d : datos) {
			try (Scanner sc1 = new Scanner(d)) {
				sc1.useDelimiter("\\s*[;]\\s*");
				sc1.useLocale(Locale.ENGLISH);
					try {
						alumnos[na] = new Alumno(sc1.next(),
								sc1.next(), sc1.nextDouble());
						na++;
					} catch (InputMismatchException e) {
						errores[ne] = "ERROR. Calificación no numérica: " + d;
						ne++;
					} catch(NoSuchElementException e) {
						errores[ne] = "ERROR. Faltan datos: " + d;
						ne++;
					} catch (AlumnoException e) {
						errores[ne] = "ERROR. Calificación negativa: " + d;
						ne++;
					}
			} 
		}
		errores = Arrays.copyOf(errores, ne);
		alumnos = Arrays.copyOf(alumnos, na);

	}
	
	public double getCalificacion(Alumno al) throws AlumnoException{
		int pos = buscarAlumno(al);
		if(pos<0) {
			throw new AlumnoException("Alumno no existe");
		}
		return alumnos[pos].getCalificacion();
	}
	
	private int buscarAlumno(Alumno aln) {
		int i = 0;
		while ((i < alumnos.length) && !alumnos[i].equals(aln)) {
			++i;
		}
		if (i == alumnos.length) {
			i = -1;
		}
		return i;
	}
	
	public Alumno[] getAlumnos() {
		return alumnos;
	}
	
	public String[] getErrores() {
		return errores;
	}
	
	public double getMedia() throws AlumnoException {
		if(alumnos.length<1) {
			throw new AlumnoException("No hay alumnos registrados");
		}
		
		double media = 0;
		for(Alumno a: alumnos) {
			media+= a.getCalificacion();
		}
		return media/alumnos.length;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(alumnos.length + errores.length);
		sb.append(nombre);
		sb.append(": { ");
		sb.append(Arrays.toString(alumnos));
		sb.append(", ");
		sb.append(Arrays.toString(errores));
		sb.append(" }");
		return sb.toString();
	}
}
