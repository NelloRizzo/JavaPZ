package corso.java.fiscalcode.services;

import corso.java.fiscalcode.controllers.models.PersonalData;

public interface FiscalCodeService {

	String generateFiscalCode(PersonalData data);
}
