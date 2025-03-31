package corso.java.translations.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import corso.java.translations.entities.LanguageEntity;

public interface LanguagesRepository extends JpaRepository<LanguageEntity, Integer> {
	Optional<LanguageEntity> findByCode(String code);

	List<LanguageEntity> findAllByOrderByNameAsc();
}
