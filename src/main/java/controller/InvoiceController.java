package controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import service.InvoiceService;
import to.BaseResponse;
import to.Invoice;

@RestController
@RequestMapping("/invoice")
public class InvoiceController{
	
	private final String sharedKey = "SHARED_KEY";
	private static final String SUCCESS_STATUS = "success";
	private static final String ERROR_STATUS = "error";
	private static final int SUCCESS_CODE = 100;
	private static final int ERROR_CODE = 102;
	
	@Autowired
	@Qualifier("invoiceService")
	InvoiceService invoiceService;
	
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public BaseResponse createInvoice(@RequestParam(value="key")String key, @RequestBody Invoice request) {
		
		BaseResponse response = new BaseResponse();
		Invoice invoice = new Invoice();
		
		if (sharedKey.equals(key)) {
			invoice.setInvoiceId(request.getInvoiceId());
			invoice.setCustId(request.getCustId());
			invoice.setStoreId(request.getStoreId());
			invoice.setDate(request.getDate());
			invoice.setEmpId(request.getEmpId());
			invoice.setItemId(request.getItemId());
			invoice.setBrandId(request.getBrandId());
			invoice.setTax(request.getTax());
			invoice.setTaxPerc(request.getTaxPerc());
			invoice.setTotal(request.getTotal());
			
			try {
				invoiceService.createInvoiceService(invoice);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			response.setStatus(SUCCESS_STATUS);
			response.setCode(SUCCESS_CODE);
		} else {
			response.setStatus(ERROR_STATUS);
			response.setCode(ERROR_CODE);
		}
		return response;
		
	}

}
