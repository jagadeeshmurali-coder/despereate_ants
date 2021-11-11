package ITEM_INVOICE;

import java.util.List;

interface CustomerMasterDAO {
	public CustomerDTO findByID(Integer itemid);
	public List<CustomerDTO> findAll();
	public int insertItem(CustomerDTO customerDTO);
	public int updateItem(CustomerDTO customerDTO);
	public int deleteItemByID(Integer itemid);
	public int deleteItemByDTO(CustomerDTO customerDTO);
}
