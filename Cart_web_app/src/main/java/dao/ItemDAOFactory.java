package dao;

import java.sql.SQLException;

public class ItemDAOFactory {

	private static ItemDAO itemDao;

	public static ItemDAO getInstance() {
		if (itemDao == null) {
			synchronized (ItemDAOFactory.class) {
				if (itemDao == null) {
					try {
						itemDao = new ItemDAOImpl();
					} catch (ClassNotFoundException | SQLException e) {
						throw new RuntimeException();
					}
				}
			}
		}
		return itemDao;
	}

}
