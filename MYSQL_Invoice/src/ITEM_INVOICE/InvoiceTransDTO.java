package ITEM_INVOICE;

import java.io.Serializable;

public class InvoiceTransDTO implements Cloneable,Serializable {
	private int invoice_id;
	private int item_id;
	private int quantity;
	
	private static InvoiceTransDTO invoiceTransDTO;
	synchronized public static InvoiceTransDTO getInvoiceTransDTO() {
		if(invoiceTransDTO==null) {
			invoiceTransDTO=new InvoiceTransDTO();
		}
		return invoiceTransDTO.getCloneInvoiceTransDTO();		
	}
	
	private InvoiceTransDTO getCloneInvoiceTransDTO() {
		try {
			return (InvoiceTransDTO)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	private InvoiceTransDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public int getInvoice_id() {
		return invoice_id;
	}
	
	public void setInvoice_id(int invoice_id) {
		this.invoice_id = invoice_id;
	}
	
	public int getItem_id() {
		return item_id;
	}
	
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
//		result = prime * result + ((invoiceid == null) ? 0 : invoiceid.hashCode());
//		result = prime * result + ((customer_id == null) ? 0 : customer_id.hashCode());
		result = prime * result + invoice_id;
		result = prime * result + Float.floatToIntBits(item_id);
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvoiceTransDTO other = (InvoiceTransDTO) obj;
		if (!(invoice_id == other.invoice_id))
			return false;
		if (!(item_id == other.item_id))
			return false;
		if(!(quantity == other.quantity))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "InvoiceTransDTO [Invoice ID =" + invoice_id + ",Item Id =" + item_id + ", Quantity="
				+ quantity + "]";
	}
	
	
}
