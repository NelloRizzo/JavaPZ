package corso.java.datalayer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import corso.java.datalayer.entities.CommentEntity;

public interface CommentsRepository extends JpaRepository<CommentEntity, Integer> {

}
