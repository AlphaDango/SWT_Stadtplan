package Stadtplan.Model;

import java.util.ArrayList;
import java.util.UUID;

public class StrassenAbschnitt {

	private String name;
	private Verkehrsstoerung verkehrsstoerung;
	private ArrayList<Knoten> knots;
	private String uniqueID;
	private  boolean isOneWay;

	
	public StrassenAbschnitt(String name, ArrayList<Knoten> knots,boolean isOneWay) {
		
		this.setName(name);
		this.knots = knots;
		this.setOneWay(isOneWay);
		this.setUniqueID(UUID.randomUUID().toString());


	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public void setVerkehrsstoerung(Verkehrsstoerung verkehrsstoerung){
		this.verkehrsstoerung = verkehrsstoerung;
	}


	public boolean isOneWay() {
		return isOneWay;
	}


	public void setOneWay(boolean isOneWay) {
		this.isOneWay = isOneWay;
	}


	public String getUniqueID() {
		return uniqueID;
	}


	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}


	public ArrayList<Knoten> getKnots() {
		return this.knots;
	}


	public void setKnots(ArrayList<Knoten> knots) {
		this.knots = knots;
	}
	

	
	

}
