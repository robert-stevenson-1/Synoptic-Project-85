package WaterDistibution.Scenes.DashboardView.Controller;

import WaterDistibution.SceneManager;
import WaterDistibution.Scenes.DashboardView.View.Schedule.DialogAddTask;
import WaterDistibution.Model.Task;
import javafx.event.ActionEvent;

import java.util.Optional;

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

   public static void btnAddTaskClicked(ActionEvent event) {
      DialogAddTask addTask = new DialogAddTask("Add Task");
      Optional<Task> result = addTask.showAndWait();
      if (result.isPresent()){
         SceneManager.getDashboardSchedule().getSchedule().addTask(result.get());
         System.out.println("Added task successfully");
         SceneManager.getDashboardSchedule().update();
      }
      System.out.println("Schedule: btnAddTaskClicked");
   }
}
