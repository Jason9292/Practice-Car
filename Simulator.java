public class Simulator {
	public static void main(String args[]) {
		Car myRide = new Car();					//create new car object
		
		myRide.carCheckUp();					//display initial condition of everything
		System.out.println();
		
		myRide.run();							//run the car
		
		myRide.carCheckUp();					//checkup on conditions
		System.out.println();;
		
		myRide.run();
		
		myRide.carCheckUp();					//now display shows that reinforcements are needed
		System.out.println();
		
		System.out.println("Filling up tank with gas and giving tires 3 and 4 more air");
		myRide.gasTank.refill();
		myRide.tires.get(2).fillAir();
		myRide.tires.get(3).fillAir();
		
		myRide.carCheckUp();					//show that reinforcements were working
	}
}