package corso.java.translations.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import corso.java.translations.entities.TranslationEntity;

public interface TranslationsRepository extends JpaRepository<TranslationEntity, Integer> {

	Optional<TranslationEntity> findByMessageCodeAndLanguageCode(String code, String languageCode);

	List<TranslationEntity> findAllByLanguageCode(String languageCode);

}
