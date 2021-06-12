package WaterDistibution.Scenes.DashboardView.View.Schedule;

import WaterDistibution.ScheduleStorage.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

public class TaskTile extends Pane {

   private BorderPane primaryBox = new BorderPane();
   private GridPane gridTextLayout = new GridPane();
   private Label lblTaskName = new Label("Task: ");
   private Label lblTime = new Label("Time: ");
   private VBox vBoxCheckLayout = new VBox();
   private CheckBox chkLogged = new CheckBox("logged");
   private CheckBox chkCompleted = new CheckBox("Completed");

   private Task task;

   public TaskTile(Task task) {
      this.task = task;
      setupLayout();
      setupEvents();
   }

   private void setupLayout() {
      primaryBox.prefHeightProperty().bind(this.heightProperty());
      primaryBox.prefWidthProperty().bind(this.widthProperty());

      //add the task UI components to the task tile
      this.getChildren().add(primaryBox);

      //setup UI components value
      //setTaskName(task.getJobType().toString());
      //setTime(task.getHour(), task.getMinute());
      setLogged(task.getIsLogged());
      setCompleted(task.getIsComplete());

      //add the components to the primary container
      primaryBox.setTop(gridTextLayout);
      primaryBox.setBottom(vBoxCheckLayout);

      gridTextLayout.add(lblTaskName,0,0);
      gridTextLayout.add(new Label(task.getJobType().toString()),1,0);
      gridTextLayout.add(lblTime,0,1);
      gridTextLayout.add(new Label(task.getHour() + ":" + task.getMinute()),1,1);

      vBoxCheckLayout.getChildren().add(chkLogged);
      vBoxCheckLayout.getChildren().add(chkCompleted);

   }

   private void setupEvents() {
      chkLogged.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent event) {
            task.setIsLogged(chkLogged.isSelected());
            System.out.println(task);
         }
      });

      chkCompleted.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent event) {
            task.setIsComplete(chkCompleted.isSelected());
            System.out.println(task);
         }
      });
   }

   public void setTaskName(String taskName){
      lblTaskName.setText(taskName);
      System.out.println(lblTaskName.getText());
   }

   public void setTime(int hour, int minute){
      lblTaskName.setText(hour + ":" + minute);
   }

   public void setLogged(boolean isLogged){
      chkLogged.setSelected(isLogged);
   }

   public void setCompleted(boolean isCompleted){
      chkCompleted.setSelected(isCompleted);
   }
}
