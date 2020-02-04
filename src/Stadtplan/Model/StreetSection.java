package Stadtplan.Model;

import java.util.ArrayList;

/*
* The StreetSection class.
* Streetname, connected nodes, roadtype and the momentarry traffic accident
* are safed in instances of this class.
 */
public class StreetSection {

	private String name;
	private TrafficAccident trafficAccident;
	private ArrayList<Node> nodes;
	private boolean isOneWay;

	public StreetSection(String name, ArrayList<Node> nodes, boolean isOneWay) {
		
		setName(name);
		setOneWay(isOneWay);
		this.nodes = nodes;
	}

	/*
	* Just basic setter and getter methods.
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTrafficAccident(TrafficAccident trafficAccident){
		this.trafficAccident = trafficAccident;
	}

	public TrafficAccident getTrafficAccident(){
		return trafficAccident;
	}

	public boolean isOneWay() {
		return isOneWay;
	}

	public void setOneWay(boolean isOneWay) {
		this.isOneWay = isOneWay;
	}

	public ArrayList<Node> getNodes() {
		return this.nodes;
	}

	public void setNodes(ArrayList<Node> nodes) {
		this.nodes = nodes;
	}
}