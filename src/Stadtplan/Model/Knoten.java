package Stadtplan.Model;

import java.util.ArrayList;
import java.util.UUID;

public class Knoten {

	private double lang;
	private double latit;
	private String uniqueID;
	private ArrayList<Double> position;
	
	public Knoten(double lang,double latit) {
		this.position = new ArrayList<Double>();
		this.setLang(lang);
		this.setLatit(latit);
		this.setUniqueID();
		this.position.add(lang);
		this.position.add(latit);
	
	}
	
	 public ArrayList<Double> getPosition() {
		 
		return this.position;
		
		
	}

	public double getLang() {
		return lang;
	}

	public void setLang(double lang) {
		this.lang = lang;
	}

	public double getLatit() {
		return latit;
	}

	public void setLatit(double latit) {
		this.latit = latit;
	}

	public String getUniqueID() {
		return uniqueID;
	}

	public void setUniqueID() {
		this.uniqueID = "knot"+Double.toString(this.lang)+Double.toString(this.latit);
	}

}

