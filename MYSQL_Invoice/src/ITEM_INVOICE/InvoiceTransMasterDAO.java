package ITEM_INVOICE;

import java.util.List;

interface InvoiceTransMasterDAO {
	public InvoiceTransDTO findByID(Integer itemid);
	public List<InvoiceTransDTO> findAll();
	public int insertItem(InvoiceTransDTO invoiceDTO);
	public int updateItem(InvoiceTransDTO invoiceDTO);
	public int deleteItemByID(Integer itemid);
	public int deleteItemByDTO(InvoiceTransDTO invoiceDTO);
}
