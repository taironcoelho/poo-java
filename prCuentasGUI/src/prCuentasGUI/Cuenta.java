package prCuentasGUI;

public class Cuenta {
	private double saldo;

	public Cuenta(double saldoInicial) {
		if (saldoInicial < 0) {
			throw new RuntimeException("Saldo inicial negativo");
		}
		saldo = saldoInicial;
	}

	public double saldo() {
		return saldo;
	}

	public void ingresa(double cantidad) {
		if (cantidad < 0) {
			throw new RuntimeException("Error: Cantidad negativa");
		}
		saldo += cantidad;
	}

	public double extrae(double cantidad) {
		if (cantidad < 0) {
			throw new RuntimeException("Error: Cantidad negativa");
		}
		if (cantidad > saldo) {
			cantidad = saldo;
		}
		saldo -= cantidad;
		return cantidad;
	}
}
