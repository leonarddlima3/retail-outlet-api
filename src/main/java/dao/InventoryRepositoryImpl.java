package dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import to.Brand;
import to.InventoryRow;
import to.Item;
import to.ItemDetails;
import to.WarehouseDetails;

@Repository("inventoryRepository")
public class InventoryRepositoryImpl implements InventoryRepository {
	
	@Autowired
    JdbcTemplate jdbcTemplate;
	
	@Override
	public Map<WarehouseDetails, List<ItemDetails>> getInventoryDetails() {
		
		String query = "SELECT W.WAREHOUSE_ID, W.WAREHOUSE_NAME, WS.ITEM_ID, I.ITEM_NAME, I.ITEM_TYPE_ID, I.ITEM_TYPE, WS.BRAND_ID, B.BRAND_NAME FROM WAREHOUSE W, WAREHOUSE_STOCK WS, ITEM I, BRAND B WHERE W.WAREHOUSE_ID=WS.WAREHOUSE_ID AND I.ITEM_ID=WS.ITEM_ID AND B.BRAND_ID=WS.BRAND_ID";
		Map<WarehouseDetails, List<ItemDetails>> map = new LinkedHashMap<>();
		try {
			//List<Map<String, Object>> row = jdbcTemplate.queryForList(query);
			List<InventoryRow> row  = jdbcTemplate.query(query,new BeanPropertyRowMapper<>(InventoryRow.class));
			
			//for(Map<String, Object> rs : row) {
			for(InventoryRow rs : row) {
				WarehouseDetails warehouseDetails = new WarehouseDetails();
				warehouseDetails.setWarehouseId(rs.getWarehouseId());
				warehouseDetails.setWarehouseName(rs.getWarehouseName());
				if(map.containsKey(warehouseDetails)) {
					Item item = new Item();
					item.setItemId(rs.getItemId());
					item.setItemName(rs.getItemName());
					item.setItemTypeId(rs.getItemTypeId());
					item.setItemTypeName(rs.getItemType());
					Brand brand =  new Brand();
					brand.setBrandId(rs.getBrandId());
					brand.setBrandName(rs.getBrandName());
					ItemDetails itemDetails = new ItemDetails();
					itemDetails.setItem(item);
					itemDetails.setBrand(brand);
					map.get(warehouseDetails).add(itemDetails);
				} else {
					Item item = new Item();
					item.setItemId(rs.getItemId());
					item.setItemName(rs.getItemName());
					item.setItemTypeId(rs.getItemTypeId());
					item.setItemTypeName(rs.getItemType());
					Brand brand =  new Brand();
					brand.setBrandId(rs.getBrandId());
					brand.setBrandName(rs.getBrandName());
					ItemDetails itemDetails = new ItemDetails();
					itemDetails.setItem(item);
					itemDetails.setBrand(brand);
					List<ItemDetails> itemDetailsList = new ArrayList<>();
					itemDetailsList.add(itemDetails);
					map.put(warehouseDetails, itemDetailsList);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return map;
	}

}
