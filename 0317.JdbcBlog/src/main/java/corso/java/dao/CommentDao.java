package corso.java.dao;

import java.util.List;

import corso.java.entities.Comment;

public interface CommentDao {
	void dropTable();

	void createTable();

	void save(Comment comment);

	List<Comment> findAllByArticleId(int articleId);
}
