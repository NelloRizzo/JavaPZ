package corso.java.translations.services;

import java.util.List;
import java.util.Optional;

import corso.java.translations.services.dto.LanguageDto;

public interface LanguageService {
	List<LanguageDto> getAllLanguages();

	Optional<LanguageDto> getLanguageByCode(String code);
	void addLanguage(LanguageDto language);
}
