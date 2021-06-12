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

import WaterDistibution.Scenes.LoginScene;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {
//test
    @Override
    public void start(Stage stage) throws Exception {

        DataStorage.loadData();

        stage.setTitle("Water Distribution Utility Software");
        stage.setScene(SceneManager.getCurrentScene());
        stage.sizeToScene();
        stage.setMinHeight(300);
        stage.setMinWidth(410);

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                DataStorage.saveData();
            }
        });

        stage.show();
    }

    public static void main(String[] args) {
	// write your code here
        launch(args);
    }
}
