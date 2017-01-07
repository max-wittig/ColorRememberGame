package com.maxwittig.colorguess.logic;


public enum Difficulty
{
    EASY(10, 2000),
    NORMAL(20, 1500),
    HARD(30, 1000);

    private int stackLength;
    private long sleepTime;

    Difficulty(int stackLength, long sleepTime)
    {
        this.stackLength = stackLength;
        this.sleepTime = sleepTime;
    }

    public int getStackLength()
    {
        return stackLength;
    }

    public long getSleepTime()
    {
        return sleepTime;
    }
}
