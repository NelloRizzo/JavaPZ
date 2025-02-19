package corso;
// fully qualified name
import corso.java.DatiAnagrafici;

public class Program {

	public static void main(String[] args) {
		// simple name
		DatiAnagrafici archimede = new DatiAnagrafici("Archimede", "Pitagorico");

//		archimede.nome = "Archimede";
//		archimede.cognome = "Pitagorico";
//		archimede.codiceFiscale = "PTGRCM00A00...";
//		archimede.setNome("Archimede");
//		archimede.setCognome("Pitagorico");

		System.out.println(archimede.getNome());

		DatiAnagrafici paperone = new DatiAnagrafici();
//		paperone.nome = "Paperone";
//		paperone.codiceFiscale = "PPP.....";
//		paperone.cognome = "De' Paperoni";
		paperone.setNome("Paperon");
		paperone.setCognome("De' Paperoni");
//		System.out.println(paperone.cognome);
		System.out.println(paperone.getCognome());

		DatiAnagrafici paperino = new DatiAnagrafici("Paperino", "Paolino");
		//paperino.setNome("");
		System.out.println(paperino.getNome() + " " + paperino.getCognome());
		
		archimede.presentaTeStesso();
		paperone.presentaTeStesso();
		paperino.presentaTeStesso();
	}

}
