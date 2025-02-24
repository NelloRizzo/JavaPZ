package corso.java.data;

import java.util.Objects;

public class City {
	private String name;
	private String province;
	private String zip;

	public City(String name, String province, String zip) {
		super();
		this.name = name;
		this.province = province;
		this.zip = zip;
	}

	public City() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return String.format("City(name=%s, province=%s, zip=%s)", name, province, zip);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, province, zip);
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof City && hashCode() == obj.hashCode();
	}

}
