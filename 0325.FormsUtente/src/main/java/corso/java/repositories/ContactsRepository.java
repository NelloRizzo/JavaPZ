package corso.java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import corso.java.entities.ContactEntity;

public interface ContactsRepository extends JpaRepository<ContactEntity, Integer>{

}
