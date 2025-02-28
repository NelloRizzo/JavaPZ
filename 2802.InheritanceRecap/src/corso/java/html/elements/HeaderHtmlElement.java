package corso.java.html.elements;

import lombok.Getter;

public class HeaderHtmlElement extends HtmlElement {
	@Getter
	private int level;

	public HeaderHtmlElement(int level) {
		super(String.format("H%d", level));
	}

}
