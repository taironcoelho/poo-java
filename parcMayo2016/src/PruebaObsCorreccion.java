import prControl16.*;

public class PruebaObsCorreccion {
	public static void main(String[] args) {
		String x = "Roque de los Muchachos; Rigel; 0.13064";
		String y = "Mauna Kea; Vega; 0.02673";
		String z = "Mauna Kea; Rigel; 0.13248";
		String xx = "Roque de los Muchachos; Vega; 0.02627";
		
		Correcion[] corr = {new Correcion("Mauna Kea", 0.99222), new Correcion("Roque de los Muchachos", 1.00789)};
	
		ObsCorrecion obs = new ObsCorrecion(corr);
		//Por el concepto de herencia se utiliza los metodos de la super clase
		obs.addObs(x);
		obs.addObs(y);
		obs.addObs(z);
		obs.addObs(xx);
		
		//System.out.println(obs.toString());
		System.out.println(obs.getMoe("Roque de los Muchachos", "Rigel"));
	}
}
