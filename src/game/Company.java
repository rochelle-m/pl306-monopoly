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

    //s

    int rentOrBuyCompany(Player player, Bank bank,Company company, Pane pane) {
        if (this.owner == null) {
            Label l = new Label("Would you like to buy this company? (Y/N)");
            l.setTextFill(Color.DARKSLATEBLUE);
            l.setStyle("-fx-padding: 10;" + "-fx-font-size: 16px;");
            l.setLayoutY(40.0);
            pane.getChildren().add(l);

            Button yes = new Button("YES");
            yes.setTextFill(Color.WHITE);
            yes.setStyle("-fx-background-color: green;");
            yes.setLayoutY(80.0);
            yes.setLayoutX(10.0);
            pane.getChildren().add(yes);

            Button no = new Button("NO");
            no.setTextFill(Color.WHITE);
            no.setStyle("-fx-background-color: blue;");
            no.setLayoutY(80.0);
            no.setLayoutX(60.0);
            pane.getChildren().add(no);

            yes.setOnAction(event -> {
                System.out.println( player.getName() + " pay to bank $"+ this.cost);
                this.owner = player;
//                return 1; // 1
                bank.takeMoneyFromPlayer(player,company.cost);
            });

            no.setOnAction(event1 -> {
                System.out.println("Well bye then");

            });
        }
        else{
            player.takeFromPlayer(player,company.rent);

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
