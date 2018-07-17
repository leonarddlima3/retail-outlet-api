package to;

import java.util.List;

public class Inventory {
	
	private String warehouseId;
	private String warehouseName;
	private List<ItemDetails> itemDetails;
	
	public String getWarehouseId() {
		return warehouseId;
	}
	public void setWarehouseId(String warehouseId) {
		this.warehouseId = warehouseId;
	}
	public String getWarehouseName() {
		return warehouseName;
	}
	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}
	public List<ItemDetails> getItemDetails() {
		return itemDetails;
	}
	public void setItemDetails(List<ItemDetails> itemDetails) {
		this.itemDetails = itemDetails;
	}

}
