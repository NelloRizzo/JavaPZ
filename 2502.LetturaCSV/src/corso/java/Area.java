package corso.java;

import java.util.Objects;

public class Area {
	private String nome;
	private String code;

	public Area(String nome, String code) {
		this.nome = nome;
		this.code = code;
	}

	public Area() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return String.format("Area(nome=%s, code=%s)", nome, code);
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Area && obj.hashCode() == hashCode();
	}

	@Override
	public int hashCode() {
		return Objects.hash(code);
	}
}
