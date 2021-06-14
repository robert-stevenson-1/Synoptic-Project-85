/**
 * Class: ViewLogWaterUsageController
 * Author: Robert Stevenson
 * Contributing Author(s):
 * Louis Mayne - added validation function
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
import javafx.scene.control.Alert;

import java.time.LocalDate;

public class ViewLogWaterUsageController {
   public static void btnSubmitClicked(ActionEvent event) {

      if(validateInput()) {
         DataStorage.addWaterUsageLogs(new LogUsage(
                 getLogName(),
                 SceneManager.getDashboardViewLogWaterUsage().getCmbArea().getValue().toString(),
                 SceneManager.getDashboardViewLogWaterUsage().getDatePickerLogDate().getValue(),
                 Integer.parseInt(SceneManager.getDashboardViewLogWaterUsage().getTxtTimeHour().getText()),
                 Integer.parseInt(SceneManager.getDashboardViewLogWaterUsage().getTxtTimeMinute().getText()),
                 Double.parseDouble(SceneManager.getDashboardViewLogWaterUsage().getTxtUsage().getText()))
         );
      }
      System.out.println("LogUsage: btnSubmitClicked");
   }

   private static boolean validateInput(){
      //String errorMsg = "";
      StringBuilder errorMsg = new StringBuilder();

      try{
         String distributedArea = SceneManager.getDashboardViewLogWaterUsage().getCmbArea().getValue().toString();}
      catch(NullPointerException e){
         errorMsg.append("No Distributed Area Selected\n");
      }
      try{
         LocalDate date = SceneManager.getDashboardViewLogWaterUsage().getDatePickerLogDate().getValue();
         if(date==null){
            errorMsg.append("Date Not Entered\n");
         }
      }
      catch(NumberFormatException e){
         errorMsg.append("Date Not Entered\n");
      }
      try {
         Integer hour = Integer.parseInt(SceneManager.getDashboardViewLogWaterUsage().getTxtTimeHour().getText());
         if (hour>23){errorMsg.append("Hour too large\n");}
         else if (hour<0){errorMsg.append("Hour too small\n");}
      }
      catch(NumberFormatException e){errorMsg.append("Hour Not Entered or value isn't an integer\n");}
      try {
         Integer minute = Integer.parseInt(SceneManager.getDashboardViewLogWaterUsage().getTxtTimeMinute().getText());
         if (minute>59){errorMsg.append("Minute too large\n");}
         else if (minute<0){errorMsg.append("Minute too small\n");}
      }
      catch(NumberFormatException e){errorMsg.append("Minute Not Entered or value isn't an integer\n");}
      try {
         Double waterUsage = Double.parseDouble(SceneManager.getDashboardViewLogWaterUsage().getTxtUsage().getText());
         if (waterUsage<0){errorMsg.append("Water Usage too small\n");}
      }
      catch(NumberFormatException e){errorMsg.append("Water Usage Not Entered\n");}

      //no errors in the submitted inputs
      if (errorMsg.toString().equals("")){
         return true;
      }
      //there is an error in the inputs
      new Alert(Alert.AlertType.ERROR, errorMsg.toString()).show();
      return false;
   }

   public static String getLogName(){
      String area = SceneManager.getDashboardViewLogWaterUsage().getCmbArea().getValue().toString();
      String timeHr = SceneManager.getDashboardViewLogWaterUsage().getTxtTimeHour().getText();
      String timeMin = SceneManager.getDashboardViewLogWaterUsage().getTxtTimeMinute().getText();
      String date = SceneManager.getDashboardViewLogWaterUsage().getDatePickerLogDate().getValue().toString();
      return area + "_Water_Usage_" + date + "_" + timeHr + "_" + timeMin;
   }

}
