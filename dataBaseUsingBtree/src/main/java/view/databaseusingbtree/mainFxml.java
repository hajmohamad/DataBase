package view.databaseusingbtree;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class mainFxml extends Application {
    static  Stage baseStage ;
    public static  void reloadScreen() {
        FXMLLoader fxmlLoader = new FXMLLoader(mainFxml.class.getResource("main_fxml.fxml"));
        try {
            Scene  scene = new Scene(fxmlLoader.load(), 1300, 600);
            baseStage.setScene(scene);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }




    }
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(mainFxml.class.getResource("main_fxml.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1300, 600);
        stage.setScene(scene);
        baseStage=stage;
        stage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}