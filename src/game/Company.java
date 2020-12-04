package game;

public class Company extends Square {

    private Integer cost;
    private Integer rent;

    public Company(String squareName, Integer id, Integer cost, Integer rent) {
        super(squareName, id);
        this.cost = cost;
        this.rent = rent;
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

}
