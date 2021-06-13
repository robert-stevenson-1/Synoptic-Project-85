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
import WaterDistibution.Scenes.DashboardView.View.DialogAddArea;
import WaterDistibution.Scenes.DashboardView.View.DialogRemoveArea;
import javafx.event.ActionEvent;

import javax.xml.crypto.Data;
import java.util.Optional;

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

   public static void btnAddAreaClicked(ActionEvent event){
      DialogAddArea addArea = new DialogAddArea("Add Distribution Area");
      Optional<String> result = addArea.showAndWait();
      if (result.isPresent()){
         DataStorage.addDistributionArea(result.get());
         System.out.println("Area removed successfully");
         DataStorage.saveDistributionAreas();
         SceneManager.getDashboardViewLogWaterUsage().update();
      }
   }

   public static void btnRemoveAreaClicked(ActionEvent event){
      DialogRemoveArea removeArea = new DialogRemoveArea("Remove Distribution Area");
      Optional<String> result = removeArea.showAndWait();
      if (result.isPresent()){
         DataStorage.removeDistributionArea(result.get());
         System.out.println("Area removed successfully");
         DataStorage.saveDistributionAreas();
         SceneManager.getDashboardViewLogWaterUsage().update();
      }
   }

   public static String getLogName(){
      String area = SceneManager.getDashboardViewLogWaterUsage().getCmbArea().getValue().toString();
      String timeHr = SceneManager.getDashboardViewLogWaterUsage().getTxtTimeHour().getText();
      String timeMin = SceneManager.getDashboardViewLogWaterUsage().getTxtTimeMinute().getText();
      String date = SceneManager.getDashboardViewLogWaterUsage().getDatePickerLogDate().getValue().toString();
      return area + "_Water_Usage_" + date + "_" + timeHr + "_" + timeMin;
   }

}
