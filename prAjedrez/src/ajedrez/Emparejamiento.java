package ajedrez;

public class Emparejamiento {
	private Jugador blancas;
	private Jugador negras;
	private int resultado; // 1 ganan blancas, 0 empate, 2 ganan negras
	
	public Emparejamiento(Jugador blancas, Jugador negras) {
		this.blancas = blancas;
		this.negras = negras;
		this.blancas.agregarContrincante(this.negras);
		this.negras.agregarContrincante(this.blancas);
	}
	
	public Jugador getBlancas() {
		return blancas;
	}

	public Jugador getNegras() {
		return negras;
	}

	public int getResultado() {
		return resultado;
	}

	public void setResultado(int resultado) {
		if (resultado==0 || resultado==1 || resultado==2)
		{
			this.resultado = resultado;
		} else {
			throw new AppException();
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		sb.append(blancas.getNombre());
		sb.append(" (");
		sb.append(blancas.getMediaRatingContricantes());
		sb.append(")-");
		sb.append(negras.getNombre());
		sb.append(" (");
		sb.append(negras.getMediaRatingContricantes());
		sb.append(")] -->");
		sb.append(resultado);
		return sb.toString();
	}
}
