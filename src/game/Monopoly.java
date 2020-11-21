package game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Monopoly extends Application {
    private Integer numOfPlayers;

    public Monopoly(Integer numOfPlayers) {
        this.numOfPlayers = numOfPlayers;
        System.out.println("Game on "+ numOfPlayers);
    }

    public Integer getNumOfPlayers() {
        return numOfPlayers;
    }

    public void setNumOfPlayers(Integer numOfPlayers) {
        this.numOfPlayers = numOfPlayers;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("board.fxml"));
        primaryStage.setTitle("APP_NAME");
        primaryStage.setScene(new Scene(root, 500, 475));
        primaryStage.show();
    }
}

