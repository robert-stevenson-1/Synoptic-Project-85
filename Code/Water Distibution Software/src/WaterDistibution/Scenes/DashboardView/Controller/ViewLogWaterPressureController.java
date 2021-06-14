package WaterDistibution.Scenes.DashboardView.Controller;

import WaterDistibution.DataStorage;
import WaterDistibution.Model.LogPressure;
import WaterDistibution.SceneManager;
import javafx.event.ActionEvent;

public class ViewLogWaterPressureController {
    public static void btnSubmitClicked(ActionEvent event) {

        //TODO: Input validation
        //TODO: Input verification

        DataStorage.addWaterPressureLogs(new LogPressure(
                getLogName(),
                SceneManager.getDashboardViewLogWaterPressure().getCmbArea().getValue().toString(),
                SceneManager.getDashboardViewLogWaterPressure().getDatePickerLogDate().getValue(),
                Integer.parseInt(SceneManager.getDashboardViewLogWaterPressure().getTxtTimeHour().getText()),
                Integer.parseInt(SceneManager.getDashboardViewLogWaterPressure().getTxtTimeHour().getText()),
                Double.parseDouble(SceneManager.getDashboardViewLogWaterPressure().getTxtPressure().getText()))
        );

        System.out.println("LogUsage: btnSubmitClicked");
    }

    public static String getLogName(){
        String area = SceneManager.getDashboardViewLogWaterPressure().getCmbArea().toString();
        String timeHr = SceneManager.getDashboardViewLogWaterPressure().getTxtTimeHour().getText();
        String timeMin = SceneManager.getDashboardViewLogWaterPressure().getTxtTimeMinute().getText();
        String date = SceneManager.getDashboardViewLogWaterPressure().getDatePickerLogDate().getValue().toString();
        return area + "Water_Pressure_" + date + "_" + timeHr + "_" + timeMin;
    }

}


