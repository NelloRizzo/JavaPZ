package corso.java;

public class City {
	private String name;
	private String code;
	private boolean capital;
	private String cadastral;
	private Province province;

	public City(String name, String code, boolean capital, String cadastral, Province province) {
		this.name = name;
		this.code = code;
		this.capital = capital;
		this.cadastral = cadastral;
		this.province = province;
	}

	public City() {
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

	public boolean isCapital() {
		return capital;
	}

	public void setCapital(boolean capital) {
		this.capital = capital;
	}

	public String getCadastral() {
		return cadastral;
	}

	public void setCadastral(String cadastral) {
		this.cadastral = cadastral;
	}

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	@Override
	public String toString() {
		return String.format("City(name=%s, code=%s, capital=%s, cadastral=%s, province=%s)", name, code, capital,
				cadastral, province);
	}

}
