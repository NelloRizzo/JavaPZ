package corso.java.dao.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import corso.java.dao.RolesDao;
import corso.java.entities.Role;

@Component
public class JdbcRolesDao extends JdbcBaseDao implements RolesDao {

	private static final String INSERT = "INSERT INTO `usersmanagementsystem`.`roles`(name) VALUES(?)";
	private static final String SELECT_ALL = "SELECT id, name FROM usersmanagementsystem.roles";
	private static final String SELECT_BY_NAME = SELECT_ALL + " WHERE name = ?";

	private static class RoleMapper implements RowMapper<Role> {

		@Override
		public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
			return Role.builder() //
					.withId(rs.getInt(rs.findColumn("id"))) //
					.withName(rs.getString(rs.findColumn("name"))) //
					.build();
		}

	}

	public JdbcRolesDao(JdbcTemplate jdbcTemplate) {
		super(jdbcTemplate);
	}

	@Override
	public Role create(Role role) {
		jdbcTemplate.update(INSERT, role.getName());
		return findByName(role.getName()).orElseThrow();
	}

	@Override
	public List<Role> findAll() {
		return jdbcTemplate.query(SELECT_ALL, new RoleMapper());
	}

	@Override
	public Optional<Role> findByName(String name) {
		var role = jdbcTemplate.queryForObject(SELECT_BY_NAME, new RoleMapper(), name);
		if (role == null)
			return Optional.empty();
		return Optional.of(role);
	}

	@Override
	protected String getCreateTableDDL() {
		return "CREATE TABLE IF NOT EXISTS `usersmanagementsystem`.`roles`(" //
				+ " `id` INT NOT NULL AUTO_INCREMENT," //
				+ " `name` VARCHAR(15) NOT NULL," //
				+ " PRIMARY KEY (`id`),"//
				+ " UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE);";
	}

	@Override
	protected String getDropTableDDL() {
		return "DROP TABLE IF EXISTS `usersmanagementsystem`.`roles`";
	}

}
