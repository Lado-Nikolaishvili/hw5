package server;

import dao.ItemDAO;
import dao.ItemDAOFactory;
import model.ItemInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCartManagerImpl implements ShoppingCartManager {

	private static Map<String, ItemInfo> cart = new HashMap<>();
	private final ItemDAO itemDAO = ItemDAOFactory.getInstance();

	@Override
	public void store(String itemId, long count) {
		ItemInfo itemInfo = cart.computeIfAbsent(itemId, (id) -> new ItemInfo(itemDAO.find(id), 0));
		itemInfo.addCount(count);
	}

	@Override
	public List<ItemInfo> getAddedItems() {
		return new ArrayList<>(cart.values());
	}

	@Override
	public void update(Map<String, Long> carts) {
		Map<String, ItemInfo> updated = new HashMap<>();

		for (String key : carts.keySet()) {
			ItemInfo itemInfo = cart.get(key);
			itemInfo.setCount(carts.get(key));
			updated.put(itemInfo.getItem().getId(), itemInfo);
		}
		cart = updated;
	}

}
