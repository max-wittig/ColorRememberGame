package com.maxwittig.colorremember.ui.controller;


import com.maxwittig.colorremember.logic.Colors;
import com.maxwittig.colorremember.logic.Game;
import com.maxwittig.colorremember.ui.handler.ButtonHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;

public class MainController extends Controller
{

    @FXML private Button greenButton;
    @FXML private Button redButton;
    @FXML private Button blueButton;
    @FXML private Button yellowButton;
    @FXML private Label gameStatusLabel;
    private Game game;
    private ButtonHandler buttonHandler;

    public void showColors(ArrayList<Colors> colors)
    {
        gameStatusLabel.setText("Turns: "+ game.getCurrentRound());
        game.setCurrentRound(game.getCurrentRound() +1);
        buttonHandler.clearColor();
        game.setComputerPhase(true);

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
                game.setComputerPhase(false);
            }
        });

        thread.start();

    }

    public void showLostDialog()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Better luck next time!");
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
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("© Max Wittig 2017");
        alert.setTitle("Credits");
        alert.show();
    }

    @FXML
    private void blueButtonClicked()
    {
        if(game != null)
            game.addColor(Colors.BLUE);
    }

    @FXML
    private void greenButtonClicked()
    {
        if(game != null)
            game.addColor(Colors.GREEN);
    }


    @FXML
    private void redButtonClicked()
    {
        if(game != null)
            game.addColor(Colors.RED);
    }

    @FXML
    private void yellowButtonClicked()
    {
        if(game != null)
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
            gameStartStage.setTitle("New Game");
            gameStartStage.setScene(scene);
            gameStartStage.initModality(Modality.APPLICATION_MODAL);
            gameStartStage.initOwner(stage.getOwner());
            ((GameStartController) loader.getController()).init(gameStartStage, this);
            gameStartStage.showAndWait();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public Game getGame()
    {
        return game;
    }
}
