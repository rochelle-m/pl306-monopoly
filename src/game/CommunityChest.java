package game;

import javafx.scene.layout.Pane;

public class CommunityChest extends Square{
    public CommunityChest(String squareName, Integer id, Pane pane) {
        super(squareName, id, pane);
    }

    public void ComChestConditions( int x) {

        switch (x) {

            case 2:
                System.out.println("Advance to GO");
                break;
            case 3:
                System.out.println("Hospital fee. Pay rs.100");
                break;
            case 4:
                System.out.println("Bank in ur favour, collect RS.200");
                break;
            case 5:
                System.out.println("School fees. pay Rs.150");
                break;
            case 6:
                System.out.println("Holiday fund. collect rs.100");
                break;
            case 7:
                System.out.println("You were fined dumping garbage. Pay RS.120");
                break;
        }
    }
}
