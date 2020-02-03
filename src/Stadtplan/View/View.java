package Stadtplan.View;

import Stadtplan.Model.Database;
import Stadtplan.Model.StreetNetwork;

public class View{

    public static Database db = new Database();
    public static StreetNetwork streetNetwork = new StreetNetwork();

    public static void main(String[] args) {
        streetNetwork.setStreets(db.streets);
        new WelcomeView();
    }
}