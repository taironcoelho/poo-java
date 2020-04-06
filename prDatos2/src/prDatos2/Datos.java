package prDatos2;

import java.util.Arrays;
import java.util.StringJoiner;

public class Datos {
	
	private double[] datos;
	private String[] errores;
	private double min;
	private double max;
	
	public Datos(String [] d, double minValue, double maxValue) {
		min = minValue;
		max = maxValue;
		procesarDatos(d);
	}
	
	public double calcMedia() throws DatosException{
		double sum = 0;
		int term = 0;
		for(double x: datos) {
			if((x>= min) && (x<=max)) {
				sum+=x;
				term++;
			}
		}
		if(term == 0) {
			throw new DatosException("vacio");
		}
		return sum/term;
	}
	
	public double calcDesvTipica() throws DatosException {
		double m = calcMedia();
		int n = 0;
		double sum = 0;
		for(double x: datos) {
			if((x>= min) && (x<=max)) {
				sum+=Math.pow(x-m, 2);
				n++;
			}
		}
		
		return Math.sqrt(sum/n);
	}
	
	public void setRango(String data) throws DatosException{
		try {
			int pos = data.indexOf(";");
			min = Double.parseDouble(data.substring(0, pos));
			max = Double.parseDouble(data.substring(pos+1));
		} catch(RuntimeException e) {
			throw new DatosException("Error en los datos al estabelecer el rango");
		}
	}
	
	public double[] getDatos() {
		return datos;
	}
	
	public String[] getErrores() {
		return errores;
	}
	
	private void procesarDatos(String [] d) {
		int nd = 0;
		int ne = 0;
		
		datos = new double[d.length];
		errores = new String[d.length];
		
		for(String x:d) {
			try {
				double valor = Double.parseDouble(x);
				datos[nd] = valor;
				++nd;
			} catch (NumberFormatException e) {
				errores[ne] = x;
				++ne;
			}
		}
		datos = Arrays.copyOf(datos, nd);
		errores = Arrays.copyOf(errores, ne);
	}
	
	@Override
	public String toString() {
		StringJoiner sj = new StringJoiner(", ");
		sj.add("Min: " + min);
		sj.add("Max: " + max);
		sj.add("\n" + Arrays.toString(datos));
		sj.add("\n" + Arrays.toString(errores));
		try {
			sj.add("\n Media: " + calcMedia());
		} catch(DatosException e) {
			sj.add("\n Media: ERROR");
		}
		try {
			sj.add("DesvTipica: " + calcDesvTipica());
		} catch(DatosException e) {
			sj.add("DesvTipica: ERROR");
		}
		return sj.toString();
	}
}
