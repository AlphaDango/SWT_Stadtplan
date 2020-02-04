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
    public boolean addUnfall(String streetname, int length, boolean state) {
        StrassenAbschnitt strassenAbschnitt = streetNetwork.getStreetByName(streetname);
        if(strassenAbschnitt == null)
            return false;
        Unfall unfall = new Unfall(strassenAbschnitt,length,state);
        streetNetwork.addUnfall(unfall);
        strassenAbschnitt.setVerkehrsstoerung(unfall);
        return true;
    }
}