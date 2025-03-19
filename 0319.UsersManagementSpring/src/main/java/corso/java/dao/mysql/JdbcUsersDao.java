package corso.java.dao.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import corso.java.dao.UsersDao;
import corso.java.entities.User;

@Component
public class JdbcUsersDao extends JdbcBaseDao implements UsersDao {

	private static final String REGISTER_USER = //
			"INSERT INTO `usersmanagementsystem`.`users`(username, password, friendly_name) " //
					+ "VALUES (?, ?, ?);";
	private static final String SELECT_ALL = //
			"SELECT id, username, password, friendly_name FROM `usersmanagementsystem`.`users`";
	private static final String SELECT_BY_USERNAME = //
			"SELECT id, username, password, friendly_name FROM `usersmanagementsystem`.`users`" + " WHERE username = ?";

	private static class UserRowMapper implements RowMapper<User> {

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			return User.builder() //
					.withFriendlyName(rs.getString(rs.findColumn("friendly_name"))) //
					.withId(rs.getInt(rs.findColumn("id"))) //
					.withPassword(rs.getString(rs.findColumn("password"))) //
					.withUsername(rs.getString(rs.findColumn("username"))) //
					.build();
		}

	}

	public JdbcUsersDao(JdbcTemplate jdbcTemplate) {
		super(jdbcTemplate);
	}

	@Override
	public void create(User user) {
		jdbcTemplate.update(REGISTER_USER, user.getUsername(), user.getPassword(), user.getFriendlyName());
	}

	@Override
	public Optional<User> findByUsername(String username) {
		var user = jdbcTemplate.queryForObject(SELECT_BY_USERNAME, new UserRowMapper(), username);
		if (user == null)
			return Optional.empty();
		return Optional.of(user);
	}

	@Override
	public List<User> findAll() {
		return jdbcTemplate.query(SELECT_ALL, new UserRowMapper());
	}

	@Override
	protected String getCreateTableDDL() {
		return "CREATE TABLE IF NOT EXISTS `usersmanagementsystem`.`users` (" //
				+ "  `id` INT NOT NULL AUTO_INCREMENT," //
				+ "  `username` VARCHAR(80) NOT NULL," //
				+ "  `password` VARCHAR(128) NOT NULL," //
				+ "  `friendly_name` VARCHAR(20) NOT NULL," //
				+ "  PRIMARY KEY (`id`)," //
				+ "  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE);";
	}

	@Override
	protected String getDropTableDDL() {
		return "DROP TABLE IF EXISTS `usersmanagementsystem`.`users`;";
	}

}
