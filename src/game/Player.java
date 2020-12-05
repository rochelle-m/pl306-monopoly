package game;

import javafx.scene.paint.Color;

public class Player {
    private Integer id;
    private String name;
    private float playerMoney;
    private Boolean isInJail;
    private Boolean turn;
    private Integer position;
    private final Color TOKEN_COLOR;
    // add current pos
    // list of cards -- TODO check for colors

    public Player(Integer id, String name, Color tokenColor) {
        this.id = id;
        this.name = name;
        this.position = 0;
        this.playerMoney = (float) 1000;
        this.isInJail = false;
        this.turn = false;
        this.TOKEN_COLOR = tokenColor;
    }

    public void pay(float amountToPay){
        if(amountToPay > playerMoney){
            // not enough money
        }
        else{
            // deduct money
            playerMoney =  playerMoney - amountToPay;
        }
    }

    public void earn(float amount){
        playerMoney += amount;
    }

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

    public Color getTokenColor() {
        return TOKEN_COLOR;
    }
}
