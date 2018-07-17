package dao;

import java.util.List;
import java.util.Map;
import to.ItemDetails;
import to.WarehouseDetails;

public interface InventoryRepository {
	
	public Map<WarehouseDetails, List<ItemDetails>> getInventoryDetails();

}
