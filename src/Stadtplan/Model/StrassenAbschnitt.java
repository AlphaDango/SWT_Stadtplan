package Stadtplan.Model;

import java.util.ArrayList;
import java.util.UUID;

public class StrassenAbschnitt {

	private String name;
	private Unfall unfall;
	private ArrayList<Knoten> knots;
	private  boolean isOneWay;

	public StrassenAbschnitt(String name, ArrayList<Knoten> knots,boolean isOneWay) {
		
		this.setName(name);
		this.knots = knots;
		this.setOneWay(isOneWay);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setVerkehrsstoerung(Unfall unfall){
		this.unfall = unfall;
	}

	public Unfall getUnfall(){
		return unfall;
	}

	public boolean isOneWay() {
		return isOneWay;
	}

	public void setOneWay(boolean isOneWay) {
		this.isOneWay = isOneWay;
	}

	public ArrayList<Knoten> getKnots() {
		return this.knots;
	}

	public void setKnots(ArrayList<Knoten> knots) {
		this.knots = knots;
	}
}