package corso.java;

public class DatiAnagrafici {
	private String nome;
	private String cognome;
	private String codiceFiscale;

	// Costruttore
	public DatiAnagrafici() {
		nome = "NON INSERITO";
		cognome = "NON INSERITO";
	}

	public DatiAnagrafici(String nome, String cognome) {
		setNome(nome);
		setCognome(cognome);
	}

	// Getters e Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String ilNome) {
		if (ilNome.length() == 0) {
			System.out.println("Sei stupido!!!!");
			nome = "NON INSERITO";
		} else
			nome = ilNome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	// operazioni proprie della classe
	public void presentaTeStesso() {
		System.out.println("Buongiorno, mi chiamo " + nome.substring(0, 1) + ". " + cognome);
	}
}
