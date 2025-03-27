package corso.java.fiscalcode.controllers.api;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import corso.java.fiscalcode.controllers.models.FiscalCodeResult;
import corso.java.fiscalcode.controllers.models.PersonalData;
import corso.java.fiscalcode.services.FiscalCodeService;

@RestController
@RequestMapping("/api/fiscalcode")
public class FiscalCodeApiController {
	
	private final FiscalCodeService service;
	
	public FiscalCodeApiController(FiscalCodeService service) {
		this.service = service;
	}

	@PostMapping(value = "/generate", //
			consumes = MediaType.APPLICATION_JSON_VALUE, //
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FiscalCodeResult> generateFiscalCode( //
			@RequestBody PersonalData data) {

		var result = FiscalCodeResult.builder() //
				.withData(data) //
				.withFiscalCode(service.generateFiscalCode(data)) //
				.build();
		return ResponseEntity.ok(result);
	}
}
