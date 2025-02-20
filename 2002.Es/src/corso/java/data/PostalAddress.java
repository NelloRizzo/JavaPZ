package corso.java.data;

public class PostalAddress extends Address {
	private String street;
	private String zip;
	private String city;
	private String province;

	public PostalAddress(String street, String zip, String city, String province) {
		super();
		this.street = street;
		this.zip = zip;
		this.city = city;
		this.province = province;
	}

	public PostalAddress(String street, String zip, String city, String province, boolean isWork) {
		super(isWork);
		this.street = street;
		this.zip = zip;
		this.city = city;
		this.province = province;
	}

	public PostalAddress() {
		super();
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Override
	public String toString() {
		return String.format("PostalAddress(street=%s, zip=%s, city=%s, province=%s, %s)", street, zip, city, province,
				super.toString());
	}

}
