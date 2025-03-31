package corso.java.translations.controllers.api;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import corso.java.translations.controllers.api.models.LanguageModel;
import corso.java.translations.services.LanguageService;
import corso.java.translations.services.dto.LanguageDto;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
	private static final Logger LOGGER = LoggerFactory.getLogger(LanguagesController.class);

	private final LanguageService languageService;

	public LanguagesController(LanguageService languageService) {
		this.languageService = languageService;
	}

	@PostMapping
	public ResponseEntity<List<LanguageModel>> addLanguage(@RequestBody LanguageModel model) {
		try {
			languageService.addLanguage(LanguageDto.builder().withCode(model.getCode())
					.withDescription(model.getDescription()).withName(model.getLanguage()).build());
			var result = getLanguages();
			return ResponseEntity.created(URI.create("/api/languages/" + model.getCode())).body(result.getBody());
		} catch (Exception e) {
			LOGGER.error("Exception adding language", e);
			return ResponseEntity.internalServerError().build();
		}
	}

	@PostMapping("multiple")
	public ResponseEntity<List<LanguageModel>> addLanguages(@RequestBody List<LanguageModel> model) {
		try {
			model.stream() //
					.forEach(l -> languageService.addLanguage( //
							LanguageDto.builder() //
									.withCode(l.getCode()) //
									.withDescription(l.getDescription()) //
									.withName(l.getLanguage()).build()));
			return getLanguages();
		} catch (Exception e) {
			LOGGER.error("Exception adding languages", e);
			return ResponseEntity.internalServerError().build();
		}

	}

	@GetMapping("{code}")
	public ResponseEntity<LanguageModel> getLanguageByCode(@PathVariable String code) {
		try {
			var l = languageService.getLanguageByCode(code).orElseThrow();
			return ResponseEntity.ok(LanguageModel.builder() //
					.withCode(l.getCode()) //
					.withDescription(l.getDescription()) //
					.withLanguage(l.getName()).build());
		} catch (Exception e) {
			LOGGER.error("Exception when getting language by code", e);
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	public ResponseEntity<List<LanguageModel>> getLanguages() {
		try {
			return ResponseEntity.ok( //
					languageService.getAllLanguages().stream() //
							.map(l -> LanguageModel.builder() //
									.withCode(l.getCode()) //
									.withDescription(l.getDescription()) //
									.withLanguage(l.getName()) //
									.build())
							.toList());
		} catch (Exception e) {
			LOGGER.error("Exception when getting languages", e);
			return ResponseEntity.internalServerError().build();
		}

	}
}
