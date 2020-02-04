package Stadtplan.Model;

import java.util.ArrayList;
import java.util.List;

/*
* The StreetNetwork class.
* In here, all the nodes and streets are safed.
* Streetnames are safed in this class aswell.
 */
public class StreetNetwork {
	
	public static ArrayList<Node> nodes = new  ArrayList<>();
	public static ArrayList<StreetSection> streets = new  ArrayList<>();
	private static List<String> streetNames = new ArrayList<>();

	public StreetNetwork(){}

	/*
	* Method to fill an instance of this class with
	* given streets and their nodes.
	 */
	public void setStreets(ArrayList<StreetSection> streets) {
		StreetNetwork.streets = streets;
		for(StreetSection s : StreetNetwork.streets) {

			for(Node k : s.getNodes()) {
				if(!nodes.contains(k)) {
					nodes.add(k);
				}
			}
		}
	}

	/*
	* Method to get the safed street with a given name.
	 */
	public StreetSection getStreetByName(String name){
		for(StreetSection s : getStreets()){
			if(s.getName().equals(name)){
				return s;
			}
		}
		return null;
	}

	/*
	* Getter and setter methods.
	 */
	public ArrayList<Node> getNodes() {
		return nodes;
	}

	public void setNodes(ArrayList<Node> nodes) {
		StreetNetwork.nodes = nodes;
	}

	public ArrayList<StreetSection> getStreets() {
		return streets;
	}
	
	public void addStreet(StreetSection street) {
		streets.add(street);
	}

	/*
	* Getter method to get all street names.
	* Also updates the street names of this class.
	 */
	public List<String> getStreetNames() {
		streets.forEach(street -> {
			if(!streetNames.contains(street.getName())) {
				streetNames.add(street.getName());
			}
		});
		return streetNames;
	}
}