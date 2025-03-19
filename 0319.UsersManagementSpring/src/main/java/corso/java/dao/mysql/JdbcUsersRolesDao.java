package corso.java.dao.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import corso.java.dao.UsersRolesDao;
import corso.java.entities.Role;
import corso.java.entities.User;
import corso.java.entities.UserRole;

@Component
public class JdbcUsersRolesDao extends JdbcBaseDao implements UsersRolesDao {

	private static final String INSERT = "INSERT INTO usersmanagementsystem.users_roles(user_id, role_id) VALUES(?, ?);";
	private static final String DELETE = "DELETE FROM usersmanagementsystem.users_roles " //
			+ " WHERE user_id = ? AND role_id = ?";
	private static final String SELECT_ALL = //
			"SELECT role_id, user_id, name, friendly_name, password, username "
					+ "FROM usersmanagementsystem.users_roles ur"
					+ " JOIN usersmanagementsystem.users u ON ur.user_id = u.id " //
					+ " JOIN usersmanagementsystem.roles r ON ur.role_id = r.id";
	private static final String SELECT_BY_ROLE_NAME = //
			SELECT_ALL + " WHERE name = ?";
	private static final String SELECT_BY_USERNAME = //
			SELECT_ALL + " WHERE username = ?";

	private static class UserRoleMapper implements RowMapper<UserRole> {

		@Override
		public UserRole mapRow(ResultSet rs, int rowNum) throws SQLException {
			return UserRole.builder() //
					.withRole(Role.builder() //
							.withId(rs.getInt(rs.findColumn("role_id"))) //
							.withName(rs.getString(rs.findColumn("name"))) //
							.build()) //
					.withUser(User.builder() //
							.withId(rs.getInt(rs.findColumn("user_id"))) //
							.withFriendlyName(rs.getString(rs.findColumn("friendly_name"))) //
							.withPassword(rs.getString(rs.findColumn("password"))) //
							.withUsername(rs.getString(rs.findColumn("username"))) //
							.build()) //
					.build();
		}

	}

	public JdbcUsersRolesDao(JdbcTemplate jdbcTemplate) {
		super(jdbcTemplate);
	}

	@Override
	public void create(UserRole userRole) {
		jdbcTemplate.update(INSERT, userRole.getUser().getId(), userRole.getRole().getId());
	}

	@Override
	public void delete(UserRole userRole) {
		jdbcTemplate.update(DELETE, userRole.getUser().getId(), userRole.getRole().getId());
	}

	@Override
	public List<UserRole> findAllByRoleName(String roleName) {
		return jdbcTemplate.query(SELECT_BY_ROLE_NAME, new UserRoleMapper(), roleName);
	}

	@Override
	public List<UserRole> findAllByUserUsername(String username) {
		return jdbcTemplate.query(SELECT_BY_USERNAME, new UserRoleMapper(), username);
	}

	@Override
	protected String getCreateTableDDL() {
		return "CREATE TABLE IF NOT EXISTS `usersmanagementsystem`.`users_roles`(" //
				+ "  `user_id` INT NOT NULL," //
				+ "  `role_id` INT NOT NULL," //
				+ "  PRIMARY KEY (`user_id`, `role_id`));";
	}

	@Override
	protected String getDropTableDDL() {
		return "DROP TABLE IF EXISTS `usersmanagementsystem`.`users_roles`";
	}

}
