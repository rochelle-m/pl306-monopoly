package game;

public class CornerBox extends Square {

    private Integer amount;

    public CornerBox(String squareName, Integer amount){
        super(squareName);
        this.setAmount(amount);
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
