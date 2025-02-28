package corso.java.html;

import corso.java.html.elements.HeaderHtmlElement;
import corso.java.html.elements.HtmlDocument;
import corso.java.html.elements.ParagraphHtmlElement;
import corso.java.html.elements.TextHtmlNode;

public class Program {

	public static void main(String[] args) {
		var d = new HtmlDocument("html");
		var h1 = new HeaderHtmlElement(1);
		h1.getChildren().add(new TextHtmlNode("Titolo della pagina"));
		h1.getAttributes().setAttribute("style", "color:red;");
		var p = new ParagraphHtmlElement();
		p.getChildren().add(new TextHtmlNode("Questo è un paragrafo della pagina HTML."));
		d.getBody().getChildren().add(h1);
		d.getBody().getChildren().add(p);

		System.out.println(d.toString());
	}

}
