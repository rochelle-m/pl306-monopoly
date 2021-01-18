package game;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class CommunityChest extends Square{
    public CommunityChest(String squareName, Integer id, Pane pane) {
        super(squareName, id, pane);
    }


    public int task(Player player, Bank bank, Pane resPane) {
        Label l1 = (Label) resPane.getChildren().get(0);    
        Label l = (Label) resPane.getChildren().get(1);
        Button yes = (Button) resPane.getChildren().get(2);
        Button no = (Button) resPane.getChildren().get(3);
        int squareNext = player.getPosition();
        int x = 0;
        switch (player.getCurrentRoll()) {
            case 2:

                l.setText("You're sent to GO");
                yes.setOnAction(event -> {

                    player.setPosition(0);

                });
                break;
            case 3:
                l.setText("Hospital fee. Pay rs.100");
                yes.setOnAction(event -> {
                    System.out.println("Before: player"+player.getPlayerMoney() + " bank:"+ bank.getBankMoney());
                    bank.takeMoneyFromPlayer(player, 100);
                    System.out.println("After: player"+player.getPlayerMoney() + " bank:"+ bank.getBankMoney());
                });
                break;
            case 4:
               l.setText("Bank in ur favour, collect RS.200");
                yes.setOnAction(event -> {
                    System.out.println("Before: player"+player.getPlayerMoney() + " bank:"+ bank.getBankMoney());
                bank.giveMoneyToPlayer(player,200);
                    System.out.println("After: player"+player.getPlayerMoney() + " bank:"+ bank.getBankMoney());
                });
                break;
            case 5:
                l.setText("School fees. pay Rs.150");
                yes.setOnAction(event -> {
                    System.out.println("Before: player"+player.getPlayerMoney() + " bank:"+ bank.getBankMoney());
                    bank.takeMoneyFromPlayer(player, 150);
                    System.out.println("After: player"+player.getPlayerMoney() + " bank:"+ bank.getBankMoney());
                });
                break;
            case 6:
                l.setText("Holiday fund. collect Rs.100");
                yes.setOnAction(event -> {
                    System.out.println("Before: player"+player.getPlayerMoney() + " bank:"+ bank.getBankMoney());
                    bank.giveMoneyToPlayer(player,100);
                    System.out.println("After: player"+player.getPlayerMoney() + " bank:"+ bank.getBankMoney());
                });
                break;
            case 7:
                l.setText("You were fined dumping garbage. Pay RS.120");
                yes.setOnAction(event -> {
                    System.out.println("Before: player"+player.getPlayerMoney() + " bank:"+ bank.getBankMoney());
                    bank.takeMoneyFromPlayer(player, 120);
                    System.out.println("After: player"+player.getPlayerMoney() + " bank:"+ bank.getBankMoney());
                });
                break;
            case 8:
                l.setText("Go 2 spaces forward");
                Integer currPos = player.getPosition();
                Integer newPos = (currPos+ 2) % 28;
                player.setPosition(newPos);
                x = newPos;
                break;
            case 9:
                l.setText("You did not wear a mask. Pay fine worth rs200");
                yes.setOnAction(event -> {
                    System.out.println("Before: player"+player.getPlayerMoney() + " bank:"+ bank.getBankMoney());
                bank.takeMoneyFromPlayer(player, 200);
                    System.out.println("After: player"+player.getPlayerMoney() + " bank:"+ bank.getBankMoney());
                });
                break;
            case 10:
                yes.setOnAction(event -> {
                    System.out.println("Before: player"+player.getPlayerMoney() + " bank:"+ bank.getBankMoney());
                l.setText("You got third place in dance competition. Collect Rs.200");
                bank.giveMoneyToPlayer(player,200);
                    System.out.println("After: player"+player.getPlayerMoney() + " bank:"+ bank.getBankMoney());
                });
                break;
            case 11:
                l.setText("Go to Pub");


                player.setPosition(14);
                x = 14;


                break;
            case 12:
                l.setText("You won a lottery. Collect Rs.150");
                yes.setOnAction(event -> {
                    System.out.println("Before: player"+player.getPlayerMoney() + " bank:"+ bank.getBankMoney());
                bank.giveMoneyToPlayer(player,150);
                    System.out.println("After: player"+player.getPlayerMoney() + " bank:"+ bank.getBankMoney());
                });
                break;

        }
        return x;
    }
}
