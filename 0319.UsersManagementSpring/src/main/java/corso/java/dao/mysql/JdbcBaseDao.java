package corso.java.dao.mysql;

import org.springframework.jdbc.core.JdbcTemplate;

public abstract class JdbcBaseDao {

	protected final JdbcTemplate jdbcTemplate;

	protected abstract String getCreateTableDDL();

	protected abstract String getDropTableDDL();

	public JdbcBaseDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		dropTable();
		createTable();
	}

	protected final void createTable() {
		jdbcTemplate.execute(getCreateTableDDL());
	}

	protected final void dropTable() {
		jdbcTemplate.execute(getDropTableDDL());
	}
}
