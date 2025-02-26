package calculator;

public class Program {

	private static void useCalculator(Calculator calc) {
		calc.add(10);
		calc.sub(20);
		calc.mul(30);
		calc.div(40);
		System.out.println(calc);
	}

	public static void main(String[] args) {
		// Una calcolatrice consente
		// di effettuare le 4 operazioni dell'aritmetica
		// in maniera che esse modifichino un accumulatore
		// interno che è possibile leggere alla fine delle
		// operazioni.
		System.out.println("Calcolatrice semplice:");
		useCalculator(new StandardCalculator());
		System.out.println("Calcolatrice con registrazione delle operazioni:");
		useCalculator(new RibbonCalculator());
	}

}
