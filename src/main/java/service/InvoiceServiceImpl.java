package service;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		Date date = new Date();
		String formattedString = sdf.format(date);
		invoice.setInvoiceId("I" + formattedString);
		invoice.setCustId("C" + formattedString);
		invoiceRepository.insertInvoiceData(invoice);
		
	}

}
