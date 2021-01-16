package game;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class City extends Square {
    private String color;
    private float buyingAmount;
    private float[] rents; // array of 4 [rent for 1 Houses, rent for 2, rent for 3, rent for Hotel]
    private Player owner;
    private Hotel hotel;
    private List<House> houses;
    private float[] costBuilding; // building prices; 0 -> House, 1-> Hotel

    public City(String squareName, Integer squareId, String color, float buyingAmount, float[] rents, Pane pane, float[] costBuilding) {
        super(squareName, squareId, pane);
        this.buyingAmount = buyingAmount;
        this.color = color;
        this.rents = rents;
        this.costBuilding = costBuilding;
        this.owner = null;
        this.hotel = null;
        this.houses = new ArrayList<>();
    }

    int task(Player player, Bank bank, Pane pane) {
        Label l1 = (Label) pane.getChildren().get(0);
        Label l = (Label) pane.getChildren().get(1);
        Button yes = (Button) pane.getChildren().get(2);
        Button no = (Button) pane.getChildren().get(3);

        // case - no player owns the property
        if (this.owner == null) {
            l.setText("Would you like to purchase this property? Cost: " + this.buyingAmount);
            yes.setText("Yes");
            no.setText("No");

            yes.setOnAction(event -> {
                if (bank.takeMoneyFromPlayer(player, this.buyingAmount)) {
                    this.owner = player;
                    l1.setText("Congratulations " + player.getName() + "! You now own " + this.getSQUARE_NAME());
                    l.setText("SOLD!");
                    player.addNewlyBoughtCity(this);
                } else {
                    l.setText("Not enough funds ^.^");
                }
            });

            no.setOnAction(event1 -> {
                l.setText("Let's move on then! Next roll");
            });
        } else {
            // owner lands in property
            if (this.owner == player) {
                //option to sell
                l1.setText("Hello again! " + this.owner.getName());
                l.setText("Would you like to sell this property?");

                yes.setText("Yes");
                no.setText("No, I'm keeping it");

                yes.setOnAction(event -> {
                    // find eligible buyer
                });

                no.setOnAction(event -> {
                    l.setText("Build a ");
                    yes.setText(houses.size() < 3 ? "House for " + this.getCostBuilding()[0]: "-");
                    no.setText(hotel == null ? "Hotel for " + this.getCostBuilding()[1] : "-"); // else disable

                    yes.setOnAction(event1 -> {
                        if (bank.takeMoneyFromPlayer(player, this.getCostBuilding()[0])) {
                            House house = new House();
                            this.addHouse(house);
                            l.setText("You've build a house");
                        } else {
                            l.setText("Not enough funds ^.^");
                        }
                    });

                    no.setOnAction(event1 -> {
                        if (bank.takeMoneyFromPlayer(player, this.getCostBuilding()[1])) {
                            Hotel hotel = new Hotel();
                            this.setHotel(hotel);
                            l.setText("You've build a hotel");
                        } else {
                            l.setText("Not enough funds ^.^");
                        }
                    });
                });

                // wont work
//                Boolean ownsAllOfSameColorGrp = this.owner.getCitiesOwned().stream().anyMatch(city ->
//                        city.getColor().equals(this.color)
//                );

                // if this size is 3
//                Stream<City> s = this.owner.getCitiesOwned().stream().filter(city ->
//                        city.getColor().equals(this.color)
//                );
//
//                s.forEach(System.out::println);

                // [ condition ] if player owns all the cities of the same color, ask whether they'd wanna build a hotel or a house
                // and have them pay the amount for building the house/hotel if yes
            } else {
                // if any houses exist
                if (houses.size() > 0 && hotel != null) {
                    l1.setText(player.getName() + " Pay rent amount to " + this.owner.getName());
                    yes.setText("Pay Up");
                    no.setText("Well you gotta pay");
                }

                // if hotels or houses exist - accordingly calculate the rent amount and have the player pay it
            }
        }
        return 1;
    }

    public void addHouse(House house) {
        this.houses.add(house);
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

    public float[] getCostBuilding() {
        return costBuilding;
    }

}
