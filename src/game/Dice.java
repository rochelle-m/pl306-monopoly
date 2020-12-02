package game;

import java.util.Random;
import javafx.util.Pair;

public class Dice {

    private Integer faceValue;


    public Dice(){
    this.faceValue = 0;
    }

    Random rand = new Random();



    public int diceOperation(){

        this.faceValue = rand.nextInt(6)+1;

        return faceValue;
    }



}