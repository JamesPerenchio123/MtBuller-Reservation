package stage2_James;

/**
 * PC class
 */

public class PC {

    private int PCNo;
    private String type;
    private double TotalPrice;
    static int nextId = 1;

    public PC() {}

    public PC (String type) {
        this.type = type;
        PCNo = nextId++;
    }
    public int getPCNo () {
        return PCNo;
    }

    public String getType () {
        return type;
    }

    public double getPricePerDay () {
        return TotalPrice;
    }


    public void setType (String type) {
        this.type = type;
    }

    public void setTotalPrice(String type) {
        if(type.equalsIgnoreCase("gaming"))
            TotalPrice = 1000;
        else if(type.equalsIgnoreCase("office"))
            TotalPrice = 600;
        else if(type.equalsIgnoreCase("media consumption"))
            TotalPrice =500;
        else
            TotalPrice =0.0;
    }



    public String toString () {
        return "PC #: " + PCNo + "\ntype: " + type + "\nTotal Price: " + TotalPrice + "\navailable?  " ;
    }

}