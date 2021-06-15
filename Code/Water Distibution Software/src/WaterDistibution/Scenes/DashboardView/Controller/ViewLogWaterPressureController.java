package WaterDistibution.Scenes.DashboardView.Controller;

import WaterDistibution.DataStorage;
import WaterDistibution.Model.LogPressure;
import WaterDistibution.SceneManager;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

import java.time.LocalDate;

public class ViewLogWaterPressureController {
    public static void btnSubmitClicked(ActionEvent event) {

        //TODO: Input validation
        //TODO: Input verification

        if (validateInput()) {
            DataStorage.addWaterPressureLogs(new LogPressure(
                    getLogName(),
                    SceneManager.getDashboardViewLogWaterPressure().getCmbArea().getValue().toString(),
                    SceneManager.getDashboardViewLogWaterPressure().getDatePickerLogDate().getValue(),
                    Integer.parseInt(SceneManager.getDashboardViewLogWaterPressure().getTxtTimeHour().getText()),
                    Integer.parseInt(SceneManager.getDashboardViewLogWaterPressure().getTxtTimeHour().getText()),
                    Double.parseDouble(SceneManager.getDashboardViewLogWaterPressure().getTxtPressure().getText()))
            );
        }

        System.out.println("LogUsage: btnSubmitClicked");
    }

    private static boolean validateInput(){
        StringBuilder errorMsg = new StringBuilder();

        try{
            String distributedArea = SceneManager.getDashboardViewLogWaterPressure().getCmbArea().getValue().toString();}
        catch(NullPointerException e){
            errorMsg.append("No Distributed Area Selected\n");
        }
        try{
            LocalDate date = SceneManager.getDashboardViewLogWaterPressure().getDatePickerLogDate().getValue();
            if(date==null){
                errorMsg.append("Date Not Entered\n");
            }
        }
        catch(NumberFormatException e){
            errorMsg.append("Date Not Entered\n");
        }
        try {
            Integer hour = Integer.parseInt(SceneManager.getDashboardViewLogWaterPressure().getTxtTimeHour().getText());
            if (hour>23){errorMsg.append("Hour too large\n");}
            else if (hour<0){errorMsg.append("Hour too small\n");}
        }
        catch(NumberFormatException e){errorMsg.append("Hour Not Entered or value isn't an integer\n");}
        try {
            Integer minute = Integer.parseInt(SceneManager.getDashboardViewLogWaterPressure().getTxtTimeMinute().getText());
            if (minute>59){errorMsg.append("Minute too large\n");}
            else if (minute<0){errorMsg.append("Minute too small\n");}
        }
        catch(NumberFormatException e){errorMsg.append("Minute Not Entered or value isn't an integer\n");}
        try {
            Double waterPressure = Double.parseDouble(SceneManager.getDashboardViewLogWaterPressure().getTxtPressure().getText());
            if (waterPressure<0){errorMsg.append("Water pressure too small\n");}
        }
        catch(NumberFormatException e){errorMsg.append("Water pressure not entered\n");}

        //no errors in the submitted inputs
        if (errorMsg.toString().equals("")){
            return true;
        }
        //there is an error in the inputs
        new Alert(Alert.AlertType.ERROR, errorMsg.toString()).show();
        return false;
    }

    public static String getLogName(){
        String area = SceneManager.getDashboardViewLogWaterPressure().getCmbArea().toString();
        String timeHr = SceneManager.getDashboardViewLogWaterPressure().getTxtTimeHour().getText();
        String timeMin = SceneManager.getDashboardViewLogWaterPressure().getTxtTimeMinute().getText();
        String date = SceneManager.getDashboardViewLogWaterPressure().getDatePickerLogDate().getValue().toString();
        return area + "_Water_Pressure_" + date + "_" + timeHr + "_" + timeMin;
    }

}


