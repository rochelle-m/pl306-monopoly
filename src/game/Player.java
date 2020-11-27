package game;

public class Player {
    private Integer id;
    private String name;
    private float amountOfMoney;
    private Boolean isInJail;
    private Boolean turn;
    // add current pos
    // list of cards -- TODO check for colors

    public Player(Integer id, String name, float amountOfMoney, Boolean isInJail) {
        this.id = id;
        this.name = name;
        this.amountOfMoney = amountOfMoney;
        this.isInJail = isInJail;
    }

    public void pay(float amountToPay){
        if(amountToPay > amountOfMoney){
            // not enough money
        }
        else{
            // deduct money
            amountOfMoney = amountOfMoney - amountToPay;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(float amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public Boolean getInJail() {
        return isInJail;
    }

    public void setInJail(Boolean inJail) {
        isInJail = inJail;
    }

    public Boolean getTurn() {
        return turn;
    }

    public void setTurn(Boolean turn) {
        this.turn = turn;
    }
}
