package dao;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import to.Invoice;

@Repository("invoiceRepository")
public class InvoiceRepositoryImpl implements InvoiceRepository{
	
	@Autowired
    JdbcTemplate jdbcTemplate;
	
	
	@Override
	public void insertInvoiceData(Invoice invoice) throws SQLException, ClassNotFoundException {
		
		String query = "INSERT INTO INVOICE_DETAILS VALUES (?,?,?,?,?)";
		try {
			int res = jdbcTemplate.update(query,
		            invoice.getInvoiceId(), invoice.getDate(), invoice.getTotal(), invoice.getTax(), invoice.getTaxPerc());
		    if(res != 0) {
		    	query = "INSERT INTO INVOICE VALUES (?,?,?,?,?,?)";
		    	int index=0;
		    	for (String itemId : invoice.getItemId()) {
		    		jdbcTemplate.update(query,
				            invoice.getInvoiceId(), invoice.getCustId(), invoice.getEmpId(), invoice.getStoreId(), itemId, invoice.getBrandId().get(index));
		    		index++;
		    	}
		    }
		} catch(Exception e) {
			
		}
	}

}
