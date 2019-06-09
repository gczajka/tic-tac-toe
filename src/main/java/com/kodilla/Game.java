package com.kodilla;

import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class Game {
    private final GridPane grid;
    private Figure[][] figures = new Figure[3][3];
    private Player whichTurn = Player.PLAYERX;
    boolean winningConditions = false;

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
        if(winningConditions != true) {
            if (figures[row][col] instanceof FigureNone) {
                if (whichTurn == Player.PLAYERX)
                    figures[row][col] = new FigureX();
                else
                    figures[row][col] = new FigureO();
                whichTurn = opponent(whichTurn);
            }
        }
    }
    public void checkForWinningConditions() {
                for (int x = 0; x < 3; x++) {
                    if (figures[x][0] instanceof FigureX && figures[x][1] instanceof FigureX &&
                            figures[x][2] instanceof FigureX) {
                        winningConditions = true;
                        figures[x][0].setColour();
                        figures[x][1].setColour();
                        figures[x][2].setColour();
                    }
                }

                for (int y = 0; y < 3; y++) {
                    if (figures[0][y] instanceof FigureX && figures[1][y] instanceof FigureX &&
                            figures[2][y] instanceof FigureX) {
                        winningConditions = true;
                        figures[0][y].setColour();
                        figures[1][y].setColour();
                        figures[2][y].setColour();
                    }
                }

                if (figures[0][0] instanceof FigureX && figures[1][1] instanceof FigureX &&
                        figures[2][2] instanceof FigureX) {
                    winningConditions = true;
                    figures[0][0].setColour();
                    figures[1][1].setColour();
                    figures[2][2].setColour();
                }

                if (figures[2][0] instanceof FigureX && figures[1][1] instanceof FigureX &&
                        figures[0][2] instanceof FigureX) {
                    winningConditions = true;
                    figures[2][0].setColour();
                    figures[1][1].setColour();
                    figures[0][2].setColour();
                }

                for (int x = 0; x < 3; x++) {
                    if (figures[x][0] instanceof FigureO && figures[x][1] instanceof FigureO &&
                            figures[x][2] instanceof FigureO) {
                        winningConditions = true;
                        figures[x][0].setColour();
                        figures[x][1].setColour();
                        figures[x][2].setColour();
                    }
                }

                for (int y = 0; y < 3; y++) {
                    if (figures[0][y] instanceof FigureO && figures[1][y] instanceof FigureO &&
                            figures[2][y] instanceof FigureO) {
                        winningConditions = true;
                        figures[0][y].setColour();
                        figures[1][y].setColour();
                        figures[2][y].setColour();
                    }
                }

                if (figures[0][0] instanceof FigureO && figures[1][1] instanceof FigureO &&
                        figures[2][2] instanceof FigureO) {
                    winningConditions = true;
                    figures[0][0].setColour();
                    figures[1][1].setColour();
                    figures[2][2].setColour();
                }

                if (figures[2][0] instanceof FigureO && figures[1][1] instanceof FigureO &&
                        figures[0][2] instanceof FigureO) {
                    winningConditions = true;
                    figures[2][0].setColour();
                    figures[1][1].setColour();
                    figures[0][2].setColour();
                }
    }

    private Player opponent(Player whichTurn) {
        return whichTurn == Player.PLAYERX ? Player.PLAYERO : Player.PLAYERX;
    }
}
