package Stadtplan.Model;

import java.util.ArrayList;

public class Unfall {
	
	private StrassenAbschnitt effectedStreet;
	private ArrayList<Knoten> knoten;
	private ArrayList<StrassenAbschnitt> affectedStreets;
	private ArrayList<StrassenAbschnitt> dbStreets;

	private boolean isSecured;

	public Unfall(StrassenAbschnitt effectedStreet, boolean isSecured, ArrayList<StrassenAbschnitt> dbStreets,ArrayList<Knoten> knoten) {
		
		this.setEffectedStreet(effectedStreet);
		this.setSecured(isSecured);
		this.dbStreets = dbStreets;
		this.affectedStreets = new ArrayList<StrassenAbschnitt>();
		this.knoten = knoten;
		
	
	}

	public StrassenAbschnitt getEffectedStreet() {
		return effectedStreet;
	}

	public void setEffectedStreet(StrassenAbschnitt effectedStreet) {
		this.effectedStreet = effectedStreet;
	}

	public boolean isSecured() {
		return isSecured;
	}

	public void setSecured(boolean isSecured) {
		this.isSecured = isSecured;
	}
	
	public void getAffectedStreets() {
		
			
			for(Knoten k : this.knoten) {
				
				for(StrassenAbschnitt s : this.dbStreets) {
					
					for(Knoten ss : s.getKnots()) {
						
						if(ss.getUniqueID().equals(k.getUniqueID()) && !this.affectedStreets.contains(s)) {
								
							this.affectedStreets.add(s);
						}
					}
				
			}
		}
			this.affectedStreets.forEach(street -> System.out.print(street.getName() +" "));

	}

}
