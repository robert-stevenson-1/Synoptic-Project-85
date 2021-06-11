package WaterDistibution.Scenes.DashboardView.Controller;

import WaterDistibution.SceneManager;
import javafx.event.ActionEvent;

public class ViewScheduleController {
   public static void btnPrevMonthClicked(javafx.event.ActionEvent event){
      SceneManager.getDashboardSchedule().decrementMonth();
      SceneManager.getDashboardSchedule().update();
      System.out.println("Schedule: btnPrevMonthClicked");
   }

   public static void btnNextMonthClicked(ActionEvent event){
      SceneManager.getDashboardSchedule().incrementMonth();
      SceneManager.getDashboardSchedule().update();
      System.out.println("Schedule: btnNextMonthClicked");
   }
}
