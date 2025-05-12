package corso.java.elm.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import corso.java.elm.dto.CompanyDto;

@Service
public class CompanyServiceImpl implements CompanyService {
	private static final List<CompanyDto> companies = new ArrayList<CompanyDto>();

	@Override
	public void registerCompany(CompanyDto c) {
		var id = companies.stream().mapToInt(e -> e.getId()).max().orElse(0) + 1;
		c.setId(id);
		companies.add(c);
	}

	@Override
	public List<CompanyDto> getAll() {
		return companies.stream().toList();
	}
}
