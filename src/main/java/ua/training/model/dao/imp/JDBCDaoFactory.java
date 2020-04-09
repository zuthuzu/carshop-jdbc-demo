package ua.training.model.dao.imp;

import ua.training.model.dao.CarDao;
import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.ManufacturerDao;
import ua.training.model.dao.ShopDao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCDaoFactory extends DaoFactory {
    private final static String PROPERTIES = "db.properties";
    private final static String DB_URL = "db.url";
    private final static String DB_USER = "db.user";
    private final static String DB_PWD = "db.password";

    private String url;
    private String user;
    private String password;

    @Override
    public CarDao createCarDao() {
        return new JDBCCarDao(getConnection());
    }
    @Override
    public ManufacturerDao createManufacturerDao() {
        return new JDBCManufacturerDao(getConnection());
    }
    @Override
    public ShopDao createShopDao() {
        return new JDBCShopDao(getConnection());
    }

    private Connection getConnection(){
        try {
            getProperties();
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void getProperties() throws IOException {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(PROPERTIES)) {
            Properties prop = new Properties();
            prop.load(input);
            url = prop.getProperty(DB_URL);
            user = prop.getProperty(DB_USER);
            password = prop.getProperty(DB_PWD);
        }
    }
}
