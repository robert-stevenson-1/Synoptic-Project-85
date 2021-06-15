package WaterDistibution.Scenes.DashboardView.Controller;

import WaterDistibution.DataStorage;
import WaterDistibution.Model.LogRefill;
import WaterDistibution.SceneManager;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

import java.time.LocalDate;

public class ViewLogWaterLevelController {
    public static void btnSubmitClicked(ActionEvent event) {

        //TODO: Input validation
        //TODO: Input verification

       if (validateInput()) {
          DataStorage.addWaterRefillLogs(new LogRefill(
                  getLogName(),
                  SceneManager.getDashboardViewLogWaterLevel().getDatePickerLogDate().getValue(),
                  Integer.parseInt(SceneManager.getDashboardViewLogWaterLevel().getTxtTimeHour().getText()),
                  Integer.parseInt(SceneManager.getDashboardViewLogWaterLevel().getTxtTimeHour().getText()),
                  //SceneManager.getDashboardViewLogWaterRefill().getCmbArea().getValue().toString(),
                  Double.parseDouble(SceneManager.getDashboardViewLogWaterLevel().getTxtRefill().getText()))
          );
       }

        System.out.println("LogWaterLevel: btnSubmitClicked");
    }

   private static boolean validateInput(){
      StringBuilder errorMsg = new StringBuilder();

      try{
         LocalDate date = SceneManager.getDashboardViewLogWaterLevel().getDatePickerLogDate().getValue();
         if(date==null){
            errorMsg.append("Date Not Entered\n");
         }
      }
      catch(NumberFormatException e){
         errorMsg.append("Date Not Entered\n");
      }
      try {
         Integer hour = Integer.parseInt(SceneManager.getDashboardViewLogWaterLevel().getTxtTimeHour().getText());
         if (hour>23){errorMsg.append("Hour too large\n");}
         else if (hour<0){errorMsg.append("Hour too small\n");}
      }
      catch(NumberFormatException e){errorMsg.append("Hour Not Entered or value isn't an integer\n");}
      try {
         Integer minute = Integer.parseInt(SceneManager.getDashboardViewLogWaterLevel().getTxtTimeMinute().getText());
         if (minute>59){errorMsg.append("Minute too large\n");}
         else if (minute<0){errorMsg.append("Minute too small\n");}
      }
      catch(NumberFormatException e){errorMsg.append("Minute not entered or value isn't an integer\n");}
      try {
         Double waterLevel = Double.parseDouble(SceneManager.getDashboardViewLogWaterLevel().getTxtRefill().getText());
         if (waterLevel<0){errorMsg.append("Water level can not be less than 0\n");}
      }
      catch(NumberFormatException e){errorMsg.append("Water level not entered\n");}

      //no errors in the submitted inputs
      if (errorMsg.toString().equals("")){
         return true;
      }
      //there is an error in the inputs
      new Alert(Alert.AlertType.ERROR, errorMsg.toString()).show();
      return false;
   }

   public static String getLogName(){
      String timeHr = SceneManager.getDashboardViewLogWaterLevel().getTxtTimeHour().getText();
      String timeMin = SceneManager.getDashboardViewLogWaterLevel().getTxtTimeMinute().getText();
      String date = SceneManager.getDashboardViewLogWaterLevel().getDatePickerLogDate().getValue().toString();
      //TextField waterLevel = SceneManager.getDashboardViewLogWaterRefill().getTxtRefill();
      return  "Water_Level_" + date + "_" + timeHr + "_" + timeMin;
   }
}
