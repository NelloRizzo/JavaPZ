package corso.java.utils;

public class City {
	private int code;
	private String name;
	private float acreage;
	private int people;

	public City(int code, String name, float acreage, int people) {
		this.code = code;
		this.name = name;
		this.acreage = acreage;
		this.people = people;
	}

	public City() {
	}

	public int getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public float getAcreage() {
		return acreage;
	}

	public float getKm2() {
		return acreage * .01f;
	}

	public float getDensity() {
		return people / getKm2();
	}

	public int getPeople() {
		return people;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAcreage(float acreage) {
		this.acreage = acreage;
	}

	public void setPeople(int people) {
		this.people = people;
	}

	@Override
	public String toString() {
		return String.format("City(code=%s, name=%s, acreage=%s, people=%s, kmq=%s, density=%s)", code, name,
				acreage, people, getKm2(), getDensity());
	}

}
