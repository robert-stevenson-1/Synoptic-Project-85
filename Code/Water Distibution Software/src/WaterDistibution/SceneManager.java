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

import WaterDistibution.Scenes.DashboardScene;
import WaterDistibution.Scenes.DashboardView.ViewOverview;
import WaterDistibution.Scenes.DashboardView.ViewWaterUsage;
import WaterDistibution.Scenes.LoginScene;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public abstract class SceneManager {

   private static final ViewOverview DASHBOARD_OVERVIEW = new ViewOverview();
   private static final ViewWaterUsage DASHBOARD_VIEW_WATER_USAGE = new ViewWaterUsage();

   private static final LoginScene LOGIN_SCENE = new LoginScene();
   private static final DashboardScene DASHBOARD_SCENE = new DashboardScene();

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

   public static ViewWaterUsage getDashboardViewWaterUsage() {
      return DASHBOARD_VIEW_WATER_USAGE;
   }

   public static void switchScene(Parent scene){
      currentScene.setRoot(scene);
      currentScene.getWindow().setWidth(((Pane)scene).getPrefWidth());
      currentScene.getWindow().setHeight(((Pane)scene).getPrefHeight());
      currentScene.getWindow().sizeToScene();
      currentScene.getWindow().centerOnScreen();

      System.out.println(currentScene.getWidth()  + " " + currentScene.getHeight());
   }

   public static void switchDashboardView(Pane view){
      DASHBOARD_SCENE.getViewport().getChildren().clear();
      DASHBOARD_SCENE.setViewportView(view);
   }
}
