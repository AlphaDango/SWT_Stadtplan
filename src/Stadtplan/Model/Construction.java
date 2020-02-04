package Stadtplan.Model;
/*
*Unused
 */
public class Construction extends TrafficDisruption {
    private String finishDate;

    public Construction(int length, String finishDate){
        super.length = length;
        this.finishDate = finishDate;
    }

    @Override
    public StreetSection getAffectedStreet() {
        return super.affectedStreet;
    }

    @Override
    public int getLength() {
        return super.length;
    }

    public String getFinishDate(){
        return finishDate;
    }
}
