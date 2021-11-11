package RMIService;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ControllerInt extends Remote {
	public Object getTelecomAppObject(TestRMI testRMI)throws RemoteException;
}
