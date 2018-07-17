package dao;

import java.sql.SQLException;

import to.Invoice;

public interface InvoiceRepository {
	
	public void insertInvoiceData(Invoice invoice) throws SQLException, ClassNotFoundException;

}
