package com.maxwittig.colorguess.logic;

import com.maxwittig.colorguess.ui.controller.MainController;

import java.util.ArrayList;

public class Game
{
    private Difficulty difficulty;
    private boolean computerPhase = true;
    private ArrayList<Colors> computerColors;
    private ArrayList<Colors> playerColors;
    private MainController mainController;


    public Game(MainController mainController)
    {
        this.mainController = mainController;
        computerColors = new ArrayList<>();
        playerColors = new ArrayList<>();
        difficulty = Difficulty.EASY;
        next();
    }

    public void addColor(Colors color)
    {
        playerColors.add(color);
        //check if color is wrong
        if(playerColors.get(playerColors.size()-1) != computerColors.get(playerColors.size()-1))
        {
            //game over
            mainController.resetGame();
        }
        System.out.println(playerColors);
        System.out.println(computerColors);
        System.out.println(playerColors.equals(computerColors));
        if(playerColors.equals(computerColors))
        {
            next();
            playerColors.clear();
        }

    }

    private void next()
    {
        //add one(x) to it
        computerColors.add(Colors.getRandom());

        //play existing
        mainController.showColors(computerColors);

    }

    public ArrayList<Colors> getComputerColors()
    {
        return computerColors;
    }

    public Difficulty getDifficulty()
    {
        return difficulty;
    }
}
