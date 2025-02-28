package corso.java.html.elements;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class HtmlNode {
	private String name;
	private String value;
	
	public abstract String html();
	
}
