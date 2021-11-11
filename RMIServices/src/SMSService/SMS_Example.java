package SMSService;

import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


public class SMS_Example extends UnicastRemoteObject implements SMSRMIService,Serializable {
	  protected SMS_Example() throws RemoteException {
		System.out.println("Hello from SMS");
		// TODO Auto-generated constructor stub
	}

	public static final String ACCOUNT_SID = null;
	  public static final String AUTH_TOKEN = null;
	  
	  public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException {
		  SMS_Example  smsexample=new SMS_Example();
			
			LocateRegistry.createRegistry(3000);
			
			System.out.println("SMS service deployed....");
			Naming.bind("rmi://localhost:3000/rmiService/mobilesms", smsexample);
	  }
	  
	  public void sendSMS()throws RemoteException, ParserConfigurationException, SAXException, IOException {
		  Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		  DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
			dbf.setIgnoringElementContentWhitespace(true);//you should set validation to true
			DocumentBuilder db=dbf.newDocumentBuilder();
			Document doc=db.parse("sms.xml");
			Node messagebody = doc.getDocumentElement();
			NodeList list = messagebody.getChildNodes();
			String fromNumber = null;
			String toNumber = null;
			String messagebody1 = null;
			for(int i=0;i<list.getLength();i++) {
				if(list.item(i).getNodeName().equalsIgnoreCase("fromnumber")) {
					fromNumber = list.item(i).getTextContent();
				}else if(list.item(i).getNodeName().equalsIgnoreCase("tonumber")) {
					toNumber = list.item(i).getTextContent();
				}else if(list.item(i).getNodeName().equalsIgnoreCase("message")) {
					messagebody1 = list.item(i).getTextContent();
				}
			}
			System.out.println("FromNumber"+fromNumber);
			System.out.println("FromNumber"+toNumber);
			System.out.println("FromNumber"+messagebody1);
			Message message = Message.creator(new PhoneNumber(toNumber), new PhoneNumber(fromNumber), messagebody1).create();
			System.out.println(message.getSid());
		  System.out.println("SMS Sent");
	  }
}
