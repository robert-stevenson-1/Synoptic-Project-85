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
import WaterDistibution.DataStorage;
import WaterDistibution.SceneManager;
import WaterDistibution.ThemeConfig;
import WaterDistibution.Update;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

public class DashboardScene extends Pane implements Update {

   private static final double PREF_WIDTH = 1280;
   private static final double PREF_HEIGHT = 720;

   private static final int HEADER_MIN_HEIGHT = 75;
   private static final int SIDEBAR_BUTTON_MAX_HEIGHT = 100;
   private static final int SIDEBAR_MIN_WIDTH = 100;
   private static final int SIDEBAR_MAX_WIDTH = 200;

   private BorderPane primaryBox = new BorderPane();
   private Label lblWelcome = new Label("Welcome, " + DataStorage.getCurrentUser().getFirstName());
   private Button btnLogout = new Button("Logout");
   private Button btnOverview = new Button("Overview");
   private Button btnSchedule = new Button("Schedule");
   private Button btnLogLevel = new Button("Log water level");
   private Button btnLogUsage = new Button("Log water usage");
   private Button btnLogPressure = new Button("Log water pressure");
   private Button btnViewRefill = new Button("View Water Level");
   private Button btnViewUsage = new Button("View water usage");
   private Button btnViewPressure = new Button("View water pressure");
   private HBox hBoxHeader = new HBox();
   private VBox vBoxSidePanel = new VBox();
   private Pane paneDashboardView = new Pane();

   public DashboardScene() {
      setupLayout();
      setupEvents();
      //set the default viewport view
      setViewportView(SceneManager.getDashboardOverview());
   }

   private void setupLayout() {
      //set the dashboards window size
      this.setMinWidth(960);
      this.setMinHeight(540);
      this.setPrefWidth(PREF_WIDTH);
      this.setPrefHeight(PREF_HEIGHT);
      this.setWidth(PREF_WIDTH);
      this.setHeight(PREF_WIDTH);
      this.setMaxWidth(1920);
      this.setMaxHeight(1080);

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
      hBoxHeader.setStyle(ThemeConfig.PANEL_COLOUR_1 +
                          ThemeConfig.BORDER +
                          ThemeConfig.BORDER_COLOUR);

      //setup side panel
      vBoxSidePanel.setAlignment(Pos.CENTER);
      vBoxSidePanel.prefHeightProperty().bind(primaryBox.heightProperty());
      vBoxSidePanel.prefWidthProperty().bind(primaryBox.widthProperty().multiply(0.15));
      vBoxSidePanel.setMinWidth(SIDEBAR_MIN_WIDTH);
      //vBoxSidePanel.setMaxWidth(SIDEBAR_MAX_WIDTH);
      vBoxSidePanel.setStyle(ThemeConfig.PANEL_COLOUR_1 +
                             ThemeConfig.BORDER +
                             ThemeConfig.BORDER_COLOUR);

      //setup overview button
      btnOverview.prefWidthProperty().bind(vBoxSidePanel.widthProperty());
      btnOverview.setMaxHeight(SIDEBAR_BUTTON_MAX_HEIGHT);
      btnOverview.setStyle(ThemeConfig.BUTTON_THEME +
              ThemeConfig.BORDER_COLOUR);
      btnOverview.setWrapText(true);

      //setup schedule button
      btnSchedule.prefWidthProperty().bind(vBoxSidePanel.widthProperty());
      btnSchedule.setMaxHeight(SIDEBAR_BUTTON_MAX_HEIGHT);
      btnSchedule.setStyle(ThemeConfig.BUTTON_THEME +
              ThemeConfig.BORDER_COLOUR);
      btnSchedule.setWrapText(true);

      //setup log refill button
      btnLogLevel.prefWidthProperty().bind(vBoxSidePanel.widthProperty());
      btnLogLevel.setMaxHeight(SIDEBAR_BUTTON_MAX_HEIGHT);
      btnLogLevel.setStyle(ThemeConfig.BUTTON_THEME +
                            ThemeConfig.BORDER_COLOUR);
      btnLogLevel.setWrapText(true);

      //setup log water usage button
      btnLogUsage.prefWidthProperty().bind(vBoxSidePanel.widthProperty());
      btnLogUsage.setMaxHeight(SIDEBAR_BUTTON_MAX_HEIGHT);
      btnLogUsage.setStyle(ThemeConfig.BUTTON_THEME +
                           ThemeConfig.BORDER_COLOUR);
      btnLogUsage.setWrapText(true);

      //setup log water pressure button
      btnLogPressure.prefWidthProperty().bind(vBoxSidePanel.widthProperty());
      btnLogPressure.setMaxHeight(SIDEBAR_BUTTON_MAX_HEIGHT);
      btnLogPressure.setStyle(ThemeConfig.BUTTON_THEME +
                              ThemeConfig.BORDER_COLOUR);
      btnLogPressure.setWrapText(true);

      //setup view refill rate
      btnViewRefill.prefWidthProperty().bind(vBoxSidePanel.widthProperty());
      btnViewRefill.setMaxHeight(SIDEBAR_BUTTON_MAX_HEIGHT);
      btnViewRefill.setStyle(ThemeConfig.BUTTON_THEME +
                             ThemeConfig.BORDER_COLOUR);
      btnViewRefill.setWrapText(true);

      //setup view water usage
      btnViewUsage.prefWidthProperty().bind(vBoxSidePanel.widthProperty());
      btnViewUsage.setMaxHeight(SIDEBAR_BUTTON_MAX_HEIGHT);
      btnViewUsage.setStyle(ThemeConfig.BUTTON_THEME +
                            ThemeConfig.BORDER_COLOUR);
      btnViewUsage.setWrapText(true);

      //setup view water pressure
      btnViewPressure.prefWidthProperty().bind(vBoxSidePanel.widthProperty());
      btnViewPressure.setMaxHeight(SIDEBAR_BUTTON_MAX_HEIGHT);
      btnViewPressure.setStyle(ThemeConfig.BUTTON_THEME +
                               ThemeConfig.BORDER_COLOUR);
      btnViewPressure.setWrapText(true);

      //setup logout button
      btnLogout.prefWidthProperty().bind(vBoxSidePanel.widthProperty());
      btnLogout.setMaxHeight(SIDEBAR_BUTTON_MAX_HEIGHT);
      btnLogout.setStyle(ThemeConfig.BUTTON_THEME +
                         ThemeConfig.BORDER_COLOUR);
      btnLogout.setWrapText(true);

      //setup dashboards view
      paneDashboardView.setStyle(ThemeConfig.PANEL_COLOUR_2);

      //add the UI components to the primary container box of the dashboard page
      primaryBox.setTop(hBoxHeader);
      primaryBox.setLeft(vBoxSidePanel);

      primaryBox.setCenter(paneDashboardView);

      hBoxHeader.getChildren().add(lblWelcome);

      vBoxSidePanel.getChildren().add(btnOverview);
      vBoxSidePanel.getChildren().add(btnSchedule);
      vBoxSidePanel.getChildren().add(btnLogLevel);
      vBoxSidePanel.getChildren().add(btnLogUsage);
      vBoxSidePanel.getChildren().add(btnLogPressure);
      vBoxSidePanel.getChildren().add(btnViewRefill);
      vBoxSidePanel.getChildren().add(btnViewUsage);
      vBoxSidePanel.getChildren().add(btnViewPressure);
      vBoxSidePanel.getChildren().add(btnLogout);
   }

   private void setupEvents() {
      btnOverview.setOnAction(DashBoardController::btnOverviewClicked);
      btnSchedule.setOnAction(DashBoardController::btnScheduleClicked);
      btnLogUsage.setOnAction(DashBoardController::btnLogUsageClicked);
      btnViewUsage.setOnAction(DashBoardController::btnViewUsageClicked);
      btnLogout.setOnAction(DashBoardController::btnLogoutClicked);
      btnViewRefill.setOnAction(DashBoardController::btnViewLevelClicked);
      btnLogLevel.setOnAction(DashBoardController::btnLogLevelClicked);
      btnLogPressure.setOnAction(DashBoardController::btnLogPressureClicked);
      btnViewPressure.setOnAction(DashBoardController::btnViewPressureClicked);
   }

   public Pane getViewport() {
      return paneDashboardView;
   }

   public void setViewportView(Pane view) {
      view.prefHeightProperty().bind(paneDashboardView.heightProperty());
      view.prefWidthProperty().bind(paneDashboardView.widthProperty());
      paneDashboardView.getChildren().add(view);
   }

   @Override
   public void update() {
      lblWelcome.setText("Welcome, " + DataStorage.getCurrentUser().getName());
   }
}
