package ITEM_INVOICE;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class InvoiceTransMasterDAOImpl implements InvoiceTransMasterDAO {

	@Override
	public InvoiceTransDTO findByID(Integer invoiceid) {
		// TODO Auto-generated method stub
		Connection con = DBUtility.getConnection();
		
		try {
		PreparedStatement ptsmt = con.prepareStatement("select * from INVOICETRANS where invoice_id=?");
		
			while(true) {
				ptsmt.setInt(1, invoiceid);
				ResultSet rst = ptsmt.executeQuery();

				if(rst.next()) {
					InvoiceTransDTO item = InvoiceTransDTO.getInvoiceTransDTO();
					item.setInvoice_id(rst.getInt(1));
					item.setItem_id(rst.getInt(2));
					item.setQuantity(rst.getInt(3));
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
	public List<InvoiceTransDTO> findAll() {
		// TODO Auto-generated method stub
		Connection con = DBUtility.getConnection();
		try {
			Statement stmt = con.createStatement();
//			PreparedStatement ptsmt = con.prepareStatement("");
			ResultSet rst = stmt.executeQuery("SELECT * from INVOICETRANS"); 
			
			List<InvoiceTransDTO> items = new ArrayList<InvoiceTransDTO>();
			
			while(rst.next()) {
				InvoiceTransDTO item = extractItemFromResultSet(rst);
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
	public int deleteItemByID(Integer invoiceId) {
		Connection con = DBUtility.getConnection();
		Savepoint first = null;
		try {
			Statement stmt = con.createStatement();
			first = con.setSavepoint("first");
			PreparedStatement ptsmt = con.prepareStatement("DELETE FROM INVOICETRANS WHERE invoice_id=?");
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
	public int insertItem(InvoiceTransDTO invoiceDTO) {
		// TODO Auto-generated method stub
		Connection con = DBUtility.getConnection();
		Savepoint first = null;
		try {
			Statement stmt = con.createStatement();
			
			int invoice_id = invoiceDTO.getInvoice_id();
			int item_id = invoiceDTO.getItem_id();
			int quantity = invoiceDTO.getQuantity();
			first = con.setSavepoint("first");
			PreparedStatement ptsmt = con.prepareStatement("insert into INVOICETRANS values(?,?,?)");
			ptsmt.setInt(1, invoice_id);
			ptsmt.setInt(2, item_id);
			ptsmt.setInt(3, quantity);
			int i = ptsmt.executeUpdate();
//			int i = stmt.executeUpdate("insert into users values(2,'somu','spider',0)");
			DBUtility.closeConnection(null, null);
			return i;
		}catch(Exception e) {
			DBUtility.closeConnection(e, first);
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateItem(InvoiceTransDTO invoiceDTO) {
		Connection con = DBUtility.getConnection();
		Savepoint first = null;
		try {
			Statement stmt = con.createStatement();
			int invoice_id = invoiceDTO.getInvoice_id();
			int item_id = invoiceDTO.getItem_id();
			int quantity = invoiceDTO.getQuantity();
			first = con.setSavepoint("first");
			PreparedStatement ptsmt = con.prepareStatement("UPDATE INVOICETRANS SET item_id=?, quantity=? WHERE invoice_id=?");
			ptsmt.setInt(1, invoice_id);
			ptsmt.setInt(2, item_id);
			ptsmt.setInt(3, quantity);
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
	public int deleteItemByDTO(InvoiceTransDTO invoiceDTO) {
		Connection con = DBUtility.getConnection();	
		Savepoint first = null;
		try {
				PreparedStatement ptsmt = con.prepareStatement("DELETE FROM INVOICETRANS where invoice_id=? AND item_id=? AND quantity=?");
				first = con.setSavepoint("first");
				ptsmt.setInt(1, invoiceDTO.getInvoice_id());
				ptsmt.setInt(2, invoiceDTO.getItem_id());
				ptsmt.setInt(3, invoiceDTO.getQuantity());
				int i = ptsmt.executeUpdate();
				
				DBUtility.closeConnection(null, null);
				return i;
		} catch(Exception e) {
			DBUtility.closeConnection(e, first);
			e.printStackTrace();
		}
		return 0;
	}
	
	private InvoiceTransDTO extractItemFromResultSet(ResultSet rs) throws SQLException {
		InvoiceTransDTO item = InvoiceTransDTO.getInvoiceTransDTO();
	    item.setInvoice_id(rs.getInt(1));
	    item.setItem_id(rs.getInt(2));
	    item.setQuantity(rs.getInt(3));
	    return item;
	}
	

}
