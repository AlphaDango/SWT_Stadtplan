package Stadtplan;

import Stadtplan.Model.Knoten;
import Stadtplan.Model.StrassenAbschnitt;
import Stadtplan.Model.StreetNetwork;
import Stadtplan.View.WelcomeView;

import java.util.ArrayList;

public class Main {

    public static ArrayList<StrassenAbschnitt> streets = new ArrayList<>();
    public static StreetNetwork streetNetwork = new StreetNetwork();

    public static void fillData(){
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

        streetNetwork.setStreets(streets);
    }

    public static void main(String[] args) {
        fillData();
        new WelcomeView();
    }

}