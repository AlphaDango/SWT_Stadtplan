package Stadtplan.Model;

import java.util.ArrayList;

/*
*Class to get some data to work with.
 */
public class Database {

	public static ArrayList<StrassenAbschnitt> streets = new ArrayList<>();

	public Database() {
		ArrayList<Knoten> nodes0121 = new ArrayList<>();
		nodes0121.add(new Knoten(0,1));
		nodes0121.add(new Knoten(2,1));
		streets.add(new StrassenAbschnitt("Hagenweg",nodes0121,false));

		ArrayList<Knoten> nodes2124 = new ArrayList<>();
		nodes2124.add(new Knoten(2,1));
		nodes2124.add(new Knoten(2,4));
		streets.add(new StrassenAbschnitt("Breites Tor",nodes2124,false));

		ArrayList<Knoten> nodes2241 = new ArrayList<>();
		nodes2241.add(new Knoten(2,2));
		nodes2241.add(new Knoten(4,1));
		streets.add(new StrassenAbschnitt("Frankenberger Str.",nodes2241,true));
	}
}