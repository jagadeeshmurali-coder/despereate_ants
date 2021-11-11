package hit.day19.seconddemo;

public class Bulb implements OnOff{
	@Override
	public void off() {
		System.out.println("the electricity stops flowing...and filament does not burn...");
	}
	@Override
	public void on() {
		System.out.println("bulb tungsten filament is burned and helium glows the bulb");
	}
}
