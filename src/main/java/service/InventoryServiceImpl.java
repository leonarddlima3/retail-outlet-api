package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.InventoryRepository;
import to.Inventory;
import to.ItemDetails;
import to.WarehouseDetails;

@Service("inventoryService")
public class InventoryServiceImpl implements InventoryService {
	
	@Autowired
	InventoryRepository inventoryRepository;
	
	public List<Inventory> getInventory () {
		Map<WarehouseDetails, List<ItemDetails>> map = inventoryRepository.getInventoryDetails();
		List<Inventory> inventoryList = new ArrayList<>();
		
		for(Map.Entry<WarehouseDetails, List<ItemDetails>> entry : map.entrySet()) {
			Inventory inventory = new Inventory();
			WarehouseDetails warehouseDetails = entry.getKey();
			inventory.setWarehouseId(warehouseDetails.getWarehouseId());
			inventory.setWarehouseName(warehouseDetails.getWarehouseName());
			inventory.setItemDetails(entry.getValue());
			inventoryList.add(inventory);
		}
		return inventoryList;
		
	}

}
