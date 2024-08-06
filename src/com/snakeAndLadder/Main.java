package com.snakeAndLadder;

import com.snakeAndLadder.GameEngine.impl.GameEngineImpl;

public class Main {

    public static void main(String[] args) {
        GameEngineImpl gameEngine = new GameEngineImpl();
        gameEngine.startGame();
    }
}
