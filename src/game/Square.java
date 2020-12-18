package game;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.TextAlignment;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class Square {
    private final String SQUARE_NAME;
    private final Integer SQUARE_ID;
    private final Pane PANE;
    private final String IMG_PATH;
    List<Player> players;

    public Square(String squareName, Integer id, Pane pane, String _imgPath) throws FileNotFoundException {
        this.SQUARE_ID = id;
        this.SQUARE_NAME = squareName;
        this.PANE = pane;
        ImageView imageView = new ImageView();
        FileInputStream f = new FileInputStream(_imgPath);

        Image image = new Image(f);
        this.IMG_PATH = _imgPath;
        imageView.setImage(image);
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);
        imageView.setLayoutX(20);
        imageView.setLayoutY(20);

        this.PANE.getChildren().add(imageView);

        Label title = new Label(squareName);
        title.setLayoutY(3);
        title.setLayoutX(3);
        this.PANE.getChildren().add(title);

    }

    public void addPlayerToSquare(Player player) {
        Circle c = new Circle();
        String color = player.getTokenColor();
        int r = Integer.parseInt(color.substring(1, 3), 16);
        int g = Integer.parseInt(color.substring(3, 5), 16);
        int b = Integer.parseInt(color.substring(5, 7), 16);
        c.setFill(Color.rgb(r, g, b));
        c.setId(player.getName());
        c.setRadius(9.0);

        String appendZero = "0"+Integer.toBinaryString(player.getId() - 1);
        String idStrBin = appendZero.substring(appendZero.length() - 2);

        c.setLayoutX(Integer.parseInt(String.valueOf(idStrBin.charAt(0))) * 25 + 30);
        c.setLayoutY(Integer.parseInt(String.valueOf(idStrBin.charAt(1))) * 25 + 30);

        c.toFront();
        // something might break here -- [fixed] [still might break]

        this.PANE.getChildren().add(c);
        Tooltip.install(c, new Tooltip(player.getName()));
    }

    public void removePlayerToSquare(Player player) {
        this.PANE.getChildren().removeIf(p -> player.getName().equals(p.getId()));
    }


    public void payIncomeTax(Player currentPlayer, Bank bank){
        System.out.println("pay income tax of RS.150");
       bank.takeMoneyFromPlayer(currentPlayer, 150);

    }
    public void payLuxuryTax(Player currentPlayer, Bank bank){
        System.out.println("pay luxury tax of RS.200");
        bank.takeMoneyFromPlayer(currentPlayer, 200);

    }

   

    int task(Player player, Bank bank, Pane pane ) {
        return 1;

    }

    public String getSQUARE_NAME() {
        return SQUARE_NAME;
    }

    public Integer getSQUARE_ID() {
        return SQUARE_ID;
    }

    public Pane getPANE() {
        return PANE;
    }

}
