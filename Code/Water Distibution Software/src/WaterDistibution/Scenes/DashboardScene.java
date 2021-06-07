/**
 * Class: DashboardScene
 * Author: Robert Stevenson
 * Contributing Author(s):
 *
 * Date Created: 06/06/2021
 *
 * Description:
 *
 */
package WaterDistibution.Scenes;

import WaterDistibution.Controllers.DashBoardController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;

public class DashboardScene extends Pane {

   private static final double PREF_WIDTH = 1280;
   private static final double PREF_HEIGHT = 720;

   private static final int HEADER_MIN_HEIGHT = 75;
   private static final int SIDEBAR_BUTTON_MAX_HEIGHT = 50;
   private static final int SIDEBAR_MIN_WIDTH = 200;

   private static final String PANEL_COLOUR_1 =  "-fx-background-color: rgb(189,189,189)";
   private static final String PANEL_COLOUR_2 =  "-fx-background-color: rgb(213,213,213)";
   

   private BorderPane primaryBox = new BorderPane();
   private Button btnLogout = new Button("Logout");
   private Button btnSchedule = new Button("Schedule");
   private Button btnLogRefill = new Button("Log refill rate");
   private Button btnLogUsage = new Button("Log water usage");
   private Button btnLogPressure = new Button("Log water pressure");
   private Button btnViewRefill = new Button("View refill rate");
   private Button btnViewUsage = new Button("View water usage");
   private Button btnViewPressure = new Button("View water pressure");
   private HBox hBoxHeader = new HBox();
   private GridPane grid = new GridPane();
   private VBox vBoxSidePanel = new VBox();
   private Pane paneDashboardView = new Pane();

   public DashboardScene() {
      setupLayout();
      setupEvents();
   }

   private void setupLayout() {
      //set the dashboards window size
      this.setMinWidth(1024);
      this.setMinHeight(576);
      this.setPrefWidth(PREF_WIDTH);
      this.setPrefHeight(PREF_HEIGHT);
      this.setWidth(PREF_WIDTH);
      this.setHeight(PREF_WIDTH);

      //set the parent primary Box that contains the components of the scene
      this.getChildren().add(primaryBox);

      //bind the scaling of the primary parent node component to the Login scenes current dimensions
      primaryBox.prefHeightProperty().bind(this.heightProperty());
      primaryBox.prefWidthProperty().bind(this.widthProperty());

      //setup the primary container box
      //primaryBox.setAlignment(Pos.CENTER);

      //setup the header box
      hBoxHeader.setAlignment(Pos.CENTER);
      hBoxHeader.prefWidthProperty().bind(primaryBox.widthProperty());
      hBoxHeader.setMinHeight(HEADER_MIN_HEIGHT);
      hBoxHeader.setStyle(PANEL_COLOUR_1);

      //setup side panel
      vBoxSidePanel.setAlignment(Pos.CENTER);
      vBoxSidePanel.prefHeightProperty().bind(primaryBox.heightProperty());
      vBoxSidePanel.setMinWidth(SIDEBAR_MIN_WIDTH);
      vBoxSidePanel.setStyle(PANEL_COLOUR_1);

      //setup schedule button
      btnSchedule.prefWidthProperty().bind(vBoxSidePanel.widthProperty());
      btnSchedule.setMaxHeight(SIDEBAR_BUTTON_MAX_HEIGHT);

      //setup log refill button
      btnLogRefill.prefWidthProperty().bind(vBoxSidePanel.widthProperty());
      btnLogRefill.setMaxHeight(SIDEBAR_BUTTON_MAX_HEIGHT);

      //setup log water usage button
      btnLogUsage.prefWidthProperty().bind(vBoxSidePanel.widthProperty());
      btnLogUsage.setMaxHeight(SIDEBAR_BUTTON_MAX_HEIGHT);

      //setup log water pressure button
      btnLogPressure.prefWidthProperty().bind(vBoxSidePanel.widthProperty());
      btnLogPressure.setMaxHeight(SIDEBAR_BUTTON_MAX_HEIGHT);

      //setup view refill rate
      btnViewRefill.prefWidthProperty().bind(vBoxSidePanel.widthProperty());
      btnViewRefill.setMaxHeight(SIDEBAR_BUTTON_MAX_HEIGHT);

      //setup view water usage
      btnViewUsage.prefWidthProperty().bind(vBoxSidePanel.widthProperty());
      btnViewUsage.setMaxHeight(SIDEBAR_BUTTON_MAX_HEIGHT);

      //setup view water pressure
      btnViewPressure.prefWidthProperty().bind(vBoxSidePanel.widthProperty());
      btnViewPressure.setMaxHeight(SIDEBAR_BUTTON_MAX_HEIGHT);

      //setup logout button
      btnLogout.prefWidthProperty().bind(vBoxSidePanel.widthProperty());
      btnLogout.setMaxHeight(SIDEBAR_BUTTON_MAX_HEIGHT);

      //setup dashboards view
      paneDashboardView.setStyle(PANEL_COLOUR_2);

      //setup grid
      //set grid line visible (debugging only)
      grid.setGridLinesVisible(true);
      grid.prefHeightProperty().bind(paneDashboardView.heightProperty());
      grid.prefWidthProperty().bind(paneDashboardView.widthProperty());
      grid.setAlignment(Pos.CENTER);
      grid.setVgap(25);
      grid.setHgap(25);


      //add the UI components to the primary container box of the dashboard page
      primaryBox.setTop(hBoxHeader);
      primaryBox.setLeft(vBoxSidePanel);

      primaryBox.setCenter(paneDashboardView);
      paneDashboardView.getChildren().add(grid);

      vBoxSidePanel.getChildren().add(btnSchedule);
      vBoxSidePanel.getChildren().add(btnLogRefill);
      vBoxSidePanel.getChildren().add(btnLogUsage);
      vBoxSidePanel.getChildren().add(btnLogPressure);
      vBoxSidePanel.getChildren().add(btnViewRefill);
      vBoxSidePanel.getChildren().add(btnViewUsage);
      vBoxSidePanel.getChildren().add(btnViewPressure);
      vBoxSidePanel.getChildren().add(btnLogout);
   }

   private void setupEvents() {
      btnLogout.setOnAction(DashBoardController::btnLogoutClicked);
   }
}
