package corso.java.elm.services;

import java.util.List;

import corso.java.elm.dto.CompanyDto;

public interface CompanyService {
	void registerCompany(CompanyDto c);

	List<CompanyDto> getAll();
}
