
public class Program {

	public static void main(String[] args) {
		String alpha = "abcdeFGFedcdef";
		System.out.println("Lunghezza: " + alpha.length());
		System.out.println("Terzo carattere: " + alpha.charAt(2));
		System.out.println("Concatenazione: " + alpha.concat("hilmno"));
		System.out.println("Posizione del carattere 'c': " + alpha.indexOf('c'));
		System.out.println("Posizione della stringa 'def': " + alpha.indexOf("def"));
		System.out.println("Ultima occorrenza di 'c': " + alpha.lastIndexOf('c'));
		System.out.println("Replace: " + alpha.replace("cd", "CD"));
		System.out.println("Repeat: " + "AAA".repeat(2));
		System.out.println("Sottostringa: " + alpha.substring(2, 5));
		System.out.println("Check su inizio: " + alpha.startsWith("abc"));
		System.out.println("Check su fine: " + alpha.endsWith("def"));
		System.out.println("Maiuscolo: " + alpha.toUpperCase());
		System.out.println("Minuscolo: " + alpha.toLowerCase());

		alpha = "aaa";
		String other = alpha;
		System.out.println("Other = " + other + " Alpha = " + alpha);
		if (other == alpha) {
			System.out.println("Le due stringhe sono uguali");
		}

		other = "a" + alpha.substring(1);
		System.out.println("Other = " + other + " Alpha = " + alpha);
		if (other == alpha) {
			System.out.println("Le due stringhe sono uguali");
		} else
			System.out.println("Le due stringhe sono diverse");
		
		if (other.equals(alpha)) {
			System.out.println("Le due stringhe sono uguali");
		} else
			System.out.println("Le due stringhe sono diverse");
	}

}
