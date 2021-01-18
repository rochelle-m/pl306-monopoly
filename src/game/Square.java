package game;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.List;

public class Square {
    private final String SQUARE_NAME;
    private final Integer SQUARE_ID;
    private final Pane PANE;
    List<Player> players;

    public Square(String squareName, Integer id, Pane pane) {
        this.SQUARE_ID = id;
        this.SQUARE_NAME = squareName;
        this.PANE = pane;
    }

    public void addPlayerToSquare(Player player) {
        Circle c = new Circle();
        String color = player.getTokenColor();
        int r = Integer.parseInt(color.substring(1, 3), 16);
        int g = Integer.parseInt(color.substring(3, 5), 16);
        int b = Integer.parseInt(color.substring(5, 7), 16);
        c.setFill(Color.rgb(r, g, b));
        c.setId(player.getName());
        c.setRadius(9.0);
        c.setLayoutX(player.getId() * 18.0);
        c.setLayoutY(24.0);
        c.toFront();
        this.PANE.getChildren().add(c);
        Tooltip.install(c, new Tooltip(player.getName()));
    }

    public void removePlayerFromSquare(Player player) {
        this.PANE.getChildren().removeIf(p -> player.getName().equals(p.getId()));
    }


//
//    public void payIncomeTax(Player currentPlayer, Bank bank, Pane resPane){
//        Label l1 = (Label) resPane.getChildren().get(0);
//        Label l = (Label) resPane.getChildren().get(1);
//        Button yes = (Button) resPane.getChildren().get(2);
//        Button no = (Button) resPane.getChildren().get(3);
//
//    }
    public int task(Player currentPlayer, Bank bank, Pane resPane){
        Label l1 = (Label) resPane.getChildren().get(0);
        Label l = (Label) resPane.getChildren().get(1);
        Button yes = (Button) resPane.getChildren().get(2);
        Button no = (Button) resPane.getChildren().get(3);

        if(this.getSQUARE_NAME().equals("Luxury Tax")){
            l.setText("Pay Luxury tax of RS.200");
            yes.setOnAction(event -> {
                bank.takeMoneyFromPlayer(currentPlayer, 200);
                l.setText("You paid the amount");
            });
        }
        if(this.getSQUARE_NAME().equals("Income Tax")){
            l.setText("Pay Income tax of RS.150");
            yes.setOnAction(event -> {
                bank.takeMoneyFromPlayer(currentPlayer, 150);
                l.setText("You paid the amount");
            });
        }

        return -1;

    }



    public String getSQUARE_NAME() {
        return SQUARE_NAME;
    }

    public Integer getSQUARE_ID() {
        return SQUARE_ID;
    }

    public Pane getPANE() {
        return PANE;
    }

}
