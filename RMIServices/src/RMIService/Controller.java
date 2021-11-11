package RMIService;

import java.io.FileInputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Enumeration;
import java.util.Properties;

public class Controller extends UnicastRemoteObject implements ControllerInt,Serializable {
	
	protected Controller() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException {
		Controller controller=new Controller();
		
		LocateRegistry.createRegistry(6000);
		
		System.out.println("Controller service deployed....");
		Naming.bind("rmi://localhost:6000/rmiService/controller", controller);
	}

	public Object getTelecomAppObject(TestRMI testRmi)throws RemoteException {
		int count=0;
		if(testRmi==null) {
			testRmi=new TestRMIService();
		}
		try {
			Properties prop=new Properties();
			prop.load(new FileInputStream("service-config.properties"));
			Enumeration counten=prop.elements();
			int noofservices=0;
			while(counten.hasMoreElements()) {
				noofservices=noofservices+1;
				System.out.println(counten.nextElement());
			}
			System.out.println("No of services...:"+noofservices);
			Class c[]=new Class[noofservices];
			Object o[]=new Object[noofservices];
			Enumeration en=prop.elements();
			while(en.hasMoreElements()) {
				String serviceConfigFile=(String)en.nextElement();
				System.out.println("service files...:"+serviceConfigFile);
				Properties servicesProp=new Properties();
				servicesProp.load(new FileInputStream(serviceConfigFile));
				String urlstr=servicesProp.getProperty("url");
				String interfacename=servicesProp.getProperty("interfacename");
				o[count]=Naming.lookup(urlstr);	
				c[count]=Class.forName(interfacename);
				//list.add(Class.forName(interfacename));
				//list.add(interfacename);
				++count;
				}
			
			Object obj=Proxy.newProxyInstance(testRmi.getClass().getClassLoader(), 
					c,new MyInvocationHandler(o));
			//System.out.println("The object...:"+obj);
			return obj;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
class MyInvocationHandler implements InvocationHandler,Serializable{
	Object obj[];
	public MyInvocationHandler(Object obj[]) {
		this.obj=obj;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object ret=null;
		System.out.println("Inside Invoke");
		for(Object o:obj) {
			if(o!=null) {
			Method m[]=o.getClass().getDeclaredMethods();
			for(Method mm:m) {
				System.out.println(mm.getName());
				mm.setAccessible(true);
			}
			try {
				System.out.println("method invoked...");
				ret=method.invoke(o, args);
			}catch(Exception e) {
				//e.printStackTrace();
			}
			}
		}
		return ret;
	}
}