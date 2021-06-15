/**
 * Class: ViewLogWaterUsageController
 * Author: Robert Stevenson
 * Contributing Author(s):
 *    Louis Mayne
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
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

import java.time.LocalDate;
import java.util.Optional;

public class ViewLogWaterUsageController {
   public static void btnSubmitClicked(ActionEvent event) {

      if (validateInput()){
         DataStorage.addWaterUsageLogs(new LogUsage(
                 getLogName(),
                 SceneManager.getDashboardViewLogWaterUsage().getCmbArea().getValue().toString(),
                 SceneManager.getDashboardViewLogWaterUsage().getDatePickerLogDate().getValue(),
                 Integer.parseInt(SceneManager.getDashboardViewLogWaterUsage().getTxtTimeHour().getText()),
                 Integer.parseInt(SceneManager.getDashboardViewLogWaterUsage().getTxtTimeHour().getText()),
                 Double.parseDouble(SceneManager.getDashboardViewLogWaterUsage().getTxtUsage().getText()))
         );
         System.out.println("Usage log successfully added");
      }
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

   public static void changedLogNameUpdate(ObservableValue observable, Object oldValue, Object newValue){
      try {
         SceneManager.getDashboardViewLogWaterUsage().setLogName(getLogName());
         System.out.println("Log Name updated");
      } catch (Exception e){
         System.out.println(e);
      }
   }

   private static boolean validateInput(){
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
      return "Water_Usage_" + area + "_" + date + "_" + timeHr + "_" + timeMin;
   }

}
