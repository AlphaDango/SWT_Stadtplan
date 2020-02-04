package Stadtplan.Model;
/*
* Abstract Class TrafficDisruption
 */
public abstract class TrafficDisruption {

    protected int length;
    protected StreetSection affectedStreet;

    public abstract StreetSection getAffectedStreet();
    public abstract int getLength();
}
