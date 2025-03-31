package corso.java.translations.services.v1;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import corso.java.translations.entities.MessageEntity;
import corso.java.translations.entities.TranslationEntity;
import corso.java.translations.repositories.LanguagesRepository;
import corso.java.translations.repositories.MessagesRepository;
import corso.java.translations.repositories.TranslationsRepository;
import corso.java.translations.services.TranslationService;
import corso.java.translations.services.dto.MessageDto;
import corso.java.translations.services.dto.TranslationDto;
import corso.java.translations.services.exceptions.ServiceException;

@Service
public class TranslationServiceImpl implements TranslationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(TranslationServiceImpl.class);

	private final LanguagesRepository languagesRepository;
	private final MessagesRepository messagesRepository;
	private final TranslationsRepository translationsRepository;

	public TranslationServiceImpl(LanguagesRepository languagesRepository, MessagesRepository messagesRepository,
			TranslationsRepository translationsRepository) {
		this.languagesRepository = languagesRepository;
		this.messagesRepository = messagesRepository;
		this.translationsRepository = translationsRepository;
	}

	@Override
	public void saveMessage(MessageDto message) {
		try {
			var m = messagesRepository.findByCode(message.getCode())//
					.orElseGet(() -> messagesRepository.save(MessageEntity.builder() //
							.withCode(message.getCode()) //
							.build()));
			message.getTranslations().forEach(t -> {
				try {
					var language = languagesRepository.findByCode(t.getLanguage())
							.orElseThrow(() -> new ServiceException("Language not found"));
					m.getTranslations().add(//
							translationsRepository.save(TranslationEntity.builder() //
									.withMessage(m) //
									.withLanguage(language) //
									.withTranslation(t.getText()) //
									.build()));
				} catch (Exception e) {
					LOGGER.error("Skipped translastion {} because {}", t, e.getMessage());
				}
			});
		} catch (Exception e) {
			throw new ServiceException("Error while adding message", e);
		}
	}

	@Override
	public String getTranslation(String code, String languageCode) {
		try {
			return translationsRepository.findByMessageCodeAndLanguageCode(code, languageCode)
					.map(TranslationEntity::getTranslation).orElse(code);
		} catch (Exception e) {
			LOGGER.error("Exception when retrieving translation", e);
			return code;
		}
	}

	private void addTranslations(MessageDto messageDto, MessageEntity messageEntity) {
		messageDto.getTranslations() //
				.addAll(messageEntity.getTranslations().stream() //
						.map(t -> //
						TranslationDto.builder() //
								.withLanguage(t.getLanguage().getCode()) //
								.withText(t.getTranslation()).build())
						.toList());
	}

	@Override
	public MessageDto getTranslations(String code) {
		var dto = new MessageDto(code);
		try {
			var m = messagesRepository.findByCode(code).orElseThrow();
			addTranslations(dto, m);
		} catch (Exception e) {
			LOGGER.error("Exception when retrieving translations", e);
		}
		return dto;
	}

	@Override
	public List<MessageDto> getAllMessages() {
		try {
			return messagesRepository.findAll().stream().map(m -> new MessageDto(m.getCode())).toList();
		} catch (Exception e) {
			LOGGER.error("Excetpion when retrieving all messages", e);
			return List.of();
		}
	}

	@Override
	public List<MessageDto> getAllMessages(String languageCode) {
		try {
			return translationsRepository.findAllByLanguageCode(languageCode).stream().map(t -> {
				var dto = new MessageDto(t.getMessage().getCode());
				dto.getTranslations().add(TranslationDto.builder() //
						.withLanguage(languageCode) //
						.withText(t.getTranslation()).build());
				return dto;
			}).toList();
		} catch (Exception e) {
			LOGGER.error("Excetpion when retrieving all messages for language code", e);
			return List.of();
		}
	}

	@Override
	public void deleteTranslation(String code, String languageCode) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteTranslations(String code) {
		// TODO Auto-generated method stub

	}

}
