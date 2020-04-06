import prControl16.*;
public class PruebaObservaciones {
	
	public static void main(String[] args) {
		String x = "Roque de los Muchachos; Rigel; 0.13064";
		String y = "Mauna Kea; Vega; 0.02673";
		String z = "Mauna Kea; Rigel; 0.13248";
		String xx = "Roque de los Muchachos; Vega; 0,02627";
		
		Observaciones obs = new Observaciones();
		obs.addObs(x);
		obs.addObs(y);
		obs.addObs(z);
		obs.addObs(xx);
		
		System.out.println(obs.getMe("Rige0l"));
		System.out.println(obs.getMe("vEGA"));
	}
}
