package ITEM_INVOICE;

import java.util.List;

interface InvoiceMasterDAO {
	public InvoiceDTO findByID(Integer itemid);
	public List<InvoiceDTO> findAll();
	public int insertItem(InvoiceDTO invoiceDTO);
	public int updateItem(InvoiceDTO invoiceDTO);
	public int deleteItemByID(Integer itemid);
	public int deleteItemByDTO(InvoiceDTO invoiceDTO);
}
