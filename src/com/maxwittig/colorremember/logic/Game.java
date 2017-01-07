package com.maxwittig.colorremember.logic;

import com.maxwittig.colorremember.ui.controller.MainController;

import java.util.ArrayList;

public class Game
{
    private Difficulty difficulty;
    private boolean computerPhase = false;
    private ArrayList<Colors> computerColors;
    private ArrayList<Colors> playerColors;
    private MainController mainController;


    public Game(MainController mainController)
    {
        this.mainController = mainController;
        computerColors = new ArrayList<>();
        playerColors = new ArrayList<>();
        difficulty = Difficulty.EASY;

    }

    public void addColor(Colors color)
    {
        //ignore input, if computer is showing colors in stack
        if(computerPhase)
            return;

        playerColors.add(color);
        //check if color is wrong
        if(playerColors.get(playerColors.size()-1) != computerColors.get(playerColors.size()-1))
        {
            //game over
            mainController.showLostDialog();
            mainController.resetGame();
        }
        System.out.println(playerColors);
        System.out.println(computerColors);
        System.out.println(playerColors.equals(computerColors));
        if(playerColors.equals(computerColors))
        {
            nextTurn();
            playerColors.clear();
        }

    }

    public void setDifficulty(Difficulty difficulty)
    {
        this.difficulty = difficulty;
    }

    public void nextTurn()
    {
        //add one(x) to it
        computerColors.add(Colors.getRandom());

        //play existing
        mainController.showColors(computerColors);
    }

    public void setComputerPhase(boolean computerPhase)
    {
        this.computerPhase = computerPhase;
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
