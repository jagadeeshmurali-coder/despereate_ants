package SMSService;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public interface SMSRMIService extends Remote {
	public void sendSMS() throws RemoteException,ParserConfigurationException, SAXException, IOException ;
}
