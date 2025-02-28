package corso.java.html.elements;

import corso.java.html.attributes.AttributesList;
import lombok.Getter;

public abstract class EmptyHtmlElement extends HtmlNode {
	@Getter
	private final AttributesList attributes = new AttributesList();

	public EmptyHtmlElement(String name) {
		super(name, null);
	}

	protected String htmlTagName() {
		return getName().toLowerCase();
	}

	@Override
	public String html() {
		var sb = new StringBuilder() //
				.append('<').append(htmlTagName()); // <tagname
		if (getAttributes().size() > 0)
			sb.append(' ').append(getAttributes().html()); // <tagname attr1="value1" attr2="value2"
		return sb.append(">") // <tagname attr1="value1" attr2="value2"> -> es. <img src="test.jpg">
				.toString();
	}
}
