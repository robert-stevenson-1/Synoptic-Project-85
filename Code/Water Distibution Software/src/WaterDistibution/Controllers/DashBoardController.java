/**
 * Class: DashboardController
 * Author: Robert Stevenson
 * Contributing Author(s):
 *
 * Date Created: 06/06/2021
 *
 * Description:
 *
 *
 */

package WaterDistibution.Controllers;

import WaterDistibution.SceneManager;
import javafx.event.ActionEvent;

public class DashBoardController {
   public static void btnLogoutClicked(ActionEvent event) {
      System.out.println("btnLogout clicked!");
      SceneManager.switchScene(SceneManager.getLoginScene());
   }
}
