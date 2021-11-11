package InvoicePDFService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.DocumentException;

public class PDFService extends UnicastRemoteObject implements RMIPdfService,Serializable{

	protected PDFService() throws RemoteException {
		// TODO Auto-generated constructor stub
		System.out.println("Hello from PDF");
	}

	@Override
	public void getPDF() throws RemoteException,IOException, DocumentException, TransformerException,TransformerConfigurationException,FileNotFoundException, com.lowagie.text.DocumentException {
		// TODO Auto-generated method stub
		System.out.println("Get PDF Called");
		TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer transformer = tFactory.newTransformer(new StreamSource("invoice.xsl"));
        transformer.transform(new StreamSource("invoice.xml"),new StreamResult(new FileOutputStream("sample.html")));
        String File_To_Convert = "sample.html";
        String url = new File(File_To_Convert).toURI().toURL().toString();
        System.out.println(""+url);
        String HTML_TO_PDF = "ConvertedFile.pdf";
        OutputStream os = new FileOutputStream(HTML_TO_PDF);       
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocument(url);      
        renderer.layout();
        renderer.createPDF(os);        
        os.close();
	}
	
	public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException {
		PDFService  pdfservice=new PDFService();
		
		LocateRegistry.createRegistry(4000);
		
		System.out.println("PDF service deployed....");
		Naming.bind("rmi://localhost:4000/rmiService/pdfservice", pdfservice);
	}

}
