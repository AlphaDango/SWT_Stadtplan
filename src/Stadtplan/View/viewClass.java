package Stadtplan.View;



import java.util.Scanner;

public class viewClass {
	
		/*public static Database db = new Database();
		public static StreetNetwork n = new StreetNetwork(db.streets);
		public static  Scanner myObj = new Scanner(System.in);  // Create a Scanner object


	public static void main(String[] args) {
		
		
//
//		
//		n.addUnfall(db.streets.get(0),false);
//		n.addUnfall(db.streets.get(1),true);


			intro();
			
		       
		        
		    

	}

	public static void intro() {
		
		

		System.out.println("Welcome to StadtPlan, kindly choose an option");
		System.out.println("1) View All Streets");
		System.out.println("2) View All Knoten");
		System.out.println("3) Add Unfall");
		System.out.println("4) View Street Network Status");
		
		 int option = myObj.nextInt();  // Read user input

	        // switch statement with int data type 
	        switch (option) { 
	        case 1: 

	        	System.out.println("Streets are "+ n.getStreetNames());
	        	System.out.println();
	   		 	intro();

	        	break; 
	        case 2: 

	        	n.getKnots().forEach(item -> System.out.println(item.getUniqueID()+" "));
	        	System.out.println();
	        	
	   		 	intro();

	        	break; 
	        case 3: 
	        	addUnfall();
	        	System.out.println();

	        	break; 
	        case 4: 

	        	n.networkStatus();
	        	System.out.println();
	   		 	intro();
	        	break; 

	        default: 
	            break; 
	        } 
	        
		
	}

	public static void addUnfall() {
		
		

		System.out.println("In Which Street?");
		System.out.println("1)" + n.getStreetNames().get(0));
		System.out.println("2)" + n.getStreetNames().get(1));
		System.out.println("3)" + n.getStreetNames().get(2));

		int option = myObj.nextInt();
		
		System.out.println("is it Secured?");
		System.out.println("1) No" );
		System.out.println("2) Yes" );
		int option2 = myObj.nextInt();
		boolean isSecured = false;
		if(option2 == 2) {
			isSecured = true;
		}
		
		 switch (option) { 
	        case 1: 

	        	n.addUnfall(db.streets.get(0), isSecured);;
	        	break; 
	        case 2: 

	        	n.addUnfall(db.streets.get(1), isSecured);;
	        	break; 

	        default: 
	            break; 
	        } 
	        
		 System.out.println("Unfall added successfully!");
		 intro();

		
	}*/

}
