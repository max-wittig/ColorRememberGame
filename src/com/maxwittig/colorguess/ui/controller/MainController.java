package com.maxwittig.colorguess.ui.controller;


import com.maxwittig.colorguess.logic.Colors;
import com.maxwittig.colorguess.logic.Game;
import com.maxwittig.colorguess.ui.helper.ButtonHandler;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Stack;

public class MainController extends Controller
{

    @FXML private Button greenButton;
    @FXML private Button redButton;
    @FXML private Button blueButton;
    @FXML private Button yellowButton;
    private Game game;
    private ButtonHandler buttonHandler;

    public void showColors(ArrayList<Colors> colors)
    {
        Thread thread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                for(Colors currentColor : colors)
                {
                    try
                    {
                        Thread.sleep(100);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }

                    buttonHandler.showColor(currentColor);
                    try
                    {
                        Thread.sleep(game.getDifficulty().getSleepTime());
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    buttonHandler.clearColor();

                }
            }
        });

        thread.start();

    }

    public Button getGreenButton()
    {
        return greenButton;
    }

    public Button getRedButton()
    {
        return redButton;
    }

    public Button getBlueButton()
    {
        return blueButton;
    }

    public Button getYellowButton()
    {
        return yellowButton;
    }

    public ButtonHandler getButtonHandler()
    {
        return buttonHandler;
    }

    @Override
    protected void initController()
    {
        buttonHandler = new ButtonHandler(this);
    }

    @FXML
    private void onAboutItemClicked()
    {

    }

    @FXML
    private void onStartButtonClicked()
    {
        game = new Game(this);
    }

    @FXML
    private void blueButtonClicked()
    {
        game.addColor(Colors.BLUE);
    }

    @FXML
    private void greenButtonClicked()
    {
        game.addColor(Colors.GREEN);
    }


    @FXML
    private void redButtonClicked()
    {
        game.addColor(Colors.RED);
    }

    @FXML
    private void yellowButtonClicked()
    {
        game.addColor(Colors.YELLOW);
    }

}
