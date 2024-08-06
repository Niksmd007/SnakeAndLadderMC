package com.snakeAndLadder.entities;

public class Cell {
    private int cellNumber;
    private Jump jump;

    public Cell(int x, int y) {
        this.jump = new Jump((x+1)*(y+1), (x+1)*(y+1));
    }

    public int getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(int cellNumber) {
        this.cellNumber = cellNumber;
    }

    public Jump getJump() {
        return jump;
    }

    public void setJump(Jump jump) {
        this.jump = jump;
    }
}
