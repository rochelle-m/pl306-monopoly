package game;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class City extends Square{
    private String color;
    private float buyingAmount;
    private float[] rents; // array of 4 [rent for 1 Houses, rent for 2, rent for 3, rent for Hotel]
    private Player owner;
    private Hotel hotel;
    private List<House> houses;
    private float[] costBuilding; // building prices; 0 -> House, 1-> Hotel

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

    int task(Player player, Bank bank, Pane pane){
        System.out.println(this.owner);
        if(this.owner == null){

            Label l1 = (Label) pane.getChildren().get(0);
            Label l = (Label) pane.getChildren().get(1);
            l.setText("Would you like to purchase this property? Cost: "+ this.buyingAmount);

            Button yes = (Button) pane.getChildren().get(2);
            Button no = (Button) pane.getChildren().get(3);

            yes.setText("Yes");
            no.setText("No");

            yes.setOnAction(event -> {
                System.out.println("Before: player"+player.getPlayerMoney() + " bank:"+ bank.getBankMoney());
                if(bank.takeMoneyFromPlayer(player, this.buyingAmount)){
                    this.owner = player;
                    l1.setText("Congratulations "+player.getName() + "! You now own "+ this.getSQUARE_NAME());
                    l.setText("SOLD!");

                }
                else{
                    l.setText("Not enough funds ^.^");
                }

                System.out.println("After: player"+player.getPlayerMoney() + " bank:"+ bank.getBankMoney());
//                return 1; // 1
            });

            no.setOnAction(event1 -> {
                System.out.println("Well bye then");
                l.setText("Let's move on then! Next roll");
            });
        }
        else{
            // comparing objects!? -.-
            if(this.owner == player){
                //option to sell - take input as player id -- perform transation

                // [ condition ] if player owns all the cities of the same color, ask whether they'd wanna build a hotel or a house
                // and have them pay the amount for building the house/hotel if yes
            }
            else{
                // if hotels or houses exist - accordingly calculate the rent amount and have the player pay it
            }
        }
        return 1;
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
