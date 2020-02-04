package Stadtplan.Controller;

import Stadtplan.Model.StrassenAbschnitt;
import Stadtplan.Model.Unfall;
import Stadtplan.Model.StreetNetwork;

import javax.swing.*;

public class Controller {

    private StreetNetwork streetNetwork = new StreetNetwork();

    /*
    * Controller method to add an accident
    * to the StreetNetwork instance and
    * the used street instance
     */
    public boolean addUnfall(String streetname, String s_length, boolean state) {
        StrassenAbschnitt strassenAbschnitt = streetNetwork.getStreetByName(streetname);
        int int_length;
        try{
            int_length = Integer.parseInt(s_length);
        }catch (Exception e){
            return false;
        }
        if(strassenAbschnitt == null)
            return false;
        Unfall unfall = new Unfall(strassenAbschnitt,int_length,state);
        streetNetwork.addUnfall(unfall);
        strassenAbschnitt.setVerkehrsstoerung(unfall);
        return true;
    }
}