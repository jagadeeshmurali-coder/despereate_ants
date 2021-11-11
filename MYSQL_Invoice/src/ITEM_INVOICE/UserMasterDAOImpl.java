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

public class UserMasterDAOImpl implements UserMasterDAO{

	@Override
	public UserDTO findByID(Integer userid) {
		// TODO Auto-generated method stub
				Connection con = DBUtility.getConnection();
				
				try {
				PreparedStatement ptsmt = con.prepareStatement("select * from USER where user_id=?");
				
					while(true) {
						ptsmt.setInt(1, userid);
						ResultSet rst = ptsmt.executeQuery();

						if(rst.next()) {
							UserDTO item = UserDTO.getUserDTO();
							item.setUserid(rst.getInt(1));
							item.setUsername(rst.getString(2));
							item.setPassword(rst.getString(3));
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
	public List<UserDTO> findAll() {
		// TODO Auto-generated method stub
				Connection con = DBUtility.getConnection();
				try {
					Statement stmt = con.createStatement();
//					PreparedStatement ptsmt = con.prepareStatement("");
					ResultSet rst = stmt.executeQuery("SELECT * from USER"); 
					
					List<UserDTO> items = new ArrayList<UserDTO>();
					
					while(rst.next()) {
						UserDTO item = extractItemFromResultSet(rst);
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
	public int insertItem(UserDTO user) {
		// TODO Auto-generated method stub
		Connection con = DBUtility.getConnection();
		Savepoint first = null;
		try {
			Statement stmt = con.createStatement();
			
			int userId = user.getUserid();
			String username = user.getUsername();
			String password = user.getPassword();
			first = con.setSavepoint("first");
			PreparedStatement ptsmt = con.prepareStatement("insert into USER values(?,?,?)");
			ptsmt.setInt(1, userId);
			ptsmt.setString(2, username);
			ptsmt.setString(3, password);
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
	public int updateItem(UserDTO user) {
		Connection con = DBUtility.getConnection();
		Savepoint first = null;
		try {
			Statement stmt = con.createStatement();
			int userId = user.getUserid();
			String username = user.getUsername();
			String password = user.getPassword();
			first = con.setSavepoint("first");
			PreparedStatement ptsmt = con.prepareStatement("UPDATE USER SET username=?, password=? WHERE user_id=?");
			ptsmt.setString(1, username);
			ptsmt.setString(2, password);
			ptsmt.setInt(3, userId);
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
	public int deleteItemByID(Integer userid) {
		Connection con = DBUtility.getConnection();
		Savepoint first = null;
		try {
			Statement stmt = con.createStatement();
			first = con.setSavepoint("first");
			PreparedStatement ptsmt = con.prepareStatement("DELETE FROM USER WHERE invoice_id=?");
			ptsmt.setInt(1, userid);
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
	public int deleteItemByDTO(UserDTO user) {
		Connection con = DBUtility.getConnection();	
		Savepoint first = null;
		try {
				PreparedStatement ptsmt = con.prepareStatement("DELETE FROM USER where user_id=? AND username=? AND password=?");
				first = con.setSavepoint("first");
				ptsmt.setInt(1, user.getUserid());
				ptsmt.setString(2, user.getUsername());
				ptsmt.setString(3, user.getPassword());
				int i = ptsmt.executeUpdate();
				
				DBUtility.closeConnection(null, null);
				return i;
		} catch(Exception e) {
			DBUtility.closeConnection(e, first);
			e.printStackTrace();
		}
		return 0;
	}
	
	private UserDTO extractItemFromResultSet(ResultSet rs) throws SQLException {
		UserDTO item = UserDTO.getUserDTO();
	    item.setUserid(rs.getInt(1));
	    item.setUsername(rs.getString(2));
	    item.setPassword(rs.getString(3));
	    return item;
	}

}
