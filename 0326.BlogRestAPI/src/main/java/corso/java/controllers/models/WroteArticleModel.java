package corso.java.controllers.models;

import lombok.Data;

@Data
public class WroteArticleModel {
	private int authorId;
	private String title;
	private String body;
}
