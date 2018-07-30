package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import service.WarehouseService;
import to.BaseResponse;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {
	
	private final String sharedKey = "SHARED_KEY";
	private static final String SUCCESS_STATUS = "success";
	private static final String ERROR_STATUS = "error";
	private static final int SUCCESS_CODE = 100;
	private static final int ERROR_CODE = 102;
	
	@Autowired
	WarehouseService warehouseService;
	
	@CrossOrigin(origins="http://localhost:3000")
	@RequestMapping(value="/getwarehouseids",method=RequestMethod.GET)
	public BaseResponse getWarehouseIds (@RequestParam(value="key")String key) {
		
		BaseResponse baseResponse = new BaseResponse();
		
		List<String> warehouseIdList;
		
		if(key.equals(sharedKey)) {
			
			warehouseIdList = warehouseService.getWarehouseIds();
			
			baseResponse.setData(warehouseIdList);
			baseResponse.setCode(SUCCESS_CODE);
			baseResponse.setStatus(SUCCESS_STATUS);
		} else {
			baseResponse.setData("Unauthorized access");
			baseResponse.setCode(ERROR_CODE);
			baseResponse.setStatus(ERROR_STATUS);
		}
		
		return baseResponse;
		
	}

}
