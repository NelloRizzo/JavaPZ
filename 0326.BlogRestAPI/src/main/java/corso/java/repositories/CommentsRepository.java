package corso.java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import corso.java.entities.CommentEntity;

public interface CommentsRepository extends JpaRepository<CommentEntity, Integer> {

}
