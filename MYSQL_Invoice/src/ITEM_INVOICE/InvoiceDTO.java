package ITEM_INVOICE;

import java.io.Serializable;
import java.sql.Date;

public class InvoiceDTO implements Serializable,Cloneable {
	private int invoiceid;
	private Date invdate;
	private int customer_id;
	private long customercellphone;
	
	private static InvoiceDTO invoiceDTO;
	synchronized public static InvoiceDTO getInvoiceDTO() {
		if(invoiceDTO==null) {
			invoiceDTO=new InvoiceDTO();
		}
		return invoiceDTO.getCloneInvoiceDTO();		
	}
	
	private InvoiceDTO getCloneInvoiceDTO() {
		try {
			return (InvoiceDTO)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
//		result = prime * result + ((invoiceid == null) ? 0 : invoiceid.hashCode());
//		result = prime * result + ((customer_id == null) ? 0 : customer_id.hashCode());
		result = prime * result + customer_id;
		result = prime * result + Float.floatToIntBits(customercellphone);
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
		InvoiceDTO other = (InvoiceDTO) obj;
		if (!(invoiceid == other.invoiceid))
			return false;
		if (!(customer_id == other.customer_id))
			return false;
		if(!(customercellphone == other.customercellphone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "InvoiceDTO [Invoice ID =" + invoiceid + ",Invoice Date =" + invdate.toString() + ", Customer cell phone="
				+ customercellphone + "]";
	}
	
	private InvoiceDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getInvoiceid() {
		return invoiceid;
	}

	public void setInvoiceid(int invoiceid) {
		this.invoiceid = invoiceid;
	}

	public Date getInvdate() {
		return invdate;
	}

	public void setInvdate(Date invdate) {
		this.invdate = invdate;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public long getCustomercellphone() {
		return customercellphone;
	}

	public void setCustomercellphone(long customercellphone) {
		this.customercellphone = customercellphone;
	}	
	
}
