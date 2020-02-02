package Stadtplan.Model;

import java.util.ArrayList;
import java.util.List;

public class StreetNetwork {
	
	public static ArrayList<Knoten> knots = new  ArrayList<Knoten>();
	public static ArrayList<Unfall> unfaelle = new ArrayList<Unfall>();
	public static ArrayList<StrassenAbschnitt> streets = new  ArrayList<StrassenAbschnitt>();
	private static List<String> streetNames = new ArrayList<String>();


	public StreetNetwork(){}
	public StreetNetwork(ArrayList<StrassenAbschnitt> streets) {
		setStreets(streets);
		
		for(StrassenAbschnitt s : this.streets) {
						
			for(Knoten k : s.getKnots()) {
				if(!this.knots.contains(k)) {
					this.knots.add(k);
				}
			}
		}
	}

	public ArrayList<Knoten> getKnots() {
		return knots;
	}

	public void setKnots(ArrayList<Knoten> knots) {
		this.knots = knots;
	}

	public ArrayList<StrassenAbschnitt> getStreets() {
		
		
		return streets;
	}

	public void setStreets(ArrayList<StrassenAbschnitt> streets) {
		this.streets = streets;
	}
	
	public void addStreet(StrassenAbschnitt street) {
		
		this.streets.add(street);
	}
	
	public List<String> getStreetNames() {
		

		 this.streets.forEach(street -> {
			 
			 if(!streetNames.contains(street.getName())) {
		 this.streetNames.add(street.getName());
			 } else {
				 
			 }
		 
		 });
		 
		 return this.streetNames;
		
	}
	
	public void networkStatus() {
		
		if(unfaelle.size() > 0) {
			System.out.print("There is accidents at the following streets: ");
			System.out.println();


		for(Unfall f : unfaelle) {
		
			f.getAffectedStreets();
			System.out.print(" street and the current status is ");

			if(f.isSecured()) {
				System.out.print(" secured");

			} else {
				System.out.print(" NOT secured");

			}

			System.out.println();

		  
		}
		} else {
			
			System.out.print("everything is ok");
			
		}

	}
	
	public void addUnfall(StrassenAbschnitt street,boolean state) {
		
		unfaelle.add(new Unfall(street,state,streets,knots));
	}
}
