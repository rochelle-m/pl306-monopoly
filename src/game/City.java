package game;

import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public class City extends Square{
    private String color;
    private float buyingAmount;
    private float[] rents; // array of 4 [rent for 1 Houses, rent for 2, rent for 3, rent for Hotel]
    private Player owner;
    private Hotel hotel;
    private List<House> houses;
    private float[] costBuilding;

    public City(String squareName, Integer squareId,  String color, float buyingAmount, float[] rents, Pane pane, float[] costBuilding) {
        super(squareName, squareId, pane);
        this.buyingAmount = buyingAmount;
        this.color = color;
        this.rents = rents;
        this.costBuilding = costBuilding;
        this.owner = null;
        this.hotel =  null;
        this.houses = new ArrayList<>();
    }

    void task(Player player, Bank bank){
        if(this.owner == null){
            System.out.println("Would you like to buy this property? (Y/N)");
            // if yes -> this.owner = player and send back some response so that this city is added to the cities owned by the player
            // [ condition ] if player owns all the cities of the same color, ask whether they'd wanna build a hotel or a house
            // and have them pay the amount for building the house/hotel if yes
            // limit check -  3 houses and 1 hotel

            // else early return
        }
        else{
            // comparing objects!? -.-
            if(this.owner == player){
                // [ condition ] if player owns all the cities of the same color, ask whether they'd wanna build a hotel or a house
                // and have them pay the amount for building the house/hotel if yes
            }
            else{
                // if hotels or houses exist - accordingly calculate the rent amount and have the player pay it
            }
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getBuyingAmount() {
        return buyingAmount;
    }

    public void setBuyingAmount(float buyingAmount) {
        this.buyingAmount = buyingAmount;
    }

    public float[] getRents() {
        return rents;
    }

    public void setRents(float[] rents) {
        this.rents = rents;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public List<House> getHouses() {
        return houses;
    }

    public void addHouse(House house) {
        if(this.houses.size() < 3) //additional check
            this.houses.add(house);
    }

}
