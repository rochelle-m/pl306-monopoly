package game;

import javafx.scene.layout.Pane;

import java.io.FileNotFoundException;
import java.util.stream.Stream;

public class CornerBox extends Square {

    private Integer amount;

    public CornerBox(String squareName, Integer id, Integer amount, Pane pane, String _imgPath) throws FileNotFoundException {
        super(squareName, id, pane, _imgPath);
        this.setAmount(amount);
    }


    public int task(Player player, Bank bank, Pane pane) {
        if (this.getSQUARE_NAME().equals("JAIL")) {
            bank.takeMoneyFromPlayer(player, amount);
        } else if (this.getSQUARE_NAME().equals("GO")) {
            bank.giveMoneyToPlayer(player, amount);

        } else if (this.getSQUARE_NAME().equals("restHouse")) {

            Stream<Player> temp =  players.stream().filter(p-> p.getName().equals(player.getName()));

            temp.forEach(System.out::println);
            for (Player p : players) {
                player.takeFromPlayer(p, amount);
            }
        } else if (this.getSQUARE_NAME().equals("PUB")) {
            for (Player p : players) {
                p.payToPlayer(player, amount);
            }
        }
        return 0;
    }


    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
