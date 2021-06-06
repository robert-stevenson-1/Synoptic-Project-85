/**
 * Class: LoginController
 * Author: Robert Stevenson
 * Contributing Author(s):
 *
 * Date Created: 06/06/2021
 *
 * Description:
 *
 */
package WaterDistibution.Controllers;

import WaterDistibution.SceneManager;
import javafx.event.ActionEvent;
import javafx.scene.Scene;

public class LoginController {

   public static void btnLoginClicked(ActionEvent event) {
      System.out.println("btnLogin clicked!");
      //use the scene manager to change the scene of the program
      SceneManager.switchScene(SceneManager.getDashboardScene());
   }
}
