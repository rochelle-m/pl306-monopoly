package game;

import javafx.scene.layout.Pane;

public class City extends Square{
    private String color;
    private float buyingAmount;
    private float[] rents;

    public City(String squareName, Integer squareId,  String color, float buyingAmount, float[] rents, Pane pane) {
        super(squareName, squareId, pane);
        this.buyingAmount = buyingAmount;
        this.color = color;
        this.rents = rents;
    }

    void task(Player player, Bank bank){

        // TODO 001
        // parties imvolved - Owmer/ Buyer(Player) Bank, Payee(Player),
        System.out.println("You're in " + this.getSQUARE_NAME());
        // check owner of property
        // ask player rent

        // if property is not owned by any other player enter switch

        switch(this.getColor()){
            case "Red": {
                System.out.println("f"); break;
            }
            case "Blue":{
                System.out.println("b"); break;
            }
            case "Green": {
                System.out.println("g"); break;
            }
            case "Yellow":{
                switch(this.getSQUARE_NAME()){
                    case "Pune": {
                        System.out.println("");
                        // show title card of city
                        // pose qt: would you like to buy it?
                        // Button Y/N
                        // if res -> YES
                        // check player account balance
                        //  if OK
                        //      add City to Player's Owned Property, collect rent etc whenever another player lands
                        //       in prop

                    }
                    case "Patna": {

                    }
                    case "Kolkata": {

                    }
                }
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
}
