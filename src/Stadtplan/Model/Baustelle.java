package Stadtplan.Model;

public class Baustelle extends Verkehrsstoerung {
    private String finishDate;

    public Baustelle(int length, String finishDate){
        super.length = length;
        this.finishDate = finishDate;
    }

    @Override
    public StrassenAbschnitt getAffectedStreet() {
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
