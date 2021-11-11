package ITEM_INVOICE;

import java.io.Serializable;

public class CustomerDTO implements Cloneable,Serializable {
	private int customer_id;
	private String customer_name;
	private String customer_address;
	private int customer_account_details;
	private int customer_gst_number;
	
	private static CustomerDTO customerDTO;
	synchronized public static CustomerDTO getCustomerDTO() {
		if(customerDTO==null) {
			customerDTO=new CustomerDTO();
		}
		return customerDTO.getCloneCustomerDTO();		
	}
	
	private CustomerDTO getCloneCustomerDTO() {
		try {
			return (CustomerDTO)super.clone();
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
		result = prime * result + Float.floatToIntBits(customer_gst_number);
		result = prime * result + Float.floatToIntBits(customer_account_details);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerDTO other = (CustomerDTO) obj;
		if (!(customer_id == other.customer_id))
			return false;
		if (!(customer_account_details == other.customer_account_details))
			return false;
		if(!(customer_gst_number == other.customer_gst_number))
			return false;
		if(!(customer_name.equals(other.customer_name)))
			return false;
		if(!(customer_address.equals(other.customer_address)))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CustomerDTO [Customer ID =" + customer_id + ",Customer Name =" + customer_name + ", Customer Address ="
				+ customer_address + "Customer Account Details = "+customer_account_details+" Customer GST Number = "+customer_gst_number+"]";
	}

	public int getCustomer_id() {
		return customer_id;
	}
	
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	
	public String getCustomer_name() {
		return customer_name;
	}
	
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	
	public String getCustomer_address() {
		return customer_address;
	}
	
	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}
	
	public int getCustomer_account_details() {
		return customer_account_details;
	}
	
	public void setCustomer_account_details(int customer_account_details) {
		this.customer_account_details = customer_account_details;
	}
	
	public int getCustomer_gst_number() {
		return customer_gst_number;
	}
	
	public void setCustomer_gst_number(int customer_gst_number) {
		this.customer_gst_number = customer_gst_number;
	}
	
	
}
