package corso.java.fiscalcode.controllers.models;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PersonalData {
	private String firstName;
	private String lastName;
	private char gender;
	private LocalDate birthday;
	private String birthCity;
}
