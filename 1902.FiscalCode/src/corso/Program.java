package corso;

import java.time.LocalDate;

import corso.java.FiscalCodeService;
import corso.java.Gender;
import corso.java.PersonalData;

public class Program {

	public static void main(String[] args) {
		PersonalData pd = new PersonalData("Archimede", "Pitagorico", //
				Gender.MALE, LocalDate.of(1975, 1, 1), "Paperopoli");
		
		if (pd.getGender() == Gender.MALE) {
			System.out.println(pd.getFirstName() + " è un uomo");
		}
		
		FiscalCodeService service = new FiscalCodeService();
		String fc = service.calculateFiscalCode(pd);
		System.out.printf("Codice fiscale di %s %s = %s\n",
				pd.getFirstName(), pd.getLastName(),
				fc);
	}

}
