package corso.java;

import java.util.Objects;

public class Region {
	private String name;
	private String code;
	private Area area;

	public Region(String name, String code, Area area) {
		this.name = name;
		this.code = code;
		this.area = area;
	}

	public Region() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return String.format("Region(name=%s, code=%s, area=%s)", name, code, area);
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Region && obj.hashCode() == hashCode();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(code);
	}
}
