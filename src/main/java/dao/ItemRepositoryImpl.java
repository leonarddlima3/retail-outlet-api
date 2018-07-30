package dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import to.Item;

@Repository("itemRepository")
public class ItemRepositoryImpl implements ItemRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Item> getItemList() {
		String query = "SELECT ITEM_ID, ITEM_NAME, ITEM_TYPE_ID, ITEM_TYPE, ITEM_PRICE FROM ITEM";
		List<Item> itemList = new ArrayList<>();

		List<Item> rows = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Item.class));

		for (Item row : rows) {
			itemList.add(row);
		}

		return itemList;
	}

}
