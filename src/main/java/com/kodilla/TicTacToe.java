package com.kodilla;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TicTacToe extends Application {

    private static Game game;

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane grid = new GridPane();

        grid.setAlignment(Pos.CENTER);
        Scene scene = new Scene(grid, 600, 600);
        primaryStage.setTitle("Tic tac toe");
        primaryStage.setScene(scene);
        primaryStage.show();
        game = new Game(grid);
        game.showBoard();

    }
}
