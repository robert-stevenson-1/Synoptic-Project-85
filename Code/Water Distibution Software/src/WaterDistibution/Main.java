/**
 * Class: Main
 * Author: Robert Stevenson
 * Contributing Author(s):
 *
 * Date Created: 06/06/2021
 *
 * Description:
 *
 */

package WaterDistibution;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        LoginScene loginScene = new LoginScene();
        Scene scene = new Scene(loginScene);

        //binding for the login scene to scale to the program window
        loginScene.prefHeightProperty().bind(stage.heightProperty());
        loginScene.prefWidthProperty().bind(stage.widthProperty());

        stage.setTitle("Water Distribution Utility Software");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.setMinHeight(300);
        stage.setHeight(300);
        stage.setMinWidth(410);
        stage.setWidth(410);
        stage.show();
    }

    public static void main(String[] args) {
	// write your code here
        launch(args);
    }
}
