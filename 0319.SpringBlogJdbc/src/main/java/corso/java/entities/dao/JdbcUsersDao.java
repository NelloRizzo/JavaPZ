package corso.java.entities.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import corso.java.entities.User;
import corso.java.entities.dao.rowmappers.UserRowMapper;

@Component
public class JdbcUsersDao implements UsersDao {

	/*
	 * CREATE TABLE `users` ( `id` int NOT NULL AUTO_INCREMENT, `username`
	 * varchar(80) NOT NULL, `password` varchar(128) NOT NULL, `friendly_name`
	 * varchar(20) NOT NULL, PRIMARY KEY (`id`), UNIQUE KEY `username_UNIQUE`
	 * (`username`) )
	 */
	private final JdbcTemplate jdbcTemplate;

	private static final String INSERT_USER = //
			"INSERT INTO `spring_blog`.`users`(username, password, friendly_name) " //
					+ "VALUES(?, ?, ?)";
	private static final String SELECT_BY_USERNAME = //
			"SELECT id, username, password, friendly_name " //
					+ "FROM users " //
					+ "WHERE username = ?";

	@Autowired
	private UserRowMapper rowMapper;

	public JdbcUsersDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void registerUser(User user) {
		jdbcTemplate.update(INSERT_USER, user.getUsername(), user.getPassword(), user.getFriendlyName());

	}

	@Override
	public Optional<User> getUserByUsername(String username) {
		var user = jdbcTemplate.queryForObject(SELECT_BY_USERNAME, //
				rowMapper, username);
		if (user == null)
			return Optional.empty();
		return Optional.of(user);
	}

}
