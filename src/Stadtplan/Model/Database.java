package Stadtplan.Model;

import java.util.ArrayList;

public class Database {


	public static ArrayList<StrassenAbschnitt> streets = new ArrayList<StrassenAbschnitt>();

	public Database() {
		
		
		ArrayList<Knoten> knots0121 = new ArrayList<Knoten>();
		knots0121.add(new Knoten(0,1));
		knots0121.add(new Knoten(2,1));
		streets.add(new StrassenAbschnitt("Hagenweg",knots0121,false));
		


		ArrayList<Knoten> knots0222k = new ArrayList<Knoten>();
		knots0222k.add(new Knoten(2,1));
		knots0222k.add(new Knoten(2,4));
		streets.add(new StrassenAbschnitt("Breites Tor",knots0222k,false));
		
		
		ArrayList<Knoten> knots0222 = new ArrayList<Knoten>();
		knots0222.add(new Knoten(2,2));
		knots0222.add(new Knoten(4,1));
		streets.add(new StrassenAbschnitt("Bahnhofstrasse",knots0222,false));
		
		
	}
	
	public void addKnoten() {
		
		
	}

	
	public void addStreet() {
		
		
	}

}
