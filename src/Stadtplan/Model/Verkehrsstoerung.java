package Stadtplan.Model;
/*
*Abstract Class Verkehrsstörung
* Done like the given Domainmodel with affectedStreet
 */
public abstract class Verkehrsstoerung {

    protected int length;
    protected StrassenAbschnitt affectedStreet;

    public abstract StrassenAbschnitt getAffectedStreet();
    public abstract int getLength();
}
