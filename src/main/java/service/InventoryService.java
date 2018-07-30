package service;

import java.util.List;

import to.Inventory;

public interface InventoryService {
	
	public List<Inventory> getInventory (String warehouseId);

}
