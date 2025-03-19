package corso.java.entities.dao.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import corso.java.entities.User;

@Component
@Scope("prototype")
public class UserRowMapper implements RowMapper<User> {

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
