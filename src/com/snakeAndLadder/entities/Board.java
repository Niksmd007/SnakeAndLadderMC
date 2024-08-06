package com.snakeAndLadder.entities;

import java.util.List;

public class Board {
    private int boardSize;

    Cell[][] cells;

    public Board(int boardSize) {
        cells  = new Cell[boardSize][boardSize];
        for(int i=0;i<boardSize;i++){
            for (int j=0;j<boardSize;j++){
                Cell cellObj = new Cell(i, j);
                cells[i][j] = cellObj;
            }
        }
        for(int i=0;i<boardSize;i++) {
            for (int j = 0; j < boardSize; j++) {
                System.out.println("Cells:  " + cells[i][j].getJump().getJumpStart() + " -> " + cells[i][j].getJump().getJumpEnd());
            }
        }
        this.cells = new Cell[boardSize][boardSize];
        this.boardSize = boardSize;
    }

    public void addSnakes(List<Snake> snakeList){
        for (int i = 0; i < snakeList.size(); i++) {
            System.out.println("Adding Snakes from: " + snakeList.get(i).head + " to " + snakeList.get(i).tail);
            int x = snakeList.get(i).head/boardSize;
            int y = (snakeList.get(i).head)%boardSize;
            System.out.println("the position: " + x + " -> " + y + " -> " + snakeList.get(i).head);
            System.out.println(" -> " + snakeList.get(i).tail);
            cells[snakeList.get(i).head/boardSize][(snakeList.get(i).head)%boardSize].setJump(new Jump(snakeList.get(i).head, snakeList.get(i).tail));
        }
    }


    public void addLadders(List<Ladder> laddersList){
        for (int i = 0; i < laddersList.size(); i++) {
            System.out.println("Adding Ladder from: " + laddersList.get(i).start + " to " + laddersList.get(i).end);
            cells[laddersList.get(i).start/boardSize][(laddersList.get(i).end)%boardSize].setJump(new Jump(laddersList.get(i).start, laddersList.get(i).end));
        }
    }
}
