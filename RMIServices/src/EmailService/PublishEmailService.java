package EmailService;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class PublishEmailService {
	public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException {
		EmailService  emailexample=new EmailService();
		
		LocateRegistry.createRegistry(5000);
		
		System.out.println("Email service deployed....");
		Naming.bind("rmi://localhost:5000/rmiService/emailservice", emailexample);
	}
}
