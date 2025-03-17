package corso.java.entities;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class Comment {
	private int id;
	private int articleId;
	private String body;
	private String author;
	private LocalDateTime publishedAt;
}
