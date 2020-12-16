package game;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private Integer id;
    private String name;
    private float playerMoney;
    private Boolean isInJail;
    private Boolean turn;
    private Integer position;
    private final String TOKEN_COLOR;
    private List<City> citiesOwned;

    public Player(Integer id, String name, String tokenColor) {
        this.id = id;
        this.name = name;
        this.position = 0;
        this.playerMoney = (float) 1500;
        this.isInJail = false;
        this.turn = false;
        this.TOKEN_COLOR = tokenColor;
        citiesOwned = new ArrayList<>();
    }

    public boolean pay(float amountToPay){
        // return boolean for payment status
        if(amountToPay < playerMoney){
            playerMoney -= amountToPay;
            return true;
        }
        return false;
    }

    public void earn(float amount){
        playerMoney += amount;
    }

    public void takeFromPlayer(Player player, int amount){ playerMoney += amount; }
    public void payToPlayer(Player player, int amount){ playerMoney -= amount; }

    public Integer roll(Dice d1, Dice d2){
        return d1.diceOperation() + d2.diceOperation();
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

    public float getPlayerMoney() {
        return  playerMoney;
    }

    public void setPlayerMoney(float  playerMoney) {
        this.playerMoney =  playerMoney;
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

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getTokenColor() {
        return TOKEN_COLOR;
    }

    public List<City> getCitiesOwned() {
        return citiesOwned;
    }

    public void setCitiesOwned(List<City> citiesOwned) {
        this.citiesOwned = citiesOwned;
    }

    public void addNewlyBoughtCity(City cityBought) {
        this.citiesOwned.add(cityBought);
    }
}
