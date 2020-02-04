package Stadtplan.Controller;

import Stadtplan.Model.StreetSection;
import Stadtplan.Model.TrafficAccident;
import Stadtplan.Model.StreetNetwork;
/*
* The Controller class.
*  It's used to manipulate the data
*  in the model with data given by the user.
 */
public class Controller {

    private StreetNetwork streetNetwork = new StreetNetwork();

    /*
    * Controller method to add an traffic accident
    * to affected street section instance.
    * Returns true if the traffic accident was added successfully.
    * Returns false if it failed to add the traffic accident.
     */
    public boolean reportTrafficAccident(String streetname, String s_length, boolean state) {
        StreetSection streetSection = streetNetwork.getStreetByName(streetname);
        int int_length;
        //TryCatch to catch invalid user inputs.
        try{
            int_length = Integer.parseInt(s_length);
        }catch (Exception e){
            return false;
        }
        //Check if the streetName or the length is invalid.
        if(streetSection == null || int_length < 1)
            return false;
        TrafficAccident trafficAccident = new TrafficAccident(streetSection,int_length,state);
        streetSection.setTrafficAccident(trafficAccident);
        return true;
    }
}