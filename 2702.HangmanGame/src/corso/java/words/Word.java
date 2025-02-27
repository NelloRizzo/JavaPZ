package corso.java.words;

import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Rappresentazione in memoria di una parola.
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Word {
	/**
	 * La parola.
	 */
	@EqualsAndHashCode.Include
	private String word;

	/**
	 * Per "firma" di una parola intendo tutte le lettere che la compongono ordinate
	 * in ordine alfabetico.
	 * 
	 * @return la "firma" della parola
	 */
	@ToString.Include
	public String signature() {
		return word.chars() // apre uno stream di caratteri della stringa
				.sorted() // li mette in ordine
				.mapToObj(c -> String.valueOf((char) c)) // converte i caratteri in stringhe
				.collect(Collectors.joining()); // raccoglie tutto in una stringa
	}
}
