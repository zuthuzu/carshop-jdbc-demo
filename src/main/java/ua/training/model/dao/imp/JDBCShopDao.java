package ua.training.model.dao.imp;

import ua.training.model.dao.ShopDao;
import ua.training.model.entity.Shop;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class JDBCShopDao implements ShopDao {
    private Connection connection;

    public JDBCShopDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Shop entity) {

    }

    @Override
    public Optional<Shop> findById(int id) {
        return Optional.empty();
    }

    @Override
    public List<Shop> findAll() {
        return new ArrayList<>();
    }

    @Override
    public void update(Shop entity) {

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

    static Shop extractFromResultSet(ResultSet rs, Map<Integer, Shop> existing) throws SQLException {
        int id = rs.getInt("shop.id");
        Shop result = existing.getOrDefault(id, new Shop(id,
                rs.getString("name"),
                rs.getString("phone")));
        existing.putIfAbsent(id, result);
        return result;
    }
}
