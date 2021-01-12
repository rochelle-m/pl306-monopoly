package game;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Company extends Square {
    private Integer cost;
    private Integer rent;
    private Player owner;

    public Company(String squareName, Integer id, Integer cost, Integer rent, Pane pane) {
        super(squareName, id, pane);
        this.cost = cost;
        this.rent = rent;
        this.owner = null;
    }

    int task(Player player, Bank bank, Pane pane) {
        Label l1 = (Label) pane.getChildren().get(0);
        Label l = (Label) pane.getChildren().get(1);
        Button yes = (Button) pane.getChildren().get(2);
        Button no = (Button) pane.getChildren().get(3);
        if (this.owner == null) {
            l.setText("Would you like to buy this company? (Y/N)");

            yes.setText("YES");

            no.setText("NO");

            yes.setOnAction(event -> {
                System.out.println("Before: player"+player.getPlayerMoney() + " bank:"+ bank.getBankMoney());
                System.out.println( player.getName() + " pay to bank $"+ this.cost);
                this.owner = player;
//                return 1; // 1

                Boolean bought = bank.takeMoneyFromPlayer(player,this.cost);
                if(bought)
                    l.setText("Purchased!");
                System.out.println("A: player"+player.getPlayerMoney() + " bank:"+ bank.getBankMoney());

            });

            no.setOnAction(event1 -> {
                System.out.println("Well bye then");

            });
        }
        else{

            player.takeFromPlayer(player,this.rent);


           /* if( company.getSQUARE_NAME() == "WATERWORKS" ){player.takeFromPlayer(player,company.rent); }
            else if (company.getSQUARE_NAME() == " AIRWAYS"){}
            else if (company.getSQUARE_NAME() == " WATERWAYS"){}
            else if (company.getSQUARE_NAME() == " ROADWAYS"){}
            else if (company.getSQUARE_NAME() == " ELECTRICITY"){}
            else if (company.getSQUARE_NAME() == " RAILWAYS"){}*/
        }
        return 1;
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
