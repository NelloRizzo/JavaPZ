package corso.java.translations.services.v1;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import corso.java.translations.entities.LanguageEntity;
import corso.java.translations.repositories.LanguagesRepository;
import corso.java.translations.services.LanguageService;
import corso.java.translations.services.dto.LanguageDto;
import corso.java.translations.services.exceptions.ServiceException;

@Service
public class LanguageServiceImpl implements LanguageService {
	private static final Logger LOGGER = LoggerFactory.getLogger(LanguageServiceImpl.class);
	private final LanguagesRepository languageRepository;

	public LanguageServiceImpl(LanguagesRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	@Override
	public List<LanguageDto> getAllLanguages() {
		try {
			return languageRepository.findAllByOrderByNameAsc().stream() //
					.map(language -> LanguageDto.builder() //
							.withCode(language.getCode()) //
							.withName(language.getName()) //
							.build()) //
					.toList();
		} catch (Exception e) {
			throw new ServiceException("Error while retrieving languages", e);
		}
	}

	@Override
	public Optional<LanguageDto> getLanguageByCode(String code) {
		try {

			return languageRepository.findByCode(code).map(language -> LanguageDto.builder() //
					.withCode(language.getCode()) //
					.withName(language.getName()) //
					.build());
		} catch (Exception e) {
			LOGGER.error("Error while retrieving language by code", e);
		}
		return Optional.empty();
	}

	@Override
	public void addLanguage(LanguageDto language) {
		try {
			languageRepository.save(LanguageEntity.builder() //
					.withCode(language.getCode()) //
					.withName(language.getName()) //
					.build());
		} catch (Exception e) {
			throw new ServiceException("Error while adding language", e);
		}
	}
}
