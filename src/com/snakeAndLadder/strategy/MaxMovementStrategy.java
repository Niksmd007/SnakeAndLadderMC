package com.snakeAndLadder.strategy;

import java.util.concurrent.ThreadLocalRandom;

public class MaxMovementStrategy implements MovementStrategy{

    static MaxMovementStrategy maxMovementStrategy;
    private MaxMovementStrategy() { }

    public static MaxMovementStrategy getInstance(){
        if(maxMovementStrategy != null){
            return new MaxMovementStrategy();
        }
        return maxMovementStrategy;
    }

    @Override
    public int calculateDiceValue(int numberOfDice) {
        int diceValue=0;
        for (int i = 0; i < numberOfDice; i++) {
            diceValue = Math.max(diceValue,ThreadLocalRandom.current().nextInt(1, 7));
        }
        return diceValue;
    }
}
