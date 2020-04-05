package ua.training;

import ua.training.model.dao.CarDao;
import ua.training.model.dao.DaoFactory;

/**
 * Hello world!
 */
public class CarShops {
	public static void main(String[] args) {
		DaoFactory factory = DaoFactory.getInstance();
		CarDao dao = factory.createCarDao();
		dao.findAll().forEach(System.out::println);
	}
}

