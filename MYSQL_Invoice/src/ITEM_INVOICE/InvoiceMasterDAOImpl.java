package ITEM_INVOICE;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class InvoiceMasterDAOImpl implements InvoiceMasterDAO {

	@Override
	public InvoiceDTO findByID(Integer itemid) {
		// TODO Auto-generated method stub
				Connection con = DBUtility.getConnection();
				
				try {
				PreparedStatement ptsmt = con.prepareStatement("select * from invoice where item_id=?");
				
					while(true) {
						ptsmt.setInt(1, itemid);
						ResultSet rst = ptsmt.executeQuery();

						if(rst.next()) {
							InvoiceDTO item = InvoiceDTO.getInvoiceDTO();
							item.setInvoiceid(rst.getInt(1));
							item.setInvdate(rst.getDate(2));
							item.setCustomer_id(rst.getInt(3));
							item.setCustomercellphone(rst.getInt(4));
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
	public List<InvoiceDTO> findAll() {
		// TODO Auto-generated method stub
				Connection con = DBUtility.getConnection();
				try {
					Statement stmt = con.createStatement();
//					PreparedStatement ptsmt = con.prepareStatement("");
					ResultSet rst = stmt.executeQuery("SELECT * from invoice"); 
					
					List<InvoiceDTO> items = new ArrayList<InvoiceDTO>();
					
					while(rst.next()) {
						InvoiceDTO item = extractItemFromResultSet(rst);
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
	public int insertItem(InvoiceDTO invoiceDTO) {
		// TODO Auto-generated method stub
				Connection con = DBUtility.getConnection();
				Savepoint first = null;
				try {
					Statement stmt = con.createStatement();
					
					int invoice_id = invoiceDTO.getInvoiceid();
					Date invoice_date = invoiceDTO.getInvdate();
					int customer_id = invoiceDTO.getCustomer_id();
					long customer_phone_number = invoiceDTO.getCustomercellphone();
					first = con.setSavepoint("first");
					PreparedStatement ptsmt = con.prepareStatement("insert into invoice values(?,?,?,?)");
					ptsmt.setInt(1, invoice_id);
					ptsmt.setDate(2, invoice_date);
					ptsmt.setInt(3, customer_id);
					ptsmt.setFloat(4, customer_phone_number);
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
	public int updateItem(InvoiceDTO invoiceDTO) {
		Connection con = DBUtility.getConnection();
		Savepoint first = null;
		try {
			Statement stmt = con.createStatement();
			int invoice_id = invoiceDTO.getInvoiceid();
			Date invoice_date = invoiceDTO.getInvdate();
			int customer_id = invoiceDTO.getCustomer_id();
			long customer_phone_number = invoiceDTO.getCustomercellphone();
			first = con.setSavepoint("first");
			PreparedStatement ptsmt = con.prepareStatement("UPDATE invoice SET invoice_id=?, invoice_date=?, customer_id=?, customer_phone=? WHERE invoice_id=?");
			ptsmt.setInt(1, invoice_id);
			ptsmt.setDate(2, invoice_date);
			ptsmt.setInt(3, customer_id);
			ptsmt.setFloat(4, customer_phone_number);
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
	public int deleteItemByID(Integer invoiceId) {
		Connection con = DBUtility.getConnection();
		Savepoint first = null;
		try {
			Statement stmt = con.createStatement();
			first = con.setSavepoint("first");
			PreparedStatement ptsmt = con.prepareStatement("DELETE FROM invoice WHERE invoice_id=?");
			ptsmt.setInt(1, invoiceId);
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
	public int deleteItemByDTO(InvoiceDTO invoiceDTO) {
		Connection con = DBUtility.getConnection();	
		Savepoint first = null;
		try {
				PreparedStatement ptsmt = con.prepareStatement("DELETE FROM invoice where invoice_id=? AND invoice_date=? AND customer_id=? and customer_phone=?");
				first = con.setSavepoint("first");
				ptsmt.setInt(1, invoiceDTO.getInvoiceid());
				ptsmt.setDate(2, invoiceDTO.getInvdate());
				ptsmt.setInt(3, invoiceDTO.getCustomer_id());
				ptsmt.setFloat(4, invoiceDTO.getCustomercellphone()); 
				int i = ptsmt.executeUpdate();
				
				DBUtility.closeConnection(null, null);
				return i;
		} catch(Exception e) {
			DBUtility.closeConnection(e, first);
			e.printStackTrace();
		}
		return 0;
	}
	
	private InvoiceDTO extractItemFromResultSet(ResultSet rs) throws SQLException {
		InvoiceDTO item = InvoiceDTO.getInvoiceDTO(); 
	    item.setInvoiceid(rs.getInt(1));
		item.setInvdate(rs.getDate(2));
		item.setCustomer_id(rs.getInt(3));
		item.setCustomercellphone(rs.getInt(4));
	    return item;
	}
	
}
