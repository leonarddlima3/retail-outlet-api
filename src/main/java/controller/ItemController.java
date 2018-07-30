package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import service.ItemService;
import to.BaseResponse;
import to.Item;

@RestController
@RequestMapping("/item")
public class ItemController {
	
	private final String sharedKey = "SHARED_KEY";
	private static final String SUCCESS_STATUS = "success";
	private static final String ERROR_STATUS = "error";
	private static final int SUCCESS_CODE = 100;
	private static final int ERROR_CODE = 102;
	
	@Autowired
	ItemService itemService;
	
	@CrossOrigin(origins= "http://localhost:3000")
	@RequestMapping(value="/getitemlist",method=RequestMethod.GET)
	public BaseResponse getItemList(@RequestParam(value="key") String key) {
		BaseResponse response = new BaseResponse();
		List<Item> itemList;
		
		if(sharedKey.equals(key)) {
			itemList = itemService.getitemList();
			
			response.setData(itemList);
			response.setStatus(SUCCESS_STATUS);
			response.setCode(SUCCESS_CODE);
		} else {
			response.setData("Unauthorized access");
			response.setStatus(ERROR_STATUS);
			response.setCode(ERROR_CODE);
		}
		
		return response;
		
	}

}
