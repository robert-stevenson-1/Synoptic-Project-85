package WaterDistibution.Scenes.DashboardView.Controller;

import WaterDistibution.DataStorage;
import WaterDistibution.Model.LogRefill;
import WaterDistibution.SceneManager;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class ViewLogWaterRefillController {
    public static void btnSubmitClicked(ActionEvent event) {

        //TODO: Input validation
        //TODO: Input verification

       DataStorage.addWaterRefillLogs(new LogRefill(
               getLogName(),
               SceneManager.getDashboardViewLogWaterRefill().getDatePickerLogDate().getValue(),
               Integer.parseInt(SceneManager.getDashboardViewLogWaterRefill().getTxtTimeHour().getText()),
               Integer.parseInt(SceneManager.getDashboardViewLogWaterRefill().getTxtTimeHour().getText()),
               SceneManager.getDashboardViewLogWaterRefill().getCmbArea().getValue().toString(),
               Double.parseDouble(SceneManager.getDashboardViewLogWaterRefill().getTxtRefill().getText()))
        );

        System.out.println("LogRefill: btnSubmitClicked");
    }
        public static String getLogName(){

            String timeHr = SceneManager.getDashboardViewLogWaterRefill().getTxtTimeHour().getText();
            String timeMin = SceneManager.getDashboardViewLogWaterRefill().getTxtTimeMinute().getText();
            String date = SceneManager.getDashboardViewLogWaterRefill().getDatePickerLogDate().getValue().toString();
            //TextField waterLevel = SceneManager.getDashboardViewLogWaterRefill().getTxtRefill();
            return  "_Water_Level_" + date + "_" + timeHr + "_" + timeMin;
        }
}
