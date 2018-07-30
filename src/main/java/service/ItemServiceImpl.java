package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ItemRepository;
import to.Item;

@Service("itemService")
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	ItemRepository itemRepository;

	@Override
	public List<Item> getitemList() {
		
		List<Item> itemList = itemRepository.getItemList();
		List<Item> itemlist1 = new ArrayList<>();
		for(Item item : itemList) {
			Item item1 = new Item();
			item1.setItemId(item.getItemId());
			item1.setItemName(item.getItemName().length()>1 ? (item.getItemName().substring(0, 1)+item.getItemName().substring(1).toLowerCase()) : item.getItemName());
			item1.setItemTypeId(item.getItemTypeId());
			item1.setItemType(item.getItemType().length()>1 ? (item.getItemType().substring(0, 1)+item.getItemType().substring(1).toLowerCase()) : item.getItemType());
			item1.setItemPrice(item.getItemPrice());
			itemlist1.add(item1);
		}
		return itemlist1;
	}
	
}
