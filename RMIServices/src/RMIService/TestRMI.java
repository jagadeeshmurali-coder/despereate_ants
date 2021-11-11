package RMIService;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TestRMI extends Remote {
	public void start() throws RemoteException;
}
