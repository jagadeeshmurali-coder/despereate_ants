package RMIService;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class TestRMIService extends UnicastRemoteObject implements TestRMI,Serializable{
	protected TestRMIService() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void start() throws RemoteException {
		System.out.println("Rmi Service Started");
	}
	
	public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException {
		TestRMIService telco=new TestRMIService();
		
		LocateRegistry.createRegistry(6060);
		
		System.out.println("RMI service deployed....");
		Naming.bind("rmi://localhost:6060/rmiService/testrmi", telco);
	}

	
}
