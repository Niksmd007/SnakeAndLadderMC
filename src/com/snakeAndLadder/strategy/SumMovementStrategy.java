package com.snakeAndLadder.strategy;

import java.util.concurrent.ThreadLocalRandom;

public class SumMovementStrategy implements MovementStrategy{
    @Override
    public int calculateDiceValue(int numberOfDice) {
        int diceValue=0;
        for (int i = 0; i < numberOfDice; i++) {
            diceValue += ThreadLocalRandom.current().nextInt(1, 7);
        }
        return diceValue;
    }
}
