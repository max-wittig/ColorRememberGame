package com.maxwittig.colorremember.ui.controller;


import com.maxwittig.colorremember.logic.Colors;
import com.maxwittig.colorremember.logic.Game;
import com.maxwittig.colorremember.ui.helper.ButtonHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.ArrayList;

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
        buttonHandler.clearColor();
        Thread thread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                for(Colors currentColor : colors)
                {
                    try
                    {
                        //otherwise same color wouldn't even appear
                        Thread.sleep(500);
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

    public void showLostDialog()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Lost");
        alert.show();
    }

    public void resetGame()
    {
        game = new Game(this);
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

    @FXML
    private void onNewGameMenuItemClicked()
    {
        try
        {

            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("com/maxwittig/colorremember/ui/fxml/game_start_controller.fxml"));
            Parent root = (Parent) loader.load();

            Scene scene = new Scene(root);
            Stage gameStartStage = new Stage();
            gameStartStage.setScene(scene);
            gameStartStage.show();
            ((GameStartController) loader.getController()).init(gameStartStage, this);


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
