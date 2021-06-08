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
      //TODO: User is not logged out in RAM
   }
   public static void btnScheduleClicked(ActionEvent event) {
      System.out.println("btnSchedule clicked!");
      SceneManager.switchDashboardView(SceneManager.getDashboardSchedule());
   }

   public static void btnViewUsageClicked(ActionEvent event) {
      System.out.println("btnViewUsage clicked!");
      SceneManager.switchDashboardView(SceneManager.getDashboardViewWaterUsage());
   }

   public static void btnOverviewClicked(ActionEvent event) {
      System.out.println("btnOverview clicked!");
      SceneManager.switchDashboardView(SceneManager.getDashboardOverview());
   }

}
