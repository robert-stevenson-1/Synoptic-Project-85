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

import WaterDistibution.DataStorage;
import WaterDistibution.SceneManager;
import javafx.event.ActionEvent;

public class DashBoardController {
   public static void btnLogoutClicked(ActionEvent event) {
      System.out.println("btnLogout clicked!");
      SceneManager.switchScene(SceneManager.getLoginScene());
      DataStorage.logoutUser();
   }
   public static void btnScheduleClicked(ActionEvent event) {
      System.out.println("btnSchedule clicked!");
      SceneManager.switchDashboardView(SceneManager.getDashboardSchedule());
   }

   public static void btnLogUsageClicked(ActionEvent event) {
      System.out.println("btnLogUsage clicked!");
      SceneManager.switchDashboardView(SceneManager.getDashboardViewLogWaterUsage());
   }

   public static void btnViewUsageClicked(ActionEvent event) {
      System.out.println("btnViewUsage clicked!");
      SceneManager.switchDashboardView(SceneManager.getDashboardViewViewWaterUsage());
   }

   public static void btnOverviewClicked(ActionEvent event) {
      System.out.println("btnOverview clicked!");
      SceneManager.switchDashboardView(SceneManager.getDashboardOverview());
   }

   public static void btnViewLevelClicked(ActionEvent event) {
      System.out.println("btnViewLevel clicked!");
      SceneManager.switchDashboardView(SceneManager.getDashboardViewViewWaterLevel());
   }

   public static void btnLogLevelClicked(ActionEvent event) {
      System.out.println("btnLogLevel clicked!");
      SceneManager.switchDashboardView(SceneManager.getDashboardViewLogWaterLevel());
   }

   public static void btnLogPressureClicked(ActionEvent event) {
      System.out.println("btnLogPressure clicked!");
      SceneManager.switchDashboardView(SceneManager.getDashboardViewLogWaterPressure());
   }

   public static void btnViewPressureClicked(ActionEvent event) {
      System.out.println("btnViewPressure clicked!");
      SceneManager.switchDashboardView(SceneManager.getDashboardViewViewWaterPressure());
   }
}
