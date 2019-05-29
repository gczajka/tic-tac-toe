package com.kodilla;

import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class Game {
    private final GridPane grid;
    private Figure[][] figures = new Figure[3][3];
    private Player whichTurn = Player.PLAYERX;


    public Game(GridPane grid) {
        this.grid = grid;
        for (int row =0; row < 3; row++) {
            for (int col =0; col<3; col++) {
                figures[row][col] = new FigureNone();
            }
        }
    }

    public void showBoard() {
        grid.getChildren().clear();
        for (int row =0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                TTTButton button = new TTTButton(this,row,col);
                InnerShadow innerShadow = new InnerShadow();
                innerShadow.setOffsetX(-5.0 + col*5);
                innerShadow.setOffsetY(-5.0 + row*5);
                innerShadow.setColor(Color.BLACK);
                button.setEffect(innerShadow);
                grid.add(button,col, row);
                button.displayFigure(figures[row][col]);
            }
        }
    }

    public Player getWhichTurn() {
        return whichTurn;
    }


    public void doClick(int row, int col) {
        if(figures[row][col] instanceof FigureNone) {
            if(whichTurn == Player.PLAYERX)
                figures[row][col] = new FigureX();
            else
                figures[row][col] = new FigureO();
            whichTurn = opponent(whichTurn);
        }
    }

    private Player opponent(Player whichTurn) {
        return whichTurn == Player.PLAYERX ? Player.PLAYERO : Player.PLAYERX;
    }
}
