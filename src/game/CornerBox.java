package game;

import javafx.scene.layout.Pane;

public class CornerBox extends Square {

    private Integer amount;

    public CornerBox(String squareName, Integer id, Integer amount, Pane pane){
        super(squareName, id, pane);
        this.setAmount(amount);
    }


    public void pay(Player player, CornerBox cornerBox, Bank bank){
/*        if cornerbox = resthouse
        deduct from other players, add pa
        else
         deduct from payee bal, and give to remaining*/

        //s
        if( cornerBox.getSQUARE_NAME() == "JAIL") {
            bank.takeMoneyFromPlayer(player, amount);
        }
        else if( cornerBox.getSQUARE_NAME() == "GO")
        {
            bank.giveMoneyToPlayer(player, amount);
        }
        else if ( cornerBox.getSQUARE_NAME() == "restHouse")
        {
            //for(Player p: player) { p.earn(amount); }
        }

        else if ( cornerBox.getSQUARE_NAME() == "PUB")
        {
            //for(Player p: player) { player.payToPlayer(player , amount); }
        }

    }





    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
