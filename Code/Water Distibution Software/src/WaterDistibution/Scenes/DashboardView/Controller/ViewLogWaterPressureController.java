package WaterDistibution.Scenes.DashboardView.Controller;

import WaterDistibution.DataStorage;
import WaterDistibution.Model.LogPressure;
import WaterDistibution.Model.LogUsage;
import WaterDistibution.SceneManager;
import javafx.event.ActionEvent;

public class ViewLogWaterPressureController {
    public static void btnSubmitClicked(ActionEvent event) {

        //TODO: Input validation
        //TODO: Input verification

        DataStorage.addWaterPressureLogs(new LogPressure(
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


