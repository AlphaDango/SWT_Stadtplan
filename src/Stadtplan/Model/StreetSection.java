package Stadtplan.Model;

import Stadtplan.View.Observer;

import java.util.ArrayList;

/*
* The StreetSection class.
* Streetname, connected nodes, roadtype and the momentarry traffic accident
* are safed in instances of this class.
 */
public class StreetSection implements Observable{

	private String name;
	private TrafficAccident trafficAccident;
	private ArrayList<Node> nodes;
	private static ArrayList<Observer> observers;
	private boolean isOneWay;

	public StreetSection(){};
	public StreetSection(String name, ArrayList<Node> nodes, boolean isOneWay) {
		
		setName(name);
		setOneWay(isOneWay);
		this.nodes = nodes;
		observers = new ArrayList<>();
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
		Notify();
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

	@Override
	public void Attach(Observer o) {
		observers.add(o);
	}

	@Override
	public void Detach(Observer o) {
		observers.remove(o);
	}

	@Override
	public void Notify() {
		for(Observer o : observers){
			o.update(this);
		}
	}
}