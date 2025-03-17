package corso.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Getter;

public abstract class DaoTemplate<T> {
	private static final Logger log = LoggerFactory.getLogger(DaoTemplate.class);

	/**
	 * La connessione viene gestita come static così può essere condivisa tra più
	 * istanze. Alla prima chiamata del costruttore viene creata e non viene più
	 * modificata così da poter essere riutilizzata da tutte le classi che estendono
	 * questa.
	 */
	@Getter
	private static Connection connection = null;

	protected DaoTemplate(String url, String username, String password) {
		try {
			if (connection == null) // controlla se la connessione è stata inizializzata
				// e provvede ad inizializzarla se è il caso
				connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			log.error("Exception creating the connection to MySQL", e);
			throw new RuntimeException(e);
		}
	}

	protected void createTable(String ddl) {
		try (var stmt = connection.prepareStatement(ddl)) {
			log.info("Creating table");
			stmt.execute();
		} catch (SQLException e) {
			log.error("Exception dropping table", e);
		}
	}

	protected void dropTable(String ddl) {
		try (var stmt = connection.prepareStatement(ddl)) {
			log.info("Dropping table");
			stmt.execute();
		} catch (SQLException e) {
			log.error("Exception dropping table", e);
		}
	}

	/**
	 * Ogni classe ha il compito di prevedere la trasformazione dal ResultSet al
	 * tipo di entità gestita.
	 * 
	 * @param rs il ResultSet.
	 * @return l'entità che corrisponde al record corrente.
	 * @throws SQLException
	 */
	protected abstract T map(ResultSet rs) throws SQLException;

	protected List<T> findAll(String query) {
		var result = new ArrayList<T>();
		try (var stmt = connection.prepareStatement(query)) {
			try (var rs = stmt.executeQuery()) {
				while (rs.next()) {
					result.add(map(rs));
				}
			}
		} catch (SQLException e) {
			log.error("Exception getting all entities", e);
		}
		return result;

	}

	protected Optional<T> findById(String query, int id) {
		try (var stmt = connection.prepareStatement(query)) {
			// ATTENZIONE: do per scontato che l'id sia l'unico parametro della query!!!
			stmt.setInt(1, id);
			try (var rs = stmt.executeQuery()) {
				if (rs.next()) {
					return Optional.of(map(rs));
				}
			}
		} catch (SQLException e) {
			log.error("Exception getting entity by id", e);
		}
		return Optional.empty();
	}

}
