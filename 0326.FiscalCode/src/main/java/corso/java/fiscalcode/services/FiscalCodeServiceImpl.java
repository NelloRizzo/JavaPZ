package corso.java.fiscalcode.services;

import org.springframework.stereotype.Service;

import corso.java.fiscalcode.controllers.models.PersonalData;

@Service
public class FiscalCodeServiceImpl implements FiscalCodeService{

	@Override
	public String generateFiscalCode(PersonalData data) {
		return "XXXXXX00X00X000X";
	}

}
