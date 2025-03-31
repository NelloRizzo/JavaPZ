package corso.java.translations.controllers.api;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import corso.java.translations.controllers.api.models.MessageModel;
import corso.java.translations.controllers.api.models.TranslationModel;
import corso.java.translations.services.TranslationService;
import corso.java.translations.services.dto.MessageDto;
import corso.java.translations.services.dto.TranslationDto;

@RestController
@RequestMapping("/api/translate")
public class TranslationsController {
	private final Logger LOGGER = LoggerFactory.getLogger(TranslationsController.class);
	private final TranslationService translationService;

	public TranslationsController(TranslationService translationService) {
		this.translationService = translationService;
	}

	@PostMapping
	public ResponseEntity<MessageModel> addTranslation(@RequestBody TranslationModel model) {
		try {
			var dto = MessageDto.builder().withCode(model.getMessageCode()).build();
			dto.getTranslations().add(TranslationDto.builder().withLanguage(model.getLanguageCode())
					.withText(model.getTranslation()).build());
			translationService.saveMessage(dto);
			var m = new MessageModel(model.getMessageCode());
			dto = translationService.getTranslations(model.getMessageCode());
			m.getTranslations().addAll(dto.getTranslations().stream().map(t -> TranslationModel.builder()
					.withLanguageCode(t.getLanguage()).withTranslation(t.getText()).build()).toList());
			return ResponseEntity.created(URI.create("")).body(m);
		} catch (Exception e) {
			LOGGER.error("Exception adding translation", e);
			return ResponseEntity.internalServerError().build();
		}
	}
}
