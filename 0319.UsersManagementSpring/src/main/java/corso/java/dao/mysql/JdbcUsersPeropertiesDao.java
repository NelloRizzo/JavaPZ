package corso.java.dao.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import corso.java.dao.UsersPropertiesDao;
import corso.java.entities.Property;
import corso.java.entities.User;
import corso.java.entities.UserProperty;

@Component
public class JdbcUsersPeropertiesDao extends JdbcBaseDao implements UsersPropertiesDao {

	private static final String SELECT_ALL = //
			"SELECT user_id, property_id, username, password, friendly_name, name, value, default_value "
					+ " FROM usersmanagementsystem.users_properties up " //
					+ "   JOIN usersmanagementsystem.users u ON up.user_id = u.id " //
					+ "   JOIN usersmanagementsystem.properties p ON up.property_id = p.id"; //
	private static final String SELECT_BY_PROPERTY = //
			SELECT_ALL + " WHERE name = ?";
	private static final String SELECT_BY_USERNAME = //
			SELECT_ALL + " WHERE username = ?";
	private static final String INSERT = "INSERT INTO usersmanagementsystem.users_properties(user_id, property_id, value) " //
			+ "VALUES(?, ?, ?)";
	private static final String DELETE = "DELETE FROM usersmanagementsystem.users_properties " //
			+ " WHERE user_id = ? AND property_id = ?";

	private static class UserPropertyMapper implements RowMapper<UserProperty> {

		@Override
		public UserProperty mapRow(ResultSet rs, int rowNum) throws SQLException {
			return (UserProperty.builder() //
					.withProperty(Property.builder() //
							.withId(rs.getInt(rs.findColumn("property_id"))) //
							.withName(rs.getString(rs.findColumn("name"))) //
							.withDefaultValue(rs.getString(rs.findColumn("default_value"))).build()) //
					.withUser(User.builder() //
							.withId(rs.getInt(rs.findColumn("user_id"))) //
							.withFriendlyName(rs.getString(rs.findColumn("friendly_name"))) //
							.withPassword(rs.getString(rs.findColumn("password"))) //
							.withUsername(rs.getString(rs.findColumn("username"))) //
							.build()) //
					.withValue(rs.getString(rs.findColumn("value"))).build());
		}

	}

	public JdbcUsersPeropertiesDao(JdbcTemplate jdbcTemplate) {
		super(jdbcTemplate);
	}

	@Override
	public void create(UserProperty userProperty) {
		jdbcTemplate.update(INSERT, userProperty.getUser().getId(), userProperty.getProperty().getId(),
				userProperty.getValue());
	}

	@Override
	public List<UserProperty> findAllByPropertyName(String propertyName) {
		return jdbcTemplate.query(SELECT_BY_PROPERTY, new UserPropertyMapper(), propertyName);
	}

	@Override
	public List<UserProperty> findAllByUserUsername(String username) {
		return jdbcTemplate.query(SELECT_BY_USERNAME, new UserPropertyMapper(), username);
	}

	@Override
	protected String getCreateTableDDL() {
		return "CREATE TABLE IF NOT EXISTS `usersmanagementsystem`.`users_properties`(" //
				+ "  `user_id` INT NOT NULL," //
				+ "  `property_id` INT NOT NULL," //
				+ "  `value` VARCHAR(128) NOT NULL," //
				+ "  PRIMARY KEY (`user_id`, `property_id`));";
	}

	@Override
	protected String getDropTableDDL() {
		return "DROP TABLE IF EXISTS `usersmanagementsystem`.`users_properties`;";
	}

	@Override
	public void delete(UserProperty userProperty) {
		jdbcTemplate.update(DELETE, userProperty.getUser().getId(), userProperty.getProperty().getId());
	}

}
