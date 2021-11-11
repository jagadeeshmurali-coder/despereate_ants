package testpack;

import java.rmi.Naming;

import EmailService.RMIEmailService;
import InvoicePDFService.RMIPdfService;
import RMIService.ControllerInt;
import RMIService.TestRMI;
import SMSService.SMSRMIService;


public class Test {
	public static void main(String[] args)throws Exception {
		
		ControllerInt controller = (ControllerInt)Naming.lookup("rmi://localhost:6000/rmiService/controller");
		
//		Telco telco=new Telco();
		
		TestRMI testRmiService = (TestRMI)Naming.lookup("rmi://localhost:6060/rmiService/testrmi");
		Object obj=controller.getTelecomAppObject(testRmiService);
		
		RMIPdfService rmiPdfService = (RMIPdfService)obj;
		System.out.println(rmiPdfService);
		rmiPdfService.getPDF();
		
		RMIEmailService rmiEmailService = (RMIEmailService)obj;
		System.out.println(rmiEmailService);
		rmiEmailService.sendEmail();
		
		SMSRMIService smsService = (SMSRMIService)obj;
		System.out.println(smsService);
		smsService.sendSMS();
		
//		BillPayment billPay=(BillPayment)obj;
//		billPay.payBill(100);
//	
//		NumberPortability np=(NumberPortability)obj;
//		np.portNumber(89898943, "airtel");
//		
//		AddService ads=(AddService)obj;
//		ads.changeAddress(new Address());
	}
}
