package WaterDistibution;

/**
 * Class: User Login
 * Author: Sweena Jeyagugan
 *
 * Date created: 10/06/2021
 * Description: This will allow the user to add details when they make a new user account
 */

import WaterDistibution.Controllers.DashBoardController;
import WaterDistibution.SceneManager;
import WaterDistibution.ThemeConfig;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

public class CreateUserLogin extends Pane{
    private static final double PREF_WIDTH = 640;
    private static final double PREF_HEIGHT = 480;

    private VBox primaryBox = new VBox();
    private HBox hBoxBtnBar = new HBox();
    private GridPane grid = new GridPane();
    private Label lblTitle = new Label("Create Account");
    private Label lblFirstName = new Label("First Name");
    private Label lblLastName = new Label ("Last Name");

}




