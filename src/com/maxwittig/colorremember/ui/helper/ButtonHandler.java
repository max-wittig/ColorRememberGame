package com.maxwittig.colorremember.ui.helper;


import com.maxwittig.colorremember.ColorUtils;
import com.maxwittig.colorremember.logic.Colors;
import com.maxwittig.colorremember.ui.controller.MainController;
import javafx.scene.paint.Color;

public class ButtonHandler
{
    private MainController mainController;

    public ButtonHandler(MainController mainController)
    {
        this.mainController = mainController;
    }

    public void showColor(Colors color)
    {
        switch (color)
        {
            case BLUE: mainController.getBlueButton().setStyle("-fx-background-color: " + color.getRealColor() + ";");
                break;
            case RED: mainController.getRedButton().setStyle("-fx-background-color: " + color.getRealColor() + ";");
                break;
            case YELLOW: mainController.getYellowButton().setStyle("-fx-background-color: " + color.getRealColor() + ";");
                break;
            case GREEN: mainController.getGreenButton().setStyle("-fx-background-color: " + color.getRealColor() + ";");
                break;
            default:
                break;
        }
    }

    public void clearColor()
    {
        mainController.getBlueButton().setStyle("-fx-background-color: lightgray;");
        mainController.getGreenButton().setStyle("-fx-background-color: lightgray;");
        mainController.getYellowButton().setStyle("-fx-background-color: lightgray;");
        mainController.getRedButton().setStyle("-fx-background-color: lightgray;");
    }
}
