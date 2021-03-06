import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.stage.Stage;


import java.awt.*;
import java.util.ArrayList;

public class Window extends Application{
//textbox button
    public static void main(String args[])
    {
    launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        primaryStage.setWidth(300);
        primaryStage.setHeight(300);

        Box box1 = new Box(300, 50, 20);
        TextField calcLine = new TextField();
        TextField calcOutput = new TextField();
        Button calculate = new Button("CALCULATE");

        box1.setMaterial(new PhongMaterial(Color.BLACK));
        calcOutput.setEditable(false);
        calcOutput.setVisible(false);

        //restrict the characters allowed within the textbox.

        calculate.setOnAction(new EventHandler<ActionEvent>() {//WHEN THE BUTTON IS CLICKED
            @Override
            public void handle(ActionEvent actionEvent) {
                Arithmetic.setLine(calcLine);//THE LINE VARIABLE WILL TAKE THE VALUE FROM THE TEXT
                Arithmetic.setTokens();
                Arithmetic.calculate();
                calcOutput.setText(Arithmetic.getAnswer());
                calcOutput.setVisible(true);
            }
        });





        FlowPane shapes = new FlowPane();
        shapes.getChildren().add(box1);
        shapes.getChildren().add(calcLine);
        shapes.getChildren().add(calculate);
        shapes.getChildren().add(calcOutput);

        Scene scene = new Scene(shapes);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Calculator");
        primaryStage.show();
    }
}
