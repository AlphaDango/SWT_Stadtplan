package Stadtplan.Model;

import java.util.ArrayList;
import java.util.List;

public class StreetNetwork {
	
	public static ArrayList<Knoten> knots = new  ArrayList<Knoten>();
	public static ArrayList<Verkehrsstoerung> unfaelle = new ArrayList<Verkehrsstoerung>();
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

	public StrassenAbschnitt getStreetByName(String name){
		for(StrassenAbschnitt s : streets){
			if(s.getName().equals(name)){
				return s;
			}
		}
		return null;
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

	public void addUnfall(Unfall unfall){
		unfaelle.add(unfall);
	}
	
	public void networkStatus() {


	}
}
