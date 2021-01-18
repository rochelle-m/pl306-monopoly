package game;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.util.stream.Stream;

public class CornerBox extends Square {

    private Integer amount;

    public CornerBox(String squareName, Integer id, Integer amount, Pane pane) {
        super(squareName, id, pane);
        this.setAmount(amount);
    }


    public int task(Player player, Bank bank, Pane pane) {
        Label l1 = (Label) pane.getChildren().get(0);
        Label l = (Label) pane.getChildren().get(1);
        Button yes = (Button) pane.getChildren().get(2);
        Button no = (Button) pane.getChildren().get(3);

        switch (this.getSQUARE_NAME()) {
            case "JAIL":
                bank.takeMoneyFromPlayer(player, amount);
                l.setText("You have to pay Rs.100 to get out of the jail");
                break;
            case "GO":
                bank.giveMoneyToPlayer(player, amount);
                l.setText("You received Rs.200 for crossing GO");
                break;
            case "restHouse":

                Stream<Player> temp = players.stream().filter(p -> p.getName().equals(player.getName()));

                temp.forEach(System.out::println);
                for (Player p : players) {
                    player.takeFromPlayer(p, amount);
                }
                l.setText("You received the amount");
                break;
            case "PUB":

                for (Player p : players) {
                    p.payToPlayer(player, amount);
                }
                l.setText("You paid the amount");
                break;
        }
        return -2;
    }


    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
