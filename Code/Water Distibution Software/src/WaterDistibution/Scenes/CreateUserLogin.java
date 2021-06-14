package WaterDistibution.Scenes;

/**
 * Class: User Login
 * Author: Sweena Jeyagugan
 *
 * Date created: 10/06/2021
 * Description: This will allow the user to add details when they make a new user account
 */

import WaterDistibution.Controllers.CreateAccountController;
import WaterDistibution.ThemeConfig;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class CreateUserLogin extends Pane {
    private static final double MIN_WIDTH = 1024;
    private static final double MIN_HEIGHT = 576;
    private static final double PREF_WIDTH = 1280;
    private static final double PREF_HEIGHT = 720;
    private static final double MAX_WIDTH = 1280;
    private static final double MAX_HEIGHT = 720;

    private BorderPane primaryBox = new BorderPane();
    private HBox hBoxBtnBar = new HBox();
    private GridPane grid = new GridPane();
    private Label lblTitle = new Label("Water Distribution: Create Account");
    private Label lblUsername = new Label("Username:");
    private Label lblFirstName = new Label("First Name:");
    private Label lblLastName = new Label("Last Name:");
    private Label lblPassword = new Label("Password:");
    private Label lblpasswordConfirmation = new Label("Confirm Password");
    private TextField username = new TextField();
    private TextField firstName = new TextField();
    private TextField lastName = new TextField();
    private TextField password = new TextField();
    private TextField passwordConfirmation = new TextField();
    private Button btnSubmit = new Button("Submit");
    private Button btnBack = new Button("Back");


    public CreateUserLogin() {
        setLayout();
        setEvents();

    }

    private void setLayout() {
        this.setMinWidth(MIN_WIDTH);
        this.setMinHeight(MIN_HEIGHT);
        this.setPrefWidth(PREF_WIDTH);
        this.setPrefHeight(PREF_HEIGHT);
        this.setWidth(PREF_WIDTH);
        this.setHeight(PREF_WIDTH);
        this.setMaxWidth(MAX_WIDTH);
        this.setMaxHeight(MAX_HEIGHT);

        primaryBox.prefWidthProperty().bind(this.widthProperty());
        primaryBox.prefHeightProperty().bind(this.heightProperty());

        this.getChildren().add(primaryBox);

        grid.prefWidthProperty().bind(primaryBox.widthProperty());

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

        //setup the password label
        lblPassword.setAlignment(Pos.CENTER);
        lblPassword.setFont(Font.font(16));

        //setup the Email label
        lblpasswordConfirmation.setAlignment(Pos.CENTER);
        lblpasswordConfirmation.setFont(Font.font(16));

       //setting up the text field for first name
        firstName.setAlignment(Pos.CENTER);
        firstName.setFont(Font.font(16));

        //setting up the text field for last name
        lastName.setAlignment(Pos.CENTER);
        lastName.setFont(Font.font(16));

        //setting up the text field for password
        password.setAlignment(Pos.CENTER);
        password.setFont(Font.font(16));

        //setting up the text field for passwordConfirmation
        passwordConfirmation.setAlignment(Pos.CENTER);
        passwordConfirmation.setFont(Font.font(16));

        //setup the Back button
        btnBack.setAlignment(Pos.CENTER);
        btnBack.setMinSize(100,60);
        btnBack.setStyle(ThemeConfig.BUTTON_THEME + ThemeConfig.BORDER_COLOUR);

        //setup the Back button
        btnSubmit.setAlignment(Pos.CENTER);
        btnSubmit.setMinSize(100,60);
        btnSubmit.setStyle(ThemeConfig.BUTTON_THEME + ThemeConfig.BORDER_COLOUR);

        //setup the HBox that will serve as the button bar on the window
        hBoxBtnBar.setAlignment(Pos.TOP_CENTER);
        hBoxBtnBar.setPadding(new Insets(15,0,10,0));

        grid.add(lblFirstName,0,0);
        grid.add(firstName,1,0);
        grid.add(lblLastName,2,0);
        grid.add(lastName,3,0);
        grid.add(lblUsername,0,1);
        grid.add(username,1,1);
        grid.add(lblPassword,0,2);
        grid.add(password,1,2);
        grid.add(lblpasswordConfirmation,2,2);
        grid.add(passwordConfirmation,3,2);

        hBoxBtnBar.getChildren().add(btnBack);
        hBoxBtnBar.getChildren().add(btnSubmit);

        primaryBox.setTop(lblTitle);
        primaryBox.setCenter(grid);
        primaryBox.setBottom(hBoxBtnBar);
    }

    private void setEvents() {
        btnSubmit.setOnAction(CreateAccountController::btnSubmitClicked);
        btnBack.setOnAction(CreateAccountController::btnBackClicked);
    }

    public String getUsername() {
        return username.getText();
    }

    public String getFirstName() {
        return firstName.getText();
    }

    public String getLastName() {
        return lastName.getText();
    }

    public String getPassword() {
        return password.getText();
    }
}