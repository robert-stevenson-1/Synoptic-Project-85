package WaterDistibution.Scenes.DashboardView.Controller;

import WaterDistibution.SceneManager;
import javafx.event.ActionEvent;

public class ViewViewWaterRefillController {
    public static void btnPrevMonthClicked(javafx.event.ActionEvent event){
        SceneManager.getDashboardViewViewWaterRefill().decrementMonth();
        SceneManager.getDashboardViewViewWaterRefill().update();
        System.out.println("ViewLevel: btnPrevMonthClicked");
    }

    public static void btnNextMonthClicked(ActionEvent event){
        SceneManager.getDashboardViewViewWaterRefill().incrementMonth();
        SceneManager.getDashboardViewViewWaterRefill().update();
        System.out.println("ViewLevel: btnNextMonthClicked");
    }

}
