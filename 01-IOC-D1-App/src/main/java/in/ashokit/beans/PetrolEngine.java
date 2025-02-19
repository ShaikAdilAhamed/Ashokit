package in.ashokit.beans;

public class PetrolEngine implements IEngine{

	
	
	public PetrolEngine() {
		System.out.println("petrol engine :: constructor ");
	}

	public int start() {
		System.out.println("Petrol Engine Started...");
		return 1;
	}
	

}
