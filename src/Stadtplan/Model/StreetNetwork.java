package Stadtplan.Model;

import java.util.ArrayList;
import java.util.List;

public class StreetNetwork {
	
	public static ArrayList<Knoten> knots = new  ArrayList<>();
	public static ArrayList<Verkehrsstoerung> unfaelle = new ArrayList<>();
	public static ArrayList<StrassenAbschnitt> streets = new  ArrayList<>();
	private static List<String> streetNames = new ArrayList<>();

	public StreetNetwork(){}
	public StreetNetwork(ArrayList<StrassenAbschnitt> streets) {
		setStreets(streets);
		
		for(StrassenAbschnitt s : StreetNetwork.streets) {
						
			for(Knoten k : s.getKnots()) {
				if(!knots.contains(k)) {
					knots.add(k);
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
		StreetNetwork.knots = knots;
	}

	public ArrayList<StrassenAbschnitt> getStreets() {
		return streets;
	}

	public void setStreets(ArrayList<StrassenAbschnitt> streets) {
		StreetNetwork.streets = streets;
	}
	
	public void addStreet(StrassenAbschnitt street) {
		streets.add(street);
	}
	
	public List<String> getStreetNames() {
		 streets.forEach(street -> {
		 	if(!streetNames.contains(street.getName())) {
		 		streetNames.add(street.getName());
			 }
		 });
		 return streetNames;
	}

	public void addUnfall(Unfall unfall){
		unfaelle.add(unfall);
	}
}