package com.maxwittig.colorremember.main;

import com.maxwittig.colorremember.ui.controller.MainController;
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
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("com/maxwittig/colorremember/ui/fxml/main_controller.fxml"));
            Parent root = (Parent) loader.load();

            Scene scene = new Scene(root, 800, 600);
            scene.getStylesheets().add(getClass().getResource("/com/maxwittig/colorremember/ui/css/style.css").toString());

            ((MainController) loader.getController()).init(primaryStage, null);

            primaryStage.setTitle("ColorRemember");
            primaryStage.setScene(scene);
            primaryStage.setResizable(true);
            primaryStage.setMinWidth(800);
            primaryStage.setMinHeight(600);

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
