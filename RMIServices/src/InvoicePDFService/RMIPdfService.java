package InvoicePDFService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

import com.itextpdf.text.DocumentException;

public interface RMIPdfService extends Remote {
	public void getPDF() throws RemoteException,IOException, DocumentException, TransformerException,TransformerConfigurationException,FileNotFoundException, com.lowagie.text.DocumentException;
}
