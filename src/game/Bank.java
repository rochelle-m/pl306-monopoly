package game;

public class Bank {
    private float bankMoney;
    final static int PAYMENT_FOR_JAIL = 1000;
    final int MAXIMUM_HOUSE_NUMBER = 24;
    final int MAXIMUM_HOTEL_NUMBER = 12;
    // public ArrayList<PropertyCard> propertyCardList;
    // private ArrayList<ChanceCard> chanceCardList;
    // private ArrayList<CommunityChestCard> communityChestCardList;

    public Bank() {
        this.bankMoney =  0;
    }

    public Bank(int bankMoney) {
        this.bankMoney = bankMoney;
    }

    public void giveMoneyToPlayer(Player player, float amount) {
        player.setPlayerMoney(amount);
        this.bankMoney -= amount;
    }

    //s
    public void takeMoneyFromPlayer(Player player, float amount){
        player.setPlayerMoney(-amount);
        this.bankMoney += amount;
    }

    public float getBankMoney() {
        return bankMoney;
    }

    public void setBankMoney(int bankMoney) {
        this.bankMoney = bankMoney;
    }

    public static int getPaymentForJail() {
        return PAYMENT_FOR_JAIL;
    }

    public int getMAXIMUM_HOUSE_NUMBER() {
        return MAXIMUM_HOUSE_NUMBER;
    }

    public int getMAXIMUM_HOTEL_NUMBER() {
        return MAXIMUM_HOTEL_NUMBER;
    }
}
