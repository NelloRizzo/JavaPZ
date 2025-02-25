package corso.java;

import java.util.Objects;

public class Province {
	private String name;
	private String code;
	private String acronym;
	private Region region;

	public Province(String name, String code, String acronym, Region region) {
		this.name = name;
		this.code = code;
		this.acronym = acronym;
		this.region = region;
	}

	public Province() {
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

	public String getAcronym() {
		return acronym;
	}

	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	@Override
	public String toString() {
		return String.format("Province(name=%s, code=%s, acronym=%s, region=%s)", name, code, acronym, region);
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Province && hashCode() == obj.hashCode();
	}

	@Override
	public int hashCode() {
		return Objects.hash(code);
	}
}
