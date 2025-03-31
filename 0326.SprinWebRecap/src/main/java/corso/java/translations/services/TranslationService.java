package corso.java.translations.services;

import java.util.List;

import corso.java.translations.services.dto.MessageDto;

public interface TranslationService {
	void saveMessage(MessageDto message);

	void deleteTranslation(String code, String languageCode);

	void deleteTranslations(String code);

	String getTranslation(String code, String languageCode);

	MessageDto getTranslations(String code);

	List<MessageDto> getAllMessages();

	List<MessageDto> getAllMessages(String languageCode);
}
