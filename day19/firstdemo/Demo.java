package hit.day19.firstdemo;

import malik.MoleculeFramework;

public class Demo {
	public static void main(String[] args) {
		Object shoiab=new Human();
		Object reshmi=new Human();
		
		AlopathyMedicalCollege amc=new AlopathyMedicalCollege();
		UnaniMedicalCollege umc=new UnaniMedicalCollege();
		
		if(shoiab instanceof Doctor) {
			System.out.println("shoiab is a doctor...");
		}
		else {
			System.out.println("shoiab is not a doctor...");
		}
		
		//link or subject shoiab to medical college
		MoleculeFramework.setInterface(Doctor.class);
		Doctor doctorShoiab=(Doctor)MoleculeFramework.getObject(new Object[] {shoiab,umc});
		
		if(doctorShoiab instanceof Doctor) {
			System.out.println("shoiab is now a doctor...");
		}
		else {
			System.out.println("shoiab is not a doctor........");
		}
		
		doctorShoiab.doCure();
		
		HaarisInfotech goldenTouch=new HaarisInfotech();
		
		MoleculeFramework.setInterface(Programmer.class);
		Programmer programmerShoiab=(Programmer)MoleculeFramework.getObject(new Object[] {doctorShoiab,goldenTouch});
		
		programmerShoiab.doProgramming();
		
		Doctor docSho=(Doctor)programmerShoiab;
		docSho.doCure();
		
		MoleculeFramework.setInterface(Nurse.class);
		Nurse nurseReshmi=(Nurse)MoleculeFramework.getObject(new Object[] {reshmi,amc});
		
		nurseReshmi.doCare();
	}
}
