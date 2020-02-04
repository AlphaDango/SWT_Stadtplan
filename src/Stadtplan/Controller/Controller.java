package Stadtplan.Controller;

import Stadtplan.Model.StrassenAbschnitt;
import Stadtplan.Model.Accident;
import Stadtplan.Model.StreetNetwork;

public class Controller {

    private StreetNetwork streetNetwork = new StreetNetwork();

    /*
    * Controller method to add an accident
    * to the StreetNetwork instance and
    * the used street instance
     */
    public boolean reportAccident(String streetname, String s_length, boolean state) {
        StrassenAbschnitt strassenAbschnitt = streetNetwork.getStreetByName(streetname);
        int int_length;
        try{
            int_length = Integer.parseInt(s_length);
        }catch (Exception e){
            return false;
        }
        if(strassenAbschnitt == null || int_length < 1)
            return false;
        Accident accident = new Accident(strassenAbschnitt,int_length,state);
        streetNetwork.addAccident(accident);
        strassenAbschnitt.setAccident(accident);
        return true;
    }
}