/**
 * Class: SceneManager
 * Author: Robert Stevenson
 * Contributing Author(s):
 *
 * Date Created: 06/06/2021
 *
 * Description:
 *
 */
package WaterDistibution;

import WaterDistibution.Scenes.CreateAccountScene;
import WaterDistibution.Scenes.CreateUserLogin;
import WaterDistibution.Scenes.DashboardScene;
import WaterDistibution.Scenes.DashboardView.View.*;
import WaterDistibution.Scenes.DashboardView.View.Schedule.ViewSchedule;
import WaterDistibution.Scenes.LoginScene;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public abstract class SceneManager {

   private static final ViewOverview DASHBOARD_OVERVIEW = new ViewOverview();
   private static final ViewSchedule DASHBOARD_SCHEDULE = new ViewSchedule();
   private static final ViewViewWaterUsage DASHBOARD_VIEW_VIEW_WATER_USAGE = new ViewViewWaterUsage();
   private static final ViewLogWaterUsage DASHBOARD_VIEW_LOG_WATER_USAGE = new ViewLogWaterUsage();
   private static final ViewViewWaterRefill DASHBOARD_VIEW_VIEW_WATER_REFILL= new ViewViewWaterRefill();
   private static final ViewLogWaterRefill DASHBOARD_VIEW_LOG_WATER_REFILL = new ViewLogWaterRefill();
   private static final ViewLogWaterPressure DASHBOARD_VIEW_LOG_WATER_PRESSURE = new ViewLogWaterPressure();
   private static final ViewViewWaterPressure DASHBOARD_VIEW_VIEW_WATER_PRESSURE = new ViewViewWaterPressure();

   private static final LoginScene LOGIN_SCENE = new LoginScene();
   private static final DashboardScene DASHBOARD_SCENE = new DashboardScene();
   private static final CreateUserLogin CREATE_ACCOUNT_SCENE = new CreateUserLogin();

   //current scene that is being stored (default is the login scene)
   private static Scene currentScene = new Scene(LOGIN_SCENE);

   public static Scene getCurrentScene() {
      return currentScene;
   }

   public static LoginScene getLoginScene() {
      return LOGIN_SCENE;
   }

   public static ViewOverview getDashboardOverview() {
      return DASHBOARD_OVERVIEW;
   }

   public static DashboardScene getDashboardScene() {
      return DASHBOARD_SCENE;
   }

   public static ViewLogWaterUsage getDashboardViewLogWaterUsage() {
      return DASHBOARD_VIEW_LOG_WATER_USAGE;
   }

   public static ViewViewWaterUsage getDashboardViewViewWaterUsage() {
      return DASHBOARD_VIEW_VIEW_WATER_USAGE;
   }

   public static ViewSchedule getDashboardSchedule() {
      return DASHBOARD_SCHEDULE;
   }

   public static ViewViewWaterRefill getDashboardViewViewWaterRefill() { return DASHBOARD_VIEW_VIEW_WATER_REFILL; }

   public static ViewLogWaterRefill getDashboardViewLogWaterRefill() {
      return DASHBOARD_VIEW_LOG_WATER_REFILL;
   }

   public static ViewLogWaterPressure getDashboardViewLogWaterPressure() {
      return DASHBOARD_VIEW_LOG_WATER_PRESSURE;
   }

   public static ViewViewWaterPressure getDashboardViewViewWaterPressure(){ return DASHBOARD_VIEW_VIEW_WATER_PRESSURE;}

   public static CreateUserLogin getCreateAccountScene() {
      return CREATE_ACCOUNT_SCENE;
   }

   public static void switchScene(Parent scene){
      currentScene.setRoot(scene);
      ((Stage)currentScene.getWindow()).setMinWidth(((Pane)scene).getMinWidth());
      ((Stage)currentScene.getWindow()).setMinHeight(((Pane)scene).getMinHeight());
      ((Stage)currentScene.getWindow()).setMaxWidth(((Pane)scene).getMaxWidth());
      ((Stage)currentScene.getWindow()).setMaxHeight(((Pane)scene).getMaxHeight());
      currentScene.getWindow().setWidth(((Pane)scene).getPrefWidth());
      currentScene.getWindow().setHeight(((Pane)scene).getPrefHeight());
      currentScene.getWindow().sizeToScene();
      currentScene.getWindow().centerOnScreen();

      if (currentScene instanceof Update){
         ((Update) currentScene).update();
      }

      System.out.println(currentScene.getWidth()  + " " + currentScene.getHeight());
   }

   public static void switchDashboardView(Pane view){
      DASHBOARD_SCENE.getViewport().getChildren().clear();
      DASHBOARD_SCENE.setViewportView(view);
      if (view instanceof Update){
         ((Update) view).update();
      }
      System.out.println(DASHBOARD_SCENE.getViewport());
   }
}
