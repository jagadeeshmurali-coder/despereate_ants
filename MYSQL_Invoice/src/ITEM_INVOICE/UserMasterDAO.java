package ITEM_INVOICE;

import java.util.List;

interface UserMasterDAO {
	public UserDTO findByID(Integer itemid);
	public List<UserDTO> findAll();
	public int insertItem(UserDTO customerDTO);
	public int updateItem(UserDTO customerDTO);
	public int deleteItemByID(Integer itemid);
	public int deleteItemByDTO(UserDTO customerDTO);
}
