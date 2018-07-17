package service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.InvoiceRepository;
import to.Invoice;

@Service("invoiceService")
public class InvoiceServiceImpl implements InvoiceService{
	
	@Autowired
	InvoiceRepository invoiceRepository;
	
	@Override
	public void createInvoiceService(Invoice invoice) throws ClassNotFoundException, SQLException {
		invoiceRepository.insertInvoiceData(invoice);
	}

}
