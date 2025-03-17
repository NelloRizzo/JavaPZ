package corso.java.first.runners;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Articolo del blog.
 */
@Data
@AllArgsConstructor
public class Article {
	private Integer id;
	private String title;
	private String body;
	private String author;
	private LocalDateTime publishedAt;
}
