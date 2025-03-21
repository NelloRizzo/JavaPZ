package corso.java.businesslayer.services;

import java.awt.List;

public interface ArticleService {
	void publish();

	void update();

	void delete();

	List readAll();
}
