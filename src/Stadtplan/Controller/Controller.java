package Stadtplan.Controller;

import Stadtplan.Model.StrassenAbschnitt;
import Stadtplan.Model.Unfall;
import Stadtplan.Model.StreetNetwork;

public class Controller {

    private StreetNetwork streetNetwork = new StreetNetwork();

    /*
    * Controller method to add an accident
    * to the StreetNetwork instance and
    * the used street instance
     */
    public void addUnfall(StrassenAbschnitt street, int length, boolean state) {
        Unfall unfall = new Unfall(street,length,state);
        streetNetwork.addUnfall(unfall);
        street.setVerkehrsstoerung(unfall);
    }
}