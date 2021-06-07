/**
 * Class: LoginScene
 * Author: Robert Stevenson
 * Contributing Author(s):
 *
 * Date Created: 06/06/2021
 *
 * Description:
 *
 */

// TODO: testing login process
// TODO: No field reseting/clearing

package WaterDistibution.Scenes;


import WaterDistibution.Controllers.LoginController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;


public class LoginScene extends Pane {

   private static final double PREF_WIDTH = 640;
   private static final double PREF_HEIGHT = 480;

   private VBox primaryBox = new VBox();
   private HBox hBoxBtnBar = new HBox();
   private GridPane grid = new GridPane();
   private Label lblTitle = new Label("Water Distribution Utility Software");
   private Label lblUsername = new Label("Username: ");
   private Label lblPassword = new Label("Password: ");
   private TextField txtUsername = new TextField();
   private TextField txtPassword = new TextField();
   private Button btnLogin = new Button("Login");

   public LoginScene() {
      setupLayout();
      setupEvents();
   }

   //setup the login windows layout
   private void setupLayout() {
      //set grid line visible (debugging only)
      //grid.setGridLinesVisible(true);

      //set the login screen size
      this.setPrefWidth(PREF_WIDTH);
      this.setPrefHeight(PREF_HEIGHT);
      this.setWidth(PREF_WIDTH);
      this.setHeight(PREF_WIDTH);

      //bind the scaling of the primary parent node component to the Login scenes current dimensions
      primaryBox.prefHeightProperty().bind(this.heightProperty());
      primaryBox.prefWidthProperty().bind(this.widthProperty());

      //set the parent primary Box that contains the components of the scene
      this.getChildren().add(primaryBox);

      //bind the scaling of the grid to the primary parent node component
      grid.prefWidthProperty().bind(primaryBox.widthProperty());

      //setup the primary container box
      primaryBox.setAlignment(Pos.CENTER);

      //setup the grid used to UI component alignment and positioning
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

      //setup the username label
      lblUsername.setAlignment(Pos.CENTER);
      lblUsername.setFont(Font.font(16));

      //setup the password label
      lblPassword.setAlignment(Pos.CENTER);
      lblPassword.setFont(Font.font(16));

      //setup the username textfield
      txtUsername.setAlignment(Pos.CENTER);
      txtUsername.setFont(Font.font(16));

      //setup the password textfield
      txtPassword.setAlignment(Pos.CENTER);
      txtPassword.setFont(Font.font(16));

      //setup the Login button
      btnLogin.setAlignment(Pos.CENTER);
      btnLogin.setMinSize(100,60);

      //setup the HBox that will serve as the button bar on the window
      hBoxBtnBar.setAlignment(Pos.TOP_CENTER);
      hBoxBtnBar.setPadding(new Insets(15,0,10,0));

      //add the UI components to the primary container box and grid layout of the login page
      primaryBox.getChildren().add(lblTitle);
      primaryBox.getChildren().add(grid);

      grid.add(lblUsername, 0, 0);
      grid.add(lblPassword,0, 1);
      grid.add(txtUsername,1,0);
      grid.add(txtPassword,1,1);

      primaryBox.getChildren().add(hBoxBtnBar);
      hBoxBtnBar.getChildren().add(btnLogin);

   }

   //setup the events that are assigned to components in the layout
   private void setupEvents() {
      //assign a click event to button for login
      btnLogin.setOnAction(LoginController::btnLoginClicked);

   }

   public String getUsernameValue(){
      return txtUsername.getText();
   }
   public String getPasswordValue(){
      return txtPassword.getText();
   }
}
