package hit.day19.seconddemo;

import malik.MoleculeFramework;

public class Demo {
	public static void main(String[] args) {
		Object anchor=new Switch();
		
		Bulb philips=new Bulb();
		Ac samsung=new Ac();
		
		MoleculeFramework.setInterface(OnOff.class);
		Object obj=MoleculeFramework.getObject(new Object[] {anchor,samsung});
		
		OnOff bulbOnOff=(OnOff)obj;
		bulbOnOff.on();
		bulbOnOff.off();
		
		
		
	}
}
