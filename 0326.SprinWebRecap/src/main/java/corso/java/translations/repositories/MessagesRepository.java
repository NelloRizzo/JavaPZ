package corso.java.translations.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import corso.java.translations.entities.MessageEntity;

public interface MessagesRepository extends JpaRepository<MessageEntity, Integer> {

	Optional<MessageEntity> findByCode(String code);

}
