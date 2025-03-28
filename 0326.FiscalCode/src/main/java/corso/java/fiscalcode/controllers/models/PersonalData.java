package corso.java.fiscalcode.controllers.models;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class PersonalData {
	private String firstName;
	private String lastName;
	private char gender;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthday;
	private String birthCity;
}
