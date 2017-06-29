import java.util.ArrayList;	

public class Car {
	
	//Create instance of each CarPart subclass
	Engine carEngine = new Engine();					
	FuelTank gasTank = new FuelTank();
	ArrayList<Wheel> tires = new ArrayList<Wheel>();
	
	//Store each tire as a collection
	public Car() {
		tires.add(new Wheel(1));
		tires.add(new Wheel(2));
		tires.add(new Wheel(3));
		tires.add(new Wheel(4));
	}
	
	/*Each time car is ran the different parts of
	  the car receive wear & tear*/
	public void run() {
		carEngine.condition = carEngine.condition - 1;
		gasTank.condition = gasTank.condition - 5;
		tires.get(0).condition = tires.get(0).condition - 1;
		tires.get(1).condition = tires.get(1).condition - 2;
		tires.get(2).condition = tires.get(2).condition - 3;
		tires.get(3).condition = tires.get(3).condition - 4;
	}
	
	/*Calls each car-parts diagnostic report to
	  be displayed at once */
	void carCheckUp() {
		System.out.println("Engine Condition:");
		carEngine.diagnosticReport();
		
		System.out.println("Fuel Tank Condition:");
		gasTank.diagnosticReport();
		
		System.out.println("Tire 1 Condition:");
		tires.get(0).diagnosticReport();
		
		System.out.println("Tire 2 Condition:");
		tires.get(1).diagnosticReport();
		
		System.out.println("Tire 3 Condition:");
		tires.get(2).diagnosticReport();
		
		System.out.println("Tire 4 Condition:");
		tires.get(3).diagnosticReport();
	}
}

/* An abstract class that allows every car-part
   subclass to inherit traits and behaviors */
abstract class CarPart{
	int condition;
	
	void diagnosticReport() {}
}

class Engine extends CarPart{
	//constructor assigns starting condition
	public Engine() {
		condition = 10;
	}
	
	/*diagnostic report gives an idea if maintence
	  is needed*/
	void diagnosticReport() {
		if (condition >= 8) {
			System.out.println("The engine is in excellent condition");
		}
		else if (condition >= 5) {
			System.out.println("The engine is in fair condition");
		}
		else if (condition >= 2){
			System.out.println("The engine needs maintence");
		}
		else {
			System.out.println("The engine needs to be replaced");
		}
	}
	
	//maintence moderately improves condition
	void maintence() {
		condition =+ 2;
	}
	
	//replace restores condition
	void replace() {
		condition = 10;
	}
}

class FuelTank extends CarPart{
	public FuelTank() {
		condition = 10;
	}
	
	void diagnosticReport() {
		if (condition == 10) {
			System.out.println("Your tank is full");
		}
		if (condition == 5) {
			System.out.println("Your tank is half empty");
		}
		if (condition == 0) {
			System.out.println("You are out of gas");
		}
	}
	
	//refill restores condition
	void refill() {
		condition = 10;
	}
}

class Wheel extends CarPart{
	int tireNumber;
	
	public Wheel(int x) {
		condition = 10;
		tireNumber = x;
	}
	
	void diagnosticReport() {
		if (condition >= 8) {
			System.out.println("Your tire is in excellent shape");
		}
		else if (condition >= 5) {
			System.out.println("Your tire is in fair shape");
		}
		else if (condition >= 2) {
			System.out.println("Your tire needs air!");
		}
		else {
			System.out.println("Your tire needs to be replaced");
		}
		
	}
	
	void fillAir() {
		condition =+ 5;
	}
	void replace() {
		condition = 10;
	}
}