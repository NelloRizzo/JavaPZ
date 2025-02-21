package corso.java;

public class Alunno {
	private String nome;
	private String matricola;
	private int voto;

	public Alunno() {
	}

	public Alunno(String nome, String matricola, int voto) {
		this.nome = nome;
		this.matricola = matricola;
		this.voto = voto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public int getVoto() {
		return voto;
	}

	public void setVoto(int voto) {
		this.voto = voto;
	}

	@Override
	public String toString() {
		return String.format("Alunno(nome=%s, matricola=%s, voto=%s)", nome, matricola, voto);
	}

}
