package WaterDistibution;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        LoginScene loginScene = new LoginScene();
        Scene scene = new Scene(loginScene);

        stage.setTitle("Water Distribution");
        stage.setScene(scene);
        stage.setMinHeight(200);
        stage.setHeight(400);
        stage.setMinWidth(200);
        stage.setWidth(400);

        stage.show();
    }

    public static void main(String[] args) {
	// write your code here
        launch(args);
    }
}
