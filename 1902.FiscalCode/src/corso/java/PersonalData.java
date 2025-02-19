package corso.java;

import java.time.LocalDate;

public class PersonalData {
	private String firstName;
	private String lastName;
	private Gender gender;
	private LocalDate birthday;
	private String birthCity;

	public PersonalData() {

	}

	public PersonalData(String firstName, String lastName, Gender gender, LocalDate birthday, String birthCity) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.birthday = birthday;
		this.birthCity = birthCity;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getBirthCity() {
		return birthCity;
	}

	public void setBirthCity(String birthCity) {
		this.birthCity = birthCity;
	}
}
