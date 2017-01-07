package com.maxwittig.colorguess.main;

import com.maxwittig.colorguess.ui.controller.MainController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application
{

    public static void main(String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("com/maxwittig/colorguess/ui/fxml/main_controller.fxml"));
            Parent root = (Parent) loader.load();

            Scene scene = new Scene(root, 800, 600);

            ((MainController) loader.getController()).init(primaryStage, null);

            primaryStage.setTitle("ColorGuess");
            primaryStage.setScene(scene);
            primaryStage.setResizable(true);
            primaryStage.setMinWidth(600);
            primaryStage.setMinHeight(400);

            primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>()
            {
                @Override
                public void handle(WindowEvent event)
                {
                    System.exit(0);
                }
            });

            primaryStage.show();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
