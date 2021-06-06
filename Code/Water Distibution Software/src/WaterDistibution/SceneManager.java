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
import WaterDistibution.Scenes.LoginScene;
import javafx.scene.Parent;
import javafx.scene.Scene;

public abstract class SceneManager {

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

   public static DashboardScene getDashboardScene() {
      return DASHBOARD_SCENE;
   }

   public static void switchScene(Parent scene){
      currentScene.setRoot(scene);
   }
}
