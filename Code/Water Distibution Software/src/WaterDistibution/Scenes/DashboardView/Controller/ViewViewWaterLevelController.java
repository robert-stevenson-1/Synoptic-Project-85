package WaterDistibution.Scenes.DashboardView.Controller;

import WaterDistibution.SceneManager;
import javafx.event.ActionEvent;

public class ViewViewWaterLevelController {
    public static void btnPrevMonthClicked(javafx.event.ActionEvent event){
        SceneManager.getDashboardViewViewWaterLevel().decrementMonth();
        SceneManager.getDashboardViewViewWaterLevel().update();
        System.out.println("ViewLevel: btnPrevMonthClicked");
    }

    public static void btnNextMonthClicked(ActionEvent event){
        SceneManager.getDashboardViewViewWaterLevel().incrementMonth();
        SceneManager.getDashboardViewViewWaterLevel().update();
        System.out.println("ViewLevel: btnNextMonthClicked");
    }

}
