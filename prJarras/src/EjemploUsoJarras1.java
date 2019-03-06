import prJarras.Jarra;

public class EjemploUsoJarras1 {
	public static void main (String [ ] args) {
		Jarra jarraA = new Jarra(7);
		Jarra jarraB = new Jarra(4);
		
		jarraA.llena();
		System.out.println(jarraA.toString());
		System.out.println(jarraB.toString());
		
		jarraB.llenaDesde(jarraA);
		System.out.println(jarraA.toString());
		System.out.println(jarraB.toString());
		
		jarraB.vacia();
		System.out.println(jarraA.toString());
		System.out.println(jarraB.toString());
		
		jarraB.llenaDesde(jarraA);
		System.out.println(jarraA.toString());
		System.out.println(jarraB.toString());
    }
}
