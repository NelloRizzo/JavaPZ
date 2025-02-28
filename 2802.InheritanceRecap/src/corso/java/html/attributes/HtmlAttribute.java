package corso.java.html.attributes;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class HtmlAttribute {
	@Getter
	@EqualsAndHashCode.Include
	private String name;
	@Getter
	@Setter
	private String value;

	public String html() {
		if (value == null)
			return name;
		return String.format("%s=\"%s\"", name, value.replace('"', '\''));
	}
}
