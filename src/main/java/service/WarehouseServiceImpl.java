package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.WarehouseRepository;

@Service("warehouseService")
public class WarehouseServiceImpl implements WarehouseService{
	
	@Autowired
	WarehouseRepository warehouseRepository;
	
	public List<String> getWarehouseIds() {
		List<String> warehouseIdList = warehouseRepository.getWarehouseIds();
		
		return warehouseIdList;
	}

}
