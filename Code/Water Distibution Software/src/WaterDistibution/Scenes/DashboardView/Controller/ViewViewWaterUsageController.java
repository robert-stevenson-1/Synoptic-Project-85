/**
 * Class: ViewViewWaterUsageController
 * Author: Robert Stevenson
 * Contributing Author(s):
 *
 * Date Created: 11/06/2021
 *
 * Description:
 *
 */
package WaterDistibution.Scenes.DashboardView.Controller;

import WaterDistibution.SceneManager;
import javafx.event.ActionEvent;

public class ViewViewWaterUsageController {

   public static void btnPrevMonthClicked(javafx.event.ActionEvent event){
      SceneManager.getDashboardViewViewWaterUsage().decrementMonth();
      SceneManager.getDashboardViewViewWaterUsage().update();
      System.out.println("ViewUsage: btnPrevMonthClicked");
   }

   public static void btnNextMonthClicked(ActionEvent event){
      SceneManager.getDashboardViewViewWaterUsage().incrementMonth();
      SceneManager.getDashboardViewViewWaterUsage().update();
      System.out.println("ViewUsage: btnNextMonthClicked");
   }

}
