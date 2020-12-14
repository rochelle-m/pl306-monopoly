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
        System.out.println("You're in " + this.getSQUARE_NAME());
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
