package com.kodilla;

import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private final GridPane grid;
    private Figure[][] figures = new Figure[3][3];
    private Player whichTurn = Player.PLAYERX;
    private List<WinningCombinations> winningCombinationsList = new ArrayList<>();

    public Game(GridPane grid) {
        this.grid = grid;
        for (int row =0; row < 3; row++) {
            for (int col =0; col<3; col++) {
                figures[row][col] = new FigureNone();
            }
        }
        //winning combinations creation
        for (int y = 0; y < 3; y++) {
            winningCombinationsList.add(new WinningCombinations(figures[0][y], figures[1][y], figures[2][y]));
        }

        for (int x = 0; x < 3; x++) {
            winningCombinationsList.add(new WinningCombinations(figures[x][0], figures[x][1], figures[x][2]));
        }

        winningCombinationsList.add(new WinningCombinations(figures[0][0], figures[1][1], figures[2][2]));
        winningCombinationsList.add(new WinningCombinations(figures[2][0], figures[1][1], figures[0][2]));
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
            if (whichTurn == Player.PLAYERX)
                figures[row][col] = new FigureX();
            else
                figures[row][col] = new FigureO();
            whichTurn = opponent(whichTurn);


            for (WinningCombinations comb : winningCombinationsList) {
                if (comb.checkForWin()) {
                    Figure[] fig = comb.getFigures();
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            if (fig[0] == figures[i][j]) {
                                figures[i][j].setColour();
                            }
                        }
                    }

                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            if (fig[1] == figures[i][j]) {
                                figures[i][j].setColour();
                            }
                        }
                    }

                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            if (fig[2] == figures[i][j]) {
                                figures[i][j].setColour();
                            }

                        }
                    }
                }
            }
        }
    }

    private Player opponent(Player whichTurn) {
        return whichTurn == Player.PLAYERX ? Player.PLAYERO : Player.PLAYERX;
    }
}
