package prUnivSelector;

import java.util.Arrays;
import java.util.Scanner;
import java.util.NoSuchElementException;
import java.util.Locale;
import java.util.Optional;
import java.util.StringJoiner;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;

public class ListaAlumnos {
	private static final int TAM = 8;
	private int nalumnos;
	private Alumno[] alumnos;

	public ListaAlumnos() {
		nalumnos = 0;
		alumnos = new Alumno[TAM];
	}
	
	public void anyadirAlumno(Alumno aln) {
		int pos = buscarAlumno(aln);
		if (0 <= pos && pos < nalumnos) {
			alumnos[pos] = aln;
		} else {
			if (nalumnos == alumnos.length) {
				alumnos = Arrays.copyOf(alumnos, 2*alumnos.length);
			}
			alumnos[nalumnos] = aln;
			++nalumnos;
		}
	}
	
	public void anyadirAlumnos(String datos) {
		String[] dtalumnos = datos.split("\\s*[;]\\s*");
		for (String dtaln : dtalumnos) {
			String[] aln = dtaln.split("\\s*[,]\\s*");
			if (aln.length == 3) {
				try {
					double nota = Double.parseDouble(aln[2]);
					anyadirAlumno(new Alumno(aln[0], aln[1], nota));
				} catch (NumberFormatException e) {
				/* desechar los datos sin hacer nada */
				}
			}
		}
	}
	
	public void anyadirAlumnosAlternativoConScanner(String datos) {
		try (Scanner sc1 = new Scanner(datos)) {
			sc1.useDelimiter("\\s*[;]\\s*");
			while (sc1.hasNext()) {
				String dtaln = sc1.next();
				try (Scanner sc2 = new Scanner(dtaln)) {
					sc2.useDelimiter("\\s*[,]\\s*");
					sc2.useLocale(Locale.ENGLISH);
					anyadirAlumno(new Alumno(sc2.next(),sc2.next(),sc2.nextDouble()));
				} catch (NoSuchElementException e) {
				/* desechar los datos sin hacer nada */
				}
			}
		}
	}
	
	public void anyadirNotasAlumno(String datos) {
		String[] aln = datos.split("\\s*[,]\\s*");
		if (aln.length < 3) {
			throw new RuntimeException("Datos erróneos");
		}
		double suma = 0;
		for (int i = 2; i < aln.length; ++i) {
			suma += Double.parseDouble(aln[i]); // puede lanzar NumberFormatException
		}
		double notaMedia = suma / (aln.length - 2);
		anyadirAlumno(new Alumno(aln[0], aln[1], notaMedia));
	}

	public void anyadirNotasAlumnoAlternativoConScanner(String datos) {
		try (Scanner sc2 = new Scanner(datos)) {
			sc2.useDelimiter("\\s*[,]\\s*");
			sc2.useLocale(Locale.ENGLISH);
			String nombre = sc2.next();
			String dni = sc2.next();
			int cnt = 0;
			double suma = 0;
			while (sc2.hasNext()) {
				suma += sc2.nextDouble(); // puede lanzar InputMismatchException
				++cnt;
			}
			double notaMedia = suma / cnt; // puede lanzar ArithmeticException
			anyadirAlumno(new Alumno(nombre, dni, notaMedia));
		}
	}

	public Optional<Alumno> buscarAlumno(String n, String d) {
		Optional<Alumno> res;
		int pos = buscarAlumno(new Alumno(n, d, 0));
		if (0 <= pos && pos < nalumnos) {
			res = Optional.of(alumnos[pos]);
		} else {
			res = Optional.empty();
		}
		return res;
	}

	@Override
	public String toString() {
		StringJoiner sj = new StringJoiner("; ", "[ ", " ]");
		for (int i = 0; i < nalumnos; ++i) {
			sj.add(alumnos[i].toString());
		}
		return sj.toString();
	}

	public void cargarDeFichero(String nombreFich) throws IOException {
		try (Scanner sc1 = new Scanner(new File(nombreFich))) {
			while (sc1.hasNextLine()) {
				String linea = sc1.nextLine();
				try (Scanner sc2 = new Scanner(linea)) {
					sc2.useDelimiter("\\s*[;]\\s*");
					sc2.useLocale(Locale.ENGLISH);
					anyadirAlumno(new Alumno(sc2.next(), sc2.next(), sc2.nextDouble()));
				} catch (NoSuchElementException e) {
					/* desechar los datos sin hacer nada */
				}
			}
		}
	}

	public void guardarEnFichero(String nombreFich) throws IOException {
		try (PrintWriter pw = new PrintWriter(new File(nombreFich))) {
			guardarPW(pw);
		}
	}

	public void mostrarEnConsola() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(System.out, true);
			guardarPW(pw);
		} finally {
			if (pw != null) {
				pw.flush();
			}
		}
	}

	private void guardarPW(PrintWriter pw) {
		for (int i = 0; i < nalumnos; ++i) {
			pw.println(alumnos[i].getNombre() + "; " + alumnos[i].getDni() + "; " + alumnos[i].getNota());
		}
	}

	private int buscarAlumno(Alumno aln) {
		int i = 0;
		while ((i < nalumnos) && !alumnos[i].equals(aln)) {
			++i;
		}
		if (i == nalumnos) {
			i = -1;
		}
		return i;
	}
	//--------------------------------
	// Nuevos métodos
	//--------------------------------
	public Alumno[] seleccionar(SelectorAlumno selector) {
		Alumno[] ls = new Alumno[nalumnos];
		int cnt = 0;
		for (int i = 0; i < nalumnos; ++i) {
			if (selector.esSeleccionable(alumnos[i])) {
				ls[cnt] = alumnos[i];
				++cnt;
			}
		}
		return Arrays.copyOf(ls, cnt);
	}
	
	@Override
	public boolean equals(Object o) {
		boolean ok = false;
		if (o instanceof ListaAlumnos) {
			ListaAlumnos x = (ListaAlumnos)o;
			if (this.nalumnos == x.nalumnos) {
				int i = 0;
				while ((i < this.nalumnos)
						&& this.alumnos[i].equals(x.alumnos[i])) {
					++i;
				}
				ok = (i == this.nalumnos);
			}
		}
		return ok;
	}
	
	@Override
	public int hashCode() {
		int h = Integer.hashCode(nalumnos);
		for (int i = 0; i < nalumnos; ++i) {
			h = h * 31 + alumnos[i].hashCode();
		}
		return h;
	}
	//--------------------------------
}
