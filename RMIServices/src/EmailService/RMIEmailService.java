package EmailService;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public interface RMIEmailService extends Remote {
	public void sendEmail()throws RemoteException, ParserConfigurationException, SAXException, IOException;
}
