package in.ashokit.beans;

public class Car {

	private IEngine eng;
	
	//setter injection
//	public void setEng(IEngine eng)
//	{
//		System.out.println("setEng() method call");
//		this.eng=eng;
//	}
	
	
	
	//constructor injection
	public Car(IEngine eng) {
		System.out.println("Car :: Constructor method call");
		this.eng = eng;
	}




	public Car() {
		System.out.println("car :: constructor ");
	}




	public void drive() {
		int status=eng.start();
		if(status >1)
		{
			System.out.println("Engine is Started...");
	
		}
		else {
			System.out.println("Engine Trouble..");
		}
	}
}
