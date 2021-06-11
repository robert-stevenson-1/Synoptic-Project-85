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
import javafx.scene.control.TextField;
import javafx.scene.layout.*;

public class CreateUserLogin extends Pane{
    private static final double PREF_WIDTH = 640;
    private static final double PREF_HEIGHT = 480;

    private VBox primaryBox = new VBox();
    private HBox hBoxBtnBar = new HBox();
    private GridPane grid = new GridPane();
    private Label lblTitle = new Label("Water Distribution: Create Account");
    private Label lblFirstName = new Label("First Name");
    private Label lblLastName = new Label ("Last Name");
    private Label lblDOB = new Label("Date of Birth");
    private Label lblGender = new Label("Gender");
    private Label lblEmail = new Label("Email Address");
    private Label lblAddress = new Label("Address");
    private TextField firstName = new TextField();
    private TextField lastName = new TextField();
    private TextField DOB = new TextField();
    private TextField Gender = new TextField();
    private TextField Email = new TextField();
    private TextField Address = new TextField();
    private Button butSubmit = new Button ("Submit");

}




