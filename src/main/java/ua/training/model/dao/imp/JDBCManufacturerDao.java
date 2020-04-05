package ua.training.model.dao.imp;

import ua.training.model.dao.ManufacturerDao;
import ua.training.model.entity.Manufacturer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class JDBCManufacturerDao implements ManufacturerDao {
    public final static String FOREIGN_KEY = "manufacturer_id";
	private Connection connection;

	public JDBCManufacturerDao(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void create(Manufacturer entity) {

	}

	@Override
	public Optional<Manufacturer> findById(int id) {
		return Optional.empty();
	}

	@Override
	public List<Manufacturer> findAll() {
		return new ArrayList<>();
	}

	@Override
	public void update(Manufacturer entity) {

	}

	@Override
	public void delete(int id) {

	}

	@Override
	public void close() throws Exception {
		try {
			connection.close();
		} catch (SQLException e) {
			throw new Exception(e);
		}
	}

	static Manufacturer extractFromResultSet(ResultSet rs, Map<Integer, Manufacturer> existing) throws SQLException {
		int id = rs.getInt("manufacturer_id");
		Manufacturer result = existing.getOrDefault(id, new Manufacturer(id,
				rs.getString("manufacture"),
				rs.getInt("discount")));
		existing.putIfAbsent(id, result);
		return result;
	}
}
