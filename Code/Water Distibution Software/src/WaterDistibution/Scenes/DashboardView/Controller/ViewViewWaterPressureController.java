package WaterDistibution.Scenes.DashboardView.Controller;

import WaterDistibution.SceneManager;
import javafx.event.ActionEvent;

public class ViewViewWaterPressureController {
        public static void btnPrevMonthClicked(ActionEvent event){
            SceneManager.getDashboardViewViewWaterPressure().decrementMonth();
            SceneManager.getDashboardViewViewWaterPressure().update();
            System.out.println("ViewPressure: btnPrevMonthClicked");
        }

        public static void btnNextMonthClicked(ActionEvent event){
            SceneManager.getDashboardViewViewWaterPressure().incrementMonth();
            SceneManager.getDashboardViewViewWaterPressure().update();
            System.out.println("ViewPressure: btnNextMonthClicked");
        }

    }

