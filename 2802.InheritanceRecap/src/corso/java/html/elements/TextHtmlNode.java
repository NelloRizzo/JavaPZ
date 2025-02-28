package corso.java.html.elements;

public class TextHtmlNode extends HtmlNode {

	public TextHtmlNode(String value) {
		super("#text", value);
	}

	@Override
	public String html() {
		return getValue();
	}
}
