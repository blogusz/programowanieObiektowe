package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application
{

    @Override
    public void start(Stage primaryStage)
    {
        Label label = new Label("Zwierzak");
        Scene scene = new Scene(label, 400, 400);

        String[] args = getParameters().getRaw().toArray(new String[0]);
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        //System.out.println(map);

        GridPane grid = new GridPane();
        grid.setGridLinesVisible(true);


        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
