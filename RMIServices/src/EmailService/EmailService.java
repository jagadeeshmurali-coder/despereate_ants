package EmailService;

import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Node;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class EmailService extends UnicastRemoteObject implements RMIEmailService,Serializable{

	protected EmailService() throws RemoteException {
		System.out.println("Hello from email service");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sendEmail() throws RemoteException,ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Sending email");
String to="mahadevan98sekar@gmail.com";
		
		String from="abc@gmail.com";
		
		String host="8080";
		
		final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		
		Properties properties = System.getProperties();
		
		properties.setProperty("mail.smtp.host", "smtp.gmail.com");
		properties.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
		properties.setProperty("mail.smtp.socketFactory.fallback", "false");
		properties.setProperty("mail.smtp.port", "465");
		properties.setProperty("mail.smtp.socketFactory.port", "465");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.debug", "true");
		properties.put("mail.store.protocol", "pop3");
		properties.put("mail.transport.protocol", "smtp");
		final String username = null;//
		final String password = null;
		
	    Session session = Session.getDefaultInstance(properties, 
                new Authenticator(){
                   protected PasswordAuthentication getPasswordAuthentication() {
                      return new PasswordAuthentication(username,password);
                   }});
	    DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		dbf.setIgnoringElementContentWhitespace(true);//you should set validation to true
		DocumentBuilder db=dbf.newDocumentBuilder();
		Document doc=db.parse("email.xml");
		Node n = doc.getDocumentElement();
		String subject = "";
		String messageBody = "";
		NodeList list = n.getChildNodes();
		System.out.println(n.hasChildNodes());
		System.out.println(n.getNodeName());
		for(int i=0;i<list.getLength();i++) {
			if(list.item(i).getNodeName().equalsIgnoreCase("subject")) {
				System.out.println("Hello there");
				subject = list.item(i).getTextContent();
			}
			if(list.item(i).getNodeName().equalsIgnoreCase("body")) {
				messageBody = list.item(i).getTextContent();
			}
		}
		System.out.println(subject);
		System.out.println(messageBody);
		try {
			 MimeMessage message = new MimeMessage(session);
			 message.setFrom(new InternetAddress(from));
			 message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			 message.setSubject(subject);
			 message.setText(messageBody);
			 Transport.send(message);
	         System.out.println("Sent message successfully....");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static Node getAllNodes(NodeList nodeList,String name) {
		for(int i = 0;i<nodeList.getLength();i++) {
			if(nodeList.item(i).hasChildNodes()) {
				if(nodeList.item(i).getNodeName().equalsIgnoreCase(name)) {
					return nodeList.item(i);
				}else {
					getAllNodes(nodeList.item(i).getChildNodes(),name);
				}
			}else {
				if(nodeList.item(i).getNodeName().equalsIgnoreCase(name)) {
					return nodeList.item(i);
				}
			}
		}
		
		return null;
	}
}

class MyProcessingHandler extends DefaultHandler{
	@Override
	public void startDocument() throws SAXException {
		System.out.println("parsing started....");
	}
	@Override
	public void endDocument() throws SAXException {
		System.out.println("parsing finished....");
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.print("<"+qName+">");
		int length=attributes.getLength();
		for(int i=0;i<length;i++) {
			System.out.print(attributes.getQName(i)+"=\"");
			System.out.print(attributes.getValue(i)+"\"");
		}
	}
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("</"+qName+">");
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String s=new String(ch,start,length);
		System.out.print(s);
	}
	
}