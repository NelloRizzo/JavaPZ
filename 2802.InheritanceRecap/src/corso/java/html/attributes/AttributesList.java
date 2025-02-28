package corso.java.html.attributes;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class AttributesList {
	private final Set<HtmlAttribute> attributes = new HashSet<>();

	public AttributesList setAttribute(String name, String value) {
		unsetAttribute(name);
		attributes.add(new HtmlAttribute(name, value));
		return this;
	}

	public int size() {
		return attributes.size();
	}

	public AttributesList unsetAttribute(String name) {
		attributes.removeIf(a -> a.getName().equalsIgnoreCase(name));
		return this;
	}

	public String html() {
		return attributes.stream() //
				.map(a -> a.html()) //
				.collect(Collectors.joining(" ")) //
				.toString();
	}
}
