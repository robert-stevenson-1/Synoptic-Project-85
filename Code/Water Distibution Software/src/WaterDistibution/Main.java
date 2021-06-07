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
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Water Distribution Utility Software");
        stage.setScene(SceneManager.getCurrentScene());
        stage.sizeToScene();
        stage.setMinHeight(300);
        stage.setMinWidth(410);

        DataStorage.loadData();

        stage.show();
    }

    public static void main(String[] args) {
	// write your code here
        launch(args);
    }
}
