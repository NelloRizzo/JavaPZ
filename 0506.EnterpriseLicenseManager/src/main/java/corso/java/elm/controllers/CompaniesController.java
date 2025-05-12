package corso.java.elm.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import corso.java.elm.controllers.models.RegisterCompanyModel;
import corso.java.elm.dto.CompanyDto;
import corso.java.elm.services.CompanyService;

@RestController
@RequestMapping("/api/companies")
public class CompaniesController {

	private final CompanyService service;

	public CompaniesController(CompanyService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<?> register(@RequestBody RegisterCompanyModel model) {
		service.registerCompany(CompanyDto.builder() //
				.withAddress(model.getAddress()) //
				.withEmail(model.getEmail()) //
				.withName(model.getName()) //
				.withVat(model.getVat()) //
				.build());
		return ResponseEntity.ok(null);
	}

	@GetMapping
	public ResponseEntity<List<CompanyDto>> list() {
		return ResponseEntity.ok(service.getAll());
	}
}
