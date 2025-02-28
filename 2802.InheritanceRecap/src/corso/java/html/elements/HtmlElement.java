package corso.java.html.elements;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;

@Getter
public abstract class HtmlElement extends EmptyHtmlElement {
	protected final List<HtmlNode> children = new ArrayList<>();

	public HtmlElement(String name) {
		super(name);
	}

	protected String innerHtml() {
		return new StringBuilder() //
				.append( //
						children.stream() //
								.map(e -> e.html()) // html di ogni figlio
								.collect(Collectors.joining()) // e concatena gli html...
				) //
				.toString();
	}

	@Override
	public String html() {
		return new StringBuilder() //
				.append(super.html()) // <tagname attr1="value1" attr2="value2">
				.append(innerHtml()) // aggiunge i figli...
				.append("</").append(htmlTagName()).append('>') // </tagname>
				.toString();
	}
}
