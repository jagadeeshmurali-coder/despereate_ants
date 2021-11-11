package ITEM_INVOICE;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerMasterDAOImpl implements CustomerMasterDAO {

	@Override
	public CustomerDTO findByID(Integer customerid) {
		// TODO Auto-generated method stub
		Connection con = DBUtility.getConnection();
		
		try {
		PreparedStatement ptsmt = con.prepareStatement("select * from CUSTOMER where customer_id=?");
		
			while(true) {
				ptsmt.setInt(1, customerid);
				ResultSet rst = ptsmt.executeQuery();

				if(rst.next()) {
					CustomerDTO item = CustomerDTO.getCustomerDTO();
					item.setCustomer_id(rst.getInt(1));
					item.setCustomer_name(rst.getString(2));
					item.setCustomer_address(rst.getString(3));
					item.setCustomer_account_details(rst.getInt(4));
					item.setCustomer_gst_number(rst.getInt(5));
					return item;
				}
				
				DBUtility.closeConnection(null, null);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CustomerDTO> findAll() {
		// TODO Auto-generated method stub
		Connection con = DBUtility.getConnection();
		try {
			Statement stmt = con.createStatement();
//			PreparedStatement ptsmt = con.prepareStatement("");
			ResultSet rst = stmt.executeQuery("SELECT * from CUSTOMER"); 
			
			List<CustomerDTO> items = new ArrayList<CustomerDTO>();
			
			while(rst.next()) {
				CustomerDTO item = extractItemFromResultSet(rst);
				items.add(item);
			}
			DBUtility.closeConnection(null, null);
			return items;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public int insertItem(CustomerDTO customer) {
		// TODO Auto-generated method stub
				Connection con = DBUtility.getConnection();
				Savepoint first = null;
				try {
					Statement stmt = con.createStatement();
					
					int customer_id = customer.getCustomer_id();
					String customer_name = customer.getCustomer_name();
					String customer_address = customer.getCustomer_address();
					int customer_acc = customer.getCustomer_account_details();
					int customer_gst = customer.getCustomer_gst_number();
					first = con.setSavepoint("first");
					PreparedStatement ptsmt = con.prepareStatement("insert into CUSTOMER values(?,?,?,?,?)");
					ptsmt.setInt(1, customer_id);
					ptsmt.setString(2, customer_name);
					ptsmt.setString(3, customer_address);
					ptsmt.setInt(4, customer_acc);
					ptsmt.setInt(5, customer_gst);
					int i = ptsmt.executeUpdate();
//					int i = stmt.executeUpdate("insert into users values(2,'somu','spider',0)");
					DBUtility.closeConnection(null, null);
					return i;
				}catch(Exception e) {
					DBUtility.closeConnection(e, first);
					e.printStackTrace();
				}
				return 0;
	}

	@Override
	public int updateItem(CustomerDTO customer) {
		Connection con = DBUtility.getConnection();
		Savepoint first = null;
		try {
			Statement stmt = con.createStatement();
			int customer_id = customer.getCustomer_id();
			String customer_name = customer.getCustomer_name();
			String customer_address = customer.getCustomer_address();
			int customer_acc_details = customer.getCustomer_account_details();
			int customer_gst = customer.getCustomer_gst_number();
			first = con.setSavepoint("first");
			PreparedStatement ptsmt = con.prepareStatement("UPDATE USER SET customer_name=?, customer_address=?, customer_acc_details=?, customer_gst_number=? WHERE customer_id=?");
			ptsmt.setString(1, customer_name);
			ptsmt.setString(2, customer_address);
			ptsmt.setInt(3, customer_acc_details);
			ptsmt.setInt(4, customer_gst);
			ptsmt.setInt(5, customer_id);
			int i = ptsmt.executeUpdate();
			DBUtility.closeConnection(null, null);
			return i;
		}catch(Exception e) {
			DBUtility.closeConnection(e, first);
			e.printStackTrace();
		}
		
		
		return 0;
	}

	@Override
	public int deleteItemByID(Integer custId) {
		Connection con = DBUtility.getConnection();
		Savepoint first = null;
		try {
			Statement stmt = con.createStatement();
			first = con.setSavepoint("first");
			PreparedStatement ptsmt = con.prepareStatement("DELETE FROM CUSTOMER WHERE customer_id=?");
			ptsmt.setInt(1, custId);
			int i = ptsmt.executeUpdate();
			DBUtility.closeConnection(null, null);
			return i;
		}catch(Exception e) {
			DBUtility.closeConnection(e, first);
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteItemByDTO(CustomerDTO customer) {
		Connection con = DBUtility.getConnection();	
		Savepoint first = null;
		try {
				PreparedStatement ptsmt = con.prepareStatement("DELETE FROM CUSTOMER where customer_id=? AND customer_name=? AND customer_address=? AND customer_acc_details=? AND customer_gst_number=?");
				first = con.setSavepoint("first");
				ptsmt.setInt(1, customer.getCustomer_id());
				ptsmt.setString(2, customer.getCustomer_name());
				ptsmt.setString(3, customer.getCustomer_address());
				ptsmt.setInt(4, customer.getCustomer_account_details());
				ptsmt.setInt(5, customer.getCustomer_gst_number());
				int i = ptsmt.executeUpdate();
				
				DBUtility.closeConnection(null, null);
				return i;
		} catch(Exception e) {
			DBUtility.closeConnection(e, first);
			e.printStackTrace();
		}
		return 0;
	}
	
	private CustomerDTO extractItemFromResultSet(ResultSet rs) throws SQLException {
		CustomerDTO item = CustomerDTO.getCustomerDTO();
		item.setCustomer_id(rs.getInt(1));
		item.setCustomer_name(rs.getString(2));
		item.setCustomer_address(rs.getString(3));
		item.setCustomer_account_details(rs.getInt(4));
		item.setCustomer_gst_number(rs.getInt(5));
	    return item;
	}
	
	public static void main(String[] args) {
		CustomerMasterDAOImpl customerMaster = new CustomerMasterDAOImpl();
		CustomerDTO customer = new CustomerDTO();
		customer.setCustomer_account_details(121212121);
		customer.setCustomer_gst_number(1121212);
		customer.setCustomer_address("Chennai, T.Nagar, India");
		customer.setCustomer_name("newname");
		customer.setCustomer_id(111111);
		customerMaster.insertItem(customer);
	}

}
