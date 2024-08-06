package com.snakeAndLadder.entities;

public class Jump {

    private int jumpStart;
    private int jumpEnd;

    public Jump(int jumpStart, int jumpEnd) {
        this.jumpStart = jumpStart;
        this.jumpEnd = jumpEnd;
    }

    public int getJumpStart() {
        return jumpStart;
    }

    public void setJumpStart(int jumpStart) {
        this.jumpStart = jumpStart;
    }

    public int getJumpEnd() {
        return jumpEnd;
    }

    public void setJumpEnd(int jumpEnd) {
        this.jumpEnd = jumpEnd;
    }
}
