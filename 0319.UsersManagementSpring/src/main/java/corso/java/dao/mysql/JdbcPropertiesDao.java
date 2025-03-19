package corso.java.dao.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import corso.java.dao.PropertiesDao;
import corso.java.entities.Property;

@Component
public class JdbcPropertiesDao extends JdbcBaseDao implements PropertiesDao {

	private static final String INSERT = "INSERT INTO `usersmanagementsystem`.`properties`(name) VALUES(?)";
	private static final String SELECT_ALL = "SELECT id, name FROM usersmanagementsystem.properties";
	private static final String SELECT_BY_NAME = SELECT_ALL + " WHERE name = ?";

	private static class PropertyMapper implements RowMapper<Property> {

		@Override
		public Property mapRow(ResultSet rs, int rowNum) throws SQLException {
			return Property.builder() //
					.withId(rs.getInt(rs.findColumn("id"))) //
					.withName(rs.getString(rs.findColumn("name"))) //
					.build();
		}

	}

	public JdbcPropertiesDao(JdbcTemplate jdbcTemplate) {
		super(jdbcTemplate);
	}

	@Override
	public Property create(Property property) {
		jdbcTemplate.update(INSERT, property.getName());
		return findByName(property.getName()).orElseThrow();
	}

	@Override
	public Optional<Property> findByName(String property) {
		var role = jdbcTemplate.queryForObject(SELECT_BY_NAME, new PropertyMapper(), property);
		if (role == null)
			return Optional.empty();
		return Optional.of(role);
	}

	@Override
	public List<Property> findAll() {
		return jdbcTemplate.query(SELECT_ALL, new PropertyMapper());
	}

	@Override
	protected String getCreateTableDDL() {
		return "CREATE TABLE IF NOT EXISTS `usersmanagementsystem`.`properties`(" //
				+ " `id` INT NOT NULL AUTO_INCREMENT," //
				+ " `name` VARCHAR(15) NOT NULL," //
				+ " PRIMARY KEY (`id`),"//
				+ " UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE);";
	}

	@Override
	protected String getDropTableDDL() {
		return "DROP TABLE IF EXISTS `usersmanagementsystem`.`properties`";
	}

}
