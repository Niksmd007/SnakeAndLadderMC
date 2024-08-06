package com.snakeAndLadder.GameEngine.impl;

import com.snakeAndLadder.GameEngine.GameEngine;
import com.snakeAndLadder.entities.*;
import com.snakeAndLadder.strategy.*;

import java.util.*;

public class GameEngineImpl implements GameEngine {

    int numberOfPlayers;
    int boardSize;
    int numberOfSnakes;
    int numberOfLadders;
    int numberOfDice;
    MSEnums movementStrategy;

    Board board;

    Player winner;
    List<Snake> snakeList;
    List<Ladder> ladderList;

    List<Player> playerList;

    Deque<Player> playerDeque = new LinkedList<>();

    public GameEngineImpl(){
        this.numberOfPlayers = 2;
        this.boardSize = 10;
        this.numberOfSnakes = 2;
        this.numberOfLadders = 2;
        this.numberOfDice = 2;
        this.movementStrategy = MSEnums.SUM;
        this.snakeList = Arrays.asList(new Snake(12, 2), new Snake(42, 16));

        this.ladderList = Arrays.asList(new Ladder(4, 18), new Ladder(21, 32));
        this.playerList = Arrays.asList(new Player("Saransh", 1), new Player("Shelty", 1));
        board = new Board(10);

        board.addSnakes(snakeList);
        board.addLadders(ladderList);

        playerList.forEach(player -> {
            playerDeque.add(player);
        });
    }

    Player findPlayerTurn(){
        Player player = playerDeque.removeFirst();
        playerDeque.addLast(player);
        return player;
    }

    public int getDiceValue(int numberOfDice, MSEnums movementStrategy){
        switch (movementStrategy){
            case MAX: return MaxMovementStrategy.getInstance().calculateDiceValue(numberOfDice);
            case MIN: return new MinMovementStrategy().calculateDiceValue(numberOfDice);
            case SUM: return new SumMovementStrategy().calculateDiceValue(numberOfDice);
            default: return 0;
        }
    }

    @Override
    public void startGame() {
        try{
            while (winner == null){
                Player playerTurn = findPlayerTurn();
                int diceValue = getDiceValue(numberOfDice, movementStrategy);
                int currentPosition = playerTurn.getCurrentPosition();
                int newPosition = currentPosition + diceValue;
                Jump checkJump = new Cell(newPosition/10, newPosition%10).getJump();
                if(checkJump != null){
                    newPosition = checkJump.getJumpEnd();
                }
                if(newPosition > boardSize*boardSize){
                    winner = playerTurn;
                }
                playerTurn.setCurrentPosition(newPosition);
            }
            System.out.println("Winner is: " + winner);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
