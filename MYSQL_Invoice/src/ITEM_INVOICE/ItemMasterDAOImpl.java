package ITEM_INVOICE;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ItemMasterDAOImpl implements ItemMasterDAO {
	List<ItemDTO> itemDTOList = new ArrayList<ItemDTO>();
	
	@Override
	public ItemDTO findByID(Integer itemid) {
		// TODO Auto-generated method stub
		Connection con = DBUtility.getConnection();
		
		try {
		PreparedStatement ptsmt = con.prepareStatement("select * from itemMaster where item_id=?");
		
			while(true) {
				ptsmt.setInt(1, itemid);
				ResultSet rst = ptsmt.executeQuery();

				if(rst.next()) {
					ItemDTO item = ItemDTO.getItemDTO(); 
					item.setItemid(rst.getInt(1));
					item.setItem_name(rst.getString(2));
					item.setPrice(rst.getFloat(3));

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
	public List<ItemDTO> findAll() {
		// TODO Auto-generated method stub
		Connection con = DBUtility.getConnection();
		try {
			Statement stmt = con.createStatement();
//			PreparedStatement ptsmt = con.prepareStatement("");
			ResultSet rst = stmt.executeQuery("SELECT * from ItemMaster"); 
			
			List<ItemDTO> items = new ArrayList<ItemDTO>();
			
			while(rst.next()) {
				ItemDTO item = extractItemFromResultSet(rst);
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
	public int insertItem(ItemDTO itemDTO) {
		// TODO Auto-generated method stub
		Connection con = DBUtility.getConnection();
		Savepoint first = null;
		try {
			Statement stmt = con.createStatement();
			
			int item_id = itemDTO.getItemid();
			String item_name = itemDTO.getItem_name();
			String unit = itemDTO.getItem_unit();
			float price = itemDTO.getPrice();
			first = con.setSavepoint("first");
			PreparedStatement ptsmt = con.prepareStatement("insert into itemMaster values(?,?,?,0)");
			ptsmt.setInt(1, item_id);
			ptsmt.setString(2, item_name);
			ptsmt.setFloat(3, price);
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
	public int updateItem(ItemDTO itemDTO) {
		// TODO Auto-generated method stub
		Connection con = DBUtility.getConnection();
		Savepoint first = null;
		try {
			Statement stmt = con.createStatement();
			String item_name = itemDTO.getItem_name();
			String unit = itemDTO.getItem_unit();
			float price = itemDTO.getPrice();
			first = con.setSavepoint("first");
			PreparedStatement ptsmt = con.prepareStatement("UPDATE itemMaster SET item_desc=?, price=? WHERE item_id=?");
			ptsmt.setString(1, item_name);
			ptsmt.setFloat(2, price);
			ptsmt.setInt(3, itemDTO.getItemid());
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
	public int deleteItemByID(Integer itemid) {
		Connection con = DBUtility.getConnection();
		Savepoint first = null;
		try {
			Statement stmt = con.createStatement();
			first = con.setSavepoint("first");
			PreparedStatement ptsmt = con.prepareStatement("DELETE FROM itemMaster WHERE item_id=?");
			ptsmt.setInt(1, itemid);
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
	public int deleteItemByDTO(ItemDTO itemDTO) {
		Connection con = DBUtility.getConnection();	
		
		try {
				PreparedStatement ptsmt = con.prepareStatement("DELETE FROM itemMaster where item_id=? AND item_desc=? AND price=? ");
		
				ptsmt.setInt(1, itemDTO.getItemid());
				ptsmt.setString(2, itemDTO.getItem_name());
				ptsmt.setFloat(3, itemDTO.getPrice());
				int i = ptsmt.executeUpdate();
				
				DBUtility.closeConnection(null, null);
				return i;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	private ItemDTO extractItemFromResultSet(ResultSet rs) throws SQLException {
	    ItemDTO item = ItemDTO.getItemDTO(); 
	    item.setItemid(rs.getInt(1));
	    item.setItem_name(rs.getString(2));
	    item.setPrice(rs.getFloat(3));
	    return item;
	}
	
	public static void main(String[] args) {
		ItemMasterDAOImpl itemMaster = new ItemMasterDAOImpl();
		ItemDTO item = ItemDTO.getItemDTO();
		item.setItem_name("newName");
		item.setItemid(121212);
		item.setPrice(5000);
		itemMaster.insertItem(item);
		List<ItemDTO> items = itemMaster.findAll();
		for(ItemDTO itemdto:items) {
			System.out.println(itemdto.getItem_name());
		}
		itemMaster.deleteItemByDTO(item);
		for(ItemDTO itemdto:items) {
			System.out.println(itemdto.getItem_name());
		}
	}

}
