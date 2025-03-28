package corso.java.fiscalcode.controllers.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import corso.java.fiscalcode.controllers.models.PersonalData;
import corso.java.fiscalcode.services.FiscalCodeService;

@Controller
public class FiscalCodeController {

	private final FiscalCodeService service;

	public FiscalCodeController(FiscalCodeService service) {
		this.service = service;
	}

	@GetMapping
	public String index(ModelMap map) {
		map.addAttribute("data", new PersonalData());
		return "index";
	}

	@PostMapping("/generate")
	public String generateFiscalCode(@ModelAttribute PersonalData data, ModelMap map) {
		var fc = service.generateFiscalCode(data);
		map.addAttribute("data", data);
		map.addAttribute("fiscalCode", fc);
		return "index";
	}
}
