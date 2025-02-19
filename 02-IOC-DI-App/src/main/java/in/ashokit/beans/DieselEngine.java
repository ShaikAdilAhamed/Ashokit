package in.ashokit.beans;

public class DieselEngine implements IEngine{
	
	
	public DieselEngine() {
		System.out.println("diesel engine :: constructor ");
	}

	public int start() {
		System.out.println("Diesel Engine Started...");
		return 1;
	}
}
