package com.maxwittig.colorguess.logic;


import javafx.scene.paint.Color;

import java.util.Random;

public enum Colors
{
    RED("red"),
    GREEN("green"),
    YELLOW("yellow"),
    BLUE("blue");

    private String realColor;

    public String getRealColor()
    {
        return realColor;
    }

    Colors(String realColor)
    {
        this.realColor = realColor;
    }

    public static Colors getRandom()
    {
        return Colors.values()[new Random().nextInt(Colors.values().length)];
    }
}
