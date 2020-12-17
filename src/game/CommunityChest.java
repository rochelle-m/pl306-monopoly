package game;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class CommunityChest extends Square{
    public CommunityChest(String squareName, Integer id, Pane pane) {
        super(squareName, id, pane);
    }

    public void task(Player currentPlayer, Bank bank, Pane resPane, int roll) {
        Label l1 = (Label) resPane.getChildren().get(0);
        Label l = (Label) resPane.getChildren().get(1);
        Button yes = (Button) resPane.getChildren().get(2);
        Button no = (Button) resPane.getChildren().get(3);
        int squareNext = currentPlayer.getPosition();
        switch (roll) {

            case 2:
                // set message in label
                l.setText("You're sent to GO");
                currentPlayer.setPosition(0);
                System.out.println("");

                squareNext = 0;
                break;
            case 3:
                System.out.println("Hospital fee. Pay rs.100");

                bank.takeMoneyFromPlayer(currentPlayer, 100);
                break;
            case 4:
                System.out.println("Bank in ur favour, collect RS.200");
                bank.giveMoneyToPlayer(currentPlayer,200);
                break;
            case 5:
                System.out.println("School fees. pay Rs.150");
                bank.takeMoneyFromPlayer(currentPlayer, 150);
                break;
            case 6:
                System.out.println("Holiday fund. collect Rs.100");
                bank.giveMoneyToPlayer(currentPlayer,100);
                break;
            case 7:
                System.out.println("You were fined dumping garbage. Pay RS.120");
                bank.takeMoneyFromPlayer(currentPlayer, 120);
                break;
            case 8:
                System.out.println("Go 2 spaces forward");

                break;
            case 9:
                System.out.println("You did not wear a mask. Pay fine worth rs200");
                bank.takeMoneyFromPlayer(currentPlayer, 200);
                break;
            case 10:
                System.out.println("You got third place in dance competition. Collect Rs.200");
                bank.giveMoneyToPlayer(currentPlayer,200);
                break;
            case 11:
                System.out.println("Go to Pub");
                 squareNext=14;

                break;
            case 12:
                System.out.println("You won a lottery. Collect Rs.150");
                bank.giveMoneyToPlayer(currentPlayer,150);
                break;

        }
        // set msg in label

    }
}
