package com.kodilla;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
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
