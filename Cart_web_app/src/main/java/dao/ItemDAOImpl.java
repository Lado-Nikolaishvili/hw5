package dao;

import model.Item;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class ItemDAOImpl implements ItemDAO {

	private final List<Item> items = new ArrayList<>();

	public ItemDAOImpl() throws ClassNotFoundException, SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost", "root", "qwer");
		Statement st = con.createStatement();
		st.executeQuery("USE pr");
		ResultSet result = st.executeQuery("SELECT * FROM products");

		while (result.next()) {
			String id = result.getString("productid");
			String name = result.getString("name");
			String image = result.getString("imagefile");
			String price = result.getString("price");

			Item item = Item.builder()
					.id(id)
					.name(name)
					.image(image)
					.price(new BigDecimal(price))
					.build();
			items.add(item);
		}
	}

	@SuppressWarnings("OptionalGetWithoutIsPresent")
	@Override
	public Item find(String id) {
		return items.stream()
				.filter(prod -> prod.getId().equals(id))
				.map(Item::copy)
				.findAny()
				.get();
	}

	@Override
	public List<Item> findAll() {
		return items.stream()
				.map(Item::copy)
				.collect(toList());
	}

}
