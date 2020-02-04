package Stadtplan;

import Stadtplan.Model.Database;
import Stadtplan.Model.StreetNetwork;
import Stadtplan.View.WelcomeView;

public class Main {

    public static Database db = new Database();
    public static StreetNetwork streetNetwork = new StreetNetwork();

    public static void main(String[] args) {
        streetNetwork.setStreets(db.streets);
        new WelcomeView();
    }
}