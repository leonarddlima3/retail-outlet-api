package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import service.InventoryService;
import to.BaseResponse;
import to.Inventory;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

	private final String sharedKey = "SHARED_KEY";
	private static final String SUCCESS_STATUS = "success";
	private static final String ERROR_STATUS = "error";
	private static final int SUCCESS_CODE = 100;
	private static final int ERROR_CODE = 102;

	@Autowired
	@Qualifier("inventoryService")
	InventoryService inventoryService;

	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/getInventoryDetails", method = RequestMethod.GET)
	public BaseResponse getInventoryDetails(@RequestParam(value = "key") String key,
			@RequestParam(value = "warehouseId") String warehouseId) {
		BaseResponse response = new BaseResponse();

		// String warehouseId = "W1001";
		if (sharedKey.equals(key)) {
			try {
				List<Inventory> inventoryList = inventoryService.getInventory(warehouseId);

				response.setCode(SUCCESS_CODE);
				response.setStatus(SUCCESS_STATUS);
				response.setData(inventoryList);
			} catch (Exception e) {
				response.setData("Exception occured");
				response.setCode(ERROR_CODE);
				response.setStatus(ERROR_STATUS);
			}
		} else {
			response.setData("Unauthorized access");
			response.setCode(ERROR_CODE);
			response.setStatus(ERROR_STATUS);
		}

		return response;
	}

}
