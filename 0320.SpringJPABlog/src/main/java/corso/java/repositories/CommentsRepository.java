package corso.java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import corso.java.entities.Comment;

@Repository
public interface CommentsRepository extends JpaRepository<Comment, Integer> {

}
