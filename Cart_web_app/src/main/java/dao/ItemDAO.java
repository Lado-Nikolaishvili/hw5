package dao;

import model.Item;

import java.util.List;

public interface ItemDAO {

	Item find(String id);

	List<Item> findAll();


}
