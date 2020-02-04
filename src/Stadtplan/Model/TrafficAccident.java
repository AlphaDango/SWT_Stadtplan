package Stadtplan.Model;
/*
* The TrafficDisruption class.
* Details about the Traffic accident
* are safed in instances of this class.
 */
public class TrafficAccident extends TrafficDisruption {
    private boolean isSecured;

    public TrafficAccident(StreetSection affectedStreet, int length, boolean isSecured){
        super.length = length;
        super.affectedStreet = affectedStreet;
        this.isSecured = isSecured;
    }

    @Override
    public StreetSection getAffectedStreet() {
        return super.affectedStreet;
    }

    @Override
    public int getLength() {
        return super.length;
    }

    public void setSecured(boolean isSecured){
        this.isSecured = isSecured;
    }

    public boolean isSecured(){
        return isSecured;
    }
}