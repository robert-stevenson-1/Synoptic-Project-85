package WaterDistibution.Scenes;

/**
 * Class: User Login
 * Author: Sweena Jeyagugan
 *
 * Date created: 10/06/2021
 * Description: This will allow the user to add details when they make a new user account
 */

import WaterDistibution.Controllers.CreateAccountController;
import WaterDistibution.Controllers.DashBoardController;
import WaterDistibution.Controllers.LoginController;
import WaterDistibution.SceneManager;
import WaterDistibution.ThemeConfig;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class CreateUserLogin extends Pane {
    private static final double PREF_WIDTH = 640;
    private static final double PREF_HEIGHT = 480;

    private VBox primaryBox = new VBox();
    private HBox hBoxBtnBar = new HBox();
    private GridPane grid = new GridPane();
    private Label lblTitle = new Label("Water Distribution: Create Account");
    private Label lblFirstName = new Label("First Name");
    private Label lblLastName = new Label("Last Name");
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
    private Button btnCreateAccount = new Button("Create Account");
    private Button btnBack = new Button("Back");


    public CreateUserLogin() {
        setLayout();
        setEvents();

    }



    private void setEvents() {
       btnBack.setOnAction(CreateAccountController::btnBackClicked);
    }




    private void setLayout() {
        this.setPrefHeight(PREF_HEIGHT);
        this.setPrefWidth(PREF_WIDTH);
        this.setHeight(PREF_HEIGHT);
        this.setWidth(PREF_WIDTH);
        this.getChildren().add(btnBack);

        primaryBox.prefWidthProperty().bind(this.heightProperty());
        primaryBox.prefHeightProperty().bind(this.widthProperty());

        this.getChildren().add(primaryBox);

        grid.prefWidthProperty().bind(primaryBox.widthProperty());


        primaryBox.setAlignment(Pos.CENTER);
        primaryBox.setStyle(ThemeConfig.PANEL_COLOUR_1);


        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(20,0,0,0));

        //setup the title label
        lblTitle.setAlignment(Pos.CENTER);
        lblTitle.setFont(Font.font(24));
        lblTitle.setTextAlignment(TextAlignment.CENTER);
        lblTitle.setMinWidth(USE_PREF_SIZE);
        lblTitle.setWrapText(true);

        //setup the FirstName label
        lblFirstName.setAlignment(Pos.CENTER);
        lblFirstName.setFont(Font.font(16));

        //setup the LastName label
        lblLastName.setAlignment(Pos.CENTER);
        lblLastName.setFont(Font.font(16));

        //setup the Date of birth label
        lblDOB.setAlignment(Pos.CENTER);
        lblDOB.setFont(Font.font(16));

        //setup the Gender label
        lblGender.setAlignment(Pos.CENTER);
        lblGender.setFont(Font.font(16));

        //setup the Email label
        lblEmail.setAlignment(Pos.CENTER);
        lblEmail.setFont(Font.font(16));

        //setup the Address label
        lblAddress.setAlignment(Pos.CENTER);
        lblAddress.setFont(Font.font(16));

       //setting up the text field for first name
        firstName.setAlignment(Pos.CENTER);
        firstName.setFont(Font.font(16));

        //setting up the text field for last name
        lastName.setAlignment(Pos.CENTER);
        lastName.setFont(Font.font(16));


    }
}