package game;

public class CornerBox extends Square {

    private Integer amount;

    public CornerBox(String squareName, Integer id, Integer amount){
        super(squareName, id);
        this.setAmount(amount);
    }

    public void pay(Player player, CornerBox cornerBox, Bank bank){
//        if cornerbox = resthouse
//        deduct from other players, add pa
//        else
        // deduct from payee bal, and give to remaining

        // if jail then pay to bank

        // if go recieve from bank
        bank.giveMoneyToPlayer(player, amount);


    }





    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
