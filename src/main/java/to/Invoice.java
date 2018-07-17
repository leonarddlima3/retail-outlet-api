package to;

import java.util.List;

public class Invoice {
	
	private String invoiceId;
	private String date;
	private float total;
	private float tax;
	private float taxPerc;
	private String custId;
	private String empId;
	private List<String> itemId;
	private List<String> brandId;
	private String storeId;
	public String getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public float getTax() {
		return tax;
	}
	public void setTax(float tax) {
		this.tax = tax;
	}
	public float getTaxPerc() {
		return taxPerc;
	}
	public void setTaxPerc(float taxPerc) {
		this.taxPerc = taxPerc;
	}
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public List<String> getItemId() {
		return itemId;
	}
	public void setItemId(List<String> itemId) {
		this.itemId = itemId;
	}
	public List<String> getBrandId() {
		return brandId;
	}
	public void setBrandId(List<String> brandId) {
		this.brandId = brandId;
	}
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	
	

}
