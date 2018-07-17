package service;

import java.sql.SQLException;

import to.Invoice;


public interface InvoiceService {
	
	public void createInvoiceService(Invoice invoice) throws ClassNotFoundException, SQLException ;

}
