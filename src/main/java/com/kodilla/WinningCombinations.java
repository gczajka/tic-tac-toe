package com.kodilla;

public class WinningCombinations {
    private Figure[] figures;

    public WinningCombinations(Figure... figures) {
        this.figures = figures;
    }

    public boolean checkForWin() {
        if (figures[0] instanceof FigureNone || figures[1] instanceof FigureNone || figures[2] instanceof FigureNone ) {
            return false;
        } else if (figures[0] instanceof FigureX && figures[1] instanceof FigureX && figures[2] instanceof FigureX) {
            return true;
        } else if (figures[0] instanceof FigureO && figures[1] instanceof FigureO && figures[2] instanceof FigureO) {
            return true;
        } else {
            return false;
        }
    }

    public Figure[] getFigures() {
        return figures;
    }
}
