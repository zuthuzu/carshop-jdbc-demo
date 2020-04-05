package ua.training.model.dao.imp;

import ua.training.model.dao.CarDao;
import ua.training.model.entity.Car;
import ua.training.model.entity.Manufacturer;
import ua.training.model.entity.Shop;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class JDBCCarDao implements CarDao {

	private Connection connection;

	public JDBCCarDao(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void create(Car entity) {

	}

	@Override
	public Optional<Car> findById(int id) {
		return Optional.empty();
	}

	@Override
	public List<Car> findAll() {
		Map<Integer, Car> cars = new HashMap<>();
		Map<Integer, Manufacturer> manufacturers = new HashMap<>();
		Map<Integer, Shop> shops = new HashMap<>();

		try (Statement ps = connection.createStatement()) {
            //TODO: select a limited column list instead of the wildcard
			ResultSet rs = ps.executeQuery(
					"SELECT *, shop.id AS shop_id FROM car " +
							"LEFT JOIN manufacturer ON car." + JDBCManufacturerDao.FOREIGN_KEY + "=manufacturer.id " +
							"LEFT JOIN shop ON shop." + JDBCManufacturerDao.FOREIGN_KEY + "=manufacturer.id");
			while (rs.next()) {
				Car result = extractFromResultSet(rs, cars);
				result.setManufacturer(JDBCManufacturerDao.extractFromResultSet(rs, manufacturers));
				result.addShop(JDBCShopDao.extractFromResultSet(rs, shops));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return new ArrayList<>(cars.values());
	}

	private Car extractFromResultSet(ResultSet rs, Map<Integer, Car> existing) throws SQLException {
		int id = rs.getInt("id");
		Car result = existing.getOrDefault(id, new Car(id,
				rs.getString("model"),
				rs.getInt("price")));
		existing.putIfAbsent(id, result);
		return result;
	}

	@Override
	public void update(Car entity) {

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
}
