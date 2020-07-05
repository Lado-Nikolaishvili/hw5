package server;

import model.ItemInfo;

import java.util.List;
import java.util.Map;

public interface ShoppingCartManager {

	void store(String itemId, long count);

	List<ItemInfo> getAddedItems();

	void update(Map<String, Long> carts);
}
