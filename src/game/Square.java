package game;

public class Square {
    // add (property) square index
    private String squareName;
    private Integer squareId;


    public Square(String squareName, Integer id){
        this.squareId = id;
        this.squareName= squareName ;
    }

    public String getSquareName() {
        return squareName;
    }

    public void setSquareName(String squareName) {
        this.squareName = squareName;
    }
}

