import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CalculatorMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("resourceFile/calculator.fxml"));
        primaryStage.initStyle(StageStyle.TRANSPARENT);

        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Standard Calculator");
        primaryStage.show();
        primaryStage.setResizable(false);
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
