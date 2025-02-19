package in.ashokit.beans;

public class Main {

	public static void main(String[] args) {
		Car c= new Car();
		c.setEng(new PetrolEngine());
		c.drive();

	}

}
