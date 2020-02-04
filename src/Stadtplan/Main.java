package Stadtplan;

import Stadtplan.Model.Node;
import Stadtplan.Model.StreetSection;
import Stadtplan.Model.StreetNetwork;
import Stadtplan.View.WelcomeView;

import java.util.ArrayList;

/*
* The Programms Main Class
 */
public class Main {

    public static ArrayList<StreetSection> streets = new ArrayList<>();
    public static StreetNetwork streetNetwork = new StreetNetwork();

    /*
    * Method to fill the Model with Data to use.
     */
    public static void fillData(){
        ArrayList<Node> nodes0121 = new ArrayList<>();
        nodes0121.add(new Node(0,1));
        nodes0121.add(new Node(2,1));
        streets.add(new StreetSection("Hagenweg",nodes0121,false));

        ArrayList<Node> nodes2124 = new ArrayList<>();
        nodes2124.add(new Node(2,1));
        nodes2124.add(new Node(2,4));
        streets.add(new StreetSection("Breites Tor",nodes2124,false));

        ArrayList<Node> nodes2241 = new ArrayList<>();
        nodes2241.add(new Node(2,2));
        nodes2241.add(new Node(4,1));
        streets.add(new StreetSection("Frankenberger Str.",nodes2241,true));

        streetNetwork.setStreets(streets);
    }

    /*
    * Main method to start the programm.
     */
    public static void main(String[] args) {
        fillData();
        new WelcomeView();
    }

}