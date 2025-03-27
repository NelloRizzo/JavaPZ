package corso.java.fiscalcode.services;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import corso.java.fiscalcode.controllers.models.PersonalData;

@Service
public class FiscalCodeServiceImpl implements FiscalCodeService{

	@Override
	public String generateFiscalCode(PersonalData data) {
		var sb = new StringBuilder() //
				.append(handleLastName(data.getLastName())) //
				.append(handleFirstName(data.getFirstName())) //
				.append(handleBirthday(data.getBirthday(), data.getGender())) //
				.append(handleBirthCity(data.getBirthCity())) //
				;
		return sb.append(checkCode(sb)).toString();
	}

	private char checkCode(StringBuilder sb) {
		return 'X';
	}

	private String handleBirthCity(String birthCity) {
		return "X000";
	}

	private String handleBirthday(LocalDate birthday, char gender) {
		return "00X00";
	}

	private String handleFirstName(String firstName) {
		return "XXX";
	}

	private String handleLastName(String lastName) {
		return "XXX";
	}

}
