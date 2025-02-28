package corso.java.html.elements;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class HtmlDocument {
	@Getter
	private String docType;
	@Getter
	private final BodyHtmlElement body = new BodyHtmlElement();

	@Override
	public String toString() {
		return new StringBuilder() //
				.append("<!DOCTYPE ").append(docType).append(">") //
				.append(body.html()) //
				.toString();
	}
}
