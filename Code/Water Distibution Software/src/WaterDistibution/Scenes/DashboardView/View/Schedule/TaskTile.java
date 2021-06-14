package WaterDistibution.Scenes.DashboardView.View.Schedule;

import WaterDistibution.SceneManager;
import WaterDistibution.Model.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
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
   private Button btnDeleteTask = new Button("X");

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

      //setup btnDeleteTask
      btnDeleteTask.setMaxWidth(10);
      btnDeleteTask.setMaxHeight(10);

      //add the components to the primary container
      primaryBox.setTop(gridTextLayout);
      primaryBox.setBottom(vBoxCheckLayout);

      gridTextLayout.add(btnDeleteTask, 0,0);
      gridTextLayout.add(lblTaskName,0,1);
      gridTextLayout.add(new Label(task.getJobType().toString()),1,1);
      gridTextLayout.add(lblTime,0,2);
      gridTextLayout.add(new Label(task.getHour() + ":" + task.getMinute()),1,2);

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

      btnDeleteTask.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent event) {
            System.out.println(event.getSource());
            //get the schedule tile that his task tile is displayed in
            Object tempObj = event.getSource();
            ScheduleTile scheduleTile = null;
            TaskTile taskTile = null;
            System.out.println("tempObj: "+tempObj);
            do {
               tempObj = ((Node)tempObj).getParent();
               if ((tempObj instanceof ScheduleTile)){
                  scheduleTile = (ScheduleTile)tempObj;
               }
               if ((tempObj instanceof TaskTile)){
                  taskTile = (TaskTile) tempObj;
               }

            }while ((scheduleTile == null)||(taskTile==null));
            System.out.println("tempObj: "+tempObj);
            System.out.println("scheduleTile: "+scheduleTile);
            System.out.println("taskTile: "+taskTile);
            System.out.println("scheduleTile this contained: "+ scheduleTile.getTaskList().getItems().contains(taskTile));
            System.out.println("scheduleTile this contained: "+ scheduleTile.getTaskList().getItems().contains(this));
            System.out.println("this: "+this);
            System.out.println("ScheduleTile TaskList: " + scheduleTile.getTaskList().getItems());
            System.out.println("ScheduleTile TaskList task remove: " + scheduleTile.getTaskList().getItems().remove(taskTile));
            //get the schedule and remove the task that his tile holds and then move the tile form the schedule view
            SceneManager.getDashboardSchedule().getSchedule().getTasks().remove(taskTile.task);
/*            ArrayList<ScheduleTile> scheduleTiles = SceneManager.getDashboardSchedule().getTiles();
            for (ScheduleTile st :
                    scheduleTiles) {

            }*/
            System.out.println("scheduleTile tasklist: "+scheduleTile.getTaskList());
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

   @Override
   public String toString() {
      return "TaskTile{" +
              "TaskName=" + lblTaskName.getText() +
              ", task=" + task +
              '}';
   }
}
