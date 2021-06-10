/**
 * Class: ViewLogWaterUsageController
 * Author: Robert Stevenson
 * Contributing Author(s):
 *
 * Date Created: 10/06/2021
 *
 * Description:
 *
 */
package WaterDistibution.Scenes.DashboardView.Controller;

import WaterDistibution.DataStorage;
import WaterDistibution.Model.LogUsage;
import WaterDistibution.SceneManager;
import javafx.event.ActionEvent;

public class ViewLogWaterUsageController {
   public static void btnSubmitClicked(ActionEvent event) {

      //TODO: Input validation
      //TODO: Input verification

      DataStorage.addWaterUsageLogs(new LogUsage(
              getLogName(),
              SceneManager.getDashboardViewLogWaterUsage().getCmbArea().getValue().toString(),
              SceneManager.getDashboardViewLogWaterUsage().getDatePickerLogDate().getValue(),
              Integer.parseInt(SceneManager.getDashboardViewLogWaterUsage().getTxtTimeHour().getText()),
              Integer.parseInt(SceneManager.getDashboardViewLogWaterUsage().getTxtTimeHour().getText()),
              Double.parseDouble(SceneManager.getDashboardViewLogWaterUsage().getTxtUsage().getText()))
      );

      System.out.println("LogUsage: btnSubmitClicked");
   }

   public static String getLogName(){
      String area = SceneManager.getDashboardViewLogWaterUsage().getCmbArea().getValue().toString();
      String timeHr = SceneManager.getDashboardViewLogWaterUsage().getTxtTimeHour().getText();
      String timeMin = SceneManager.getDashboardViewLogWaterUsage().getTxtTimeMinute().getText();
      String date = SceneManager.getDashboardViewLogWaterUsage().getDatePickerLogDate().getValue().toString();
      return area + "_Water_Usage_" + date + "_" + timeHr + "_" + timeMin;
   }

}
