package WaterDistibution.Scenes.DashboardView.Controller;

import WaterDistibution.DataStorage;
import WaterDistibution.Model.LogPressure;
import WaterDistibution.SceneManager;
import WaterDistibution.Scenes.DashboardView.View.DialogAddArea;
import WaterDistibution.Scenes.DashboardView.View.DialogRemoveArea;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

import java.time.LocalDate;
import java.util.Optional;

public class ViewLogWaterPressureController {
    public static void btnSubmitClicked(ActionEvent event) {

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
            SceneManager.getDashboardViewLogWaterPressure().setLogName(getLogName());
            System.out.println("Log Name updated");
        } catch (Exception e){
            System.out.println(e);
        }
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
        String area = SceneManager.getDashboardViewLogWaterPressure().getCmbArea().getValue().toString();
        String timeHr = SceneManager.getDashboardViewLogWaterPressure().getTxtTimeHour().getText();
        String timeMin = SceneManager.getDashboardViewLogWaterPressure().getTxtTimeMinute().getText();
        String date = SceneManager.getDashboardViewLogWaterPressure().getDatePickerLogDate().getValue().toString();
        return "Water_Pressure_" + area + "_" + date + "_" + timeHr + "_" + timeMin;
    }
}


