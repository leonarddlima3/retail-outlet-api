package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("warehouseRepository")
public class WarehouseRepositoryImpl implements WarehouseRepository{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<String> getWarehouseIds() {
		
		List<String> warehouseIdList = new ArrayList<>();
		String query = "SELECT WAREHOUSE_ID FROM WAREHOUSE";
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);
		
		for (Map<String, Object> row : rows) {
			warehouseIdList.add((String)row.get("WAREHOUSE_ID"));
		}
		
		return warehouseIdList;
	}
	

}
