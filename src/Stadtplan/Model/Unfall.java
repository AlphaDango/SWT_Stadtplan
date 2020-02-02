package Stadtplan.Model;
/*
*Unfall Class done like the give Domainmodel
 */
public class Unfall extends Verkehrsstoerung {
    private boolean isSecured;

    public Unfall(StrassenAbschnitt affectedStreet, int length, boolean isSecured){
        super.length = length;
        super.affectedStreet = affectedStreet;
        this.isSecured = isSecured;
    }

    @Override
    public StrassenAbschnitt getAffectedStreet() {
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