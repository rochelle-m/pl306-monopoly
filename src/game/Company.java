package game;

public class Company extends Square {

    private Integer cost;
    private Integer rent;
    private Integer mV;

    public Company(String squareName, Integer cost, Integer rent, Integer mV) {
        super(squareName);
        this.cost = cost;
        this.rent = rent;
        this.mV = mV;
    }

    public void totalRent(){

    }

    public Integer getRent() {
        return rent;
    }

    public void setRent(Integer rent) {
        this.rent = rent;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getmV() {
        return mV;
    }

    public void setmV(Integer mV) {
        this.mV = mV;
    }
}
