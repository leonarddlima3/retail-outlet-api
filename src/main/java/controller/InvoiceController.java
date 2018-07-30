package controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public BaseResponse createInvoice(@RequestParam(value="key")String key, @RequestBody Invoice request) {
		
		BaseResponse response = new BaseResponse();
		Invoice invoice = new Invoice();
		
		if (sharedKey.equals(key)) {
			
			try {
			request.setInvoiceId("I" + (int) (Math.random()*10) + "");
			invoice.setInvoiceId(request.getInvoiceId());
			request.setCustId("C1001");
			invoice.setCustId(request.getCustId());
			request.setCustId("S1001");
			invoice.setStoreId(request.getStoreId());
			invoice.setDate(request.getDate());
			request.setEmpId("E1001");
			invoice.setEmpId(request.getEmpId());
			invoice.setItemId(request.getItemId());
			invoice.setBrandId(request.getBrandId());
			invoice.setTax(request.getTax());
			invoice.setTaxPerc(request.getTaxPerc());
			invoice.setTotal(request.getTotal());
			
			invoiceService.createInvoiceService(invoice);
			
			response.setStatus(SUCCESS_STATUS);
			response.setCode(SUCCESS_CODE);
			
			} catch (SQLException e) {
				response.setData("SQL Exception occured");
				response.setStatus(ERROR_STATUS);
				response.setCode(ERROR_CODE);
			} catch (ClassNotFoundException e) {
				response.setData("ClassNotFoundException occured");
				response.setStatus(ERROR_STATUS);
				response.setCode(ERROR_CODE);
			} catch (Exception e) {
				response.setData("Exception occured");
				response.setStatus(ERROR_STATUS);
				response.setCode(ERROR_CODE);
			}
			
			
		} else {
			response.setData("Unauthorized access");
			response.setStatus(ERROR_STATUS);
			response.setCode(ERROR_CODE);
		}
		return response;
		
	}

}
