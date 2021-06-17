/**
 * Class: DialogAddTask
 * Author: Robert Stevenson
 * Contributing Author(s):
 *
 * Date Created: 12/06/2021
 *
 * Description:
 *
 */
package WaterDistibution.Scenes.DashboardView.View.Schedule;

import WaterDistibution.Model.Task;
import WaterDistibution.SceneManager;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class DialogAddTask extends Dialog<Task> {

   private GridPane grid = new GridPane();
   private HBox hBoxTaskTypeLayout = new HBox();
   private Label lblTaskType = new Label("Task: ");
   private ComboBox<Task.JobType> cmbTaskType = new ComboBox();
   private HBox hBoxDateLayout = new HBox();
   private Label lblDate = new Label("Date: ");
   private DatePicker datePicker = new DatePicker();
   private HBox hBoxTime = new HBox();
   private Label lblTime = new Label("Time: ");
   private TextField txtHour = new TextField();
   private TextField txtMinute = new TextField();
   private ButtonType btnSubmit = new ButtonType("Submit", ButtonBar.ButtonData.OK_DONE);

   public DialogAddTask(String title) {
      this.setTitle(title);
      setupLayout();
      setupEvents();
   }

   private void setupLayout() {
      //add the grid to dialog box
      this.getDialogPane().setContent(grid);

      //setup the task type Combobox
      cmbTaskType.getItems().addAll(Task.JobType.values());

      GridPane.setFillHeight(hBoxTaskTypeLayout, true);
      hBoxTaskTypeLayout.setAlignment(Pos.CENTER);

      GridPane.setFillHeight(hBoxDateLayout, true);
      hBoxDateLayout.setAlignment(Pos.CENTER);

      GridPane.setFillHeight(hBoxTime, true);
      hBoxTime.setAlignment(Pos.CENTER);
      txtHour.maxWidthProperty().bind(grid.widthProperty().multiply(0.25));
      txtMinute.maxWidthProperty().bind(grid.widthProperty().multiply(0.25));

      //setup the grid
      ColumnConstraints cc = new ColumnConstraints();
      cc.setHgrow(Priority.ALWAYS);
      cc.setFillWidth(true);
      grid.getColumnConstraints().add(cc);

      //populate the grid
      hBoxTaskTypeLayout.getChildren().add(lblTaskType);
      hBoxTaskTypeLayout.getChildren().add(cmbTaskType);

      hBoxDateLayout.getChildren().add(lblDate);
      hBoxDateLayout.getChildren().add(datePicker);

      hBoxTime.getChildren().add(lblTime);
      hBoxTime.getChildren().add(txtHour);
      hBoxTime.getChildren().add(new Label(":"));
      hBoxTime.getChildren().add(txtMinute);

      grid.add(hBoxTaskTypeLayout,0,0);
      grid.add(hBoxDateLayout,0,1);
      grid.add(hBoxTime,0,2);

      this.getDialogPane().getButtonTypes().add(btnSubmit);
   }

   private void setupEvents() {
      this.setResultConverter(buttonType -> {
         if (buttonType == btnSubmit) {
            if (validInput()){
               return new Task(datePicker.getValue(),
                       Integer.parseInt(txtHour.getText()),
                       Integer.parseInt(txtMinute.getText()),
                       cmbTaskType.getValue(),
                       false,
                       false);
            }
         }
         return null;
      });
   }

   private boolean validInput(){
      //Error message content
      String errorMsg = "";

      if (datePicker.getValue() == null){
         errorMsg+="Date not entered\n";
      }

      if (cmbTaskType.getValue() == null){
         errorMsg+="Task type not selected\n";
      }

      try {
         Integer hour = Integer.parseInt(txtHour.getText());
         if (hour>23){
            errorMsg+="Hours must be less than 24\n";
         }else if (hour<0){
            errorMsg+="Hours can't be negative\n";
         }
      }
      catch(NumberFormatException e){
         errorMsg+="Hour Not Entered or value isn't an integer\n";
      }

      try {
         Integer minute = Integer.parseInt(txtMinute.getText());
         if (minute>59){
            errorMsg+="Minutes must be less than 60\n";
         }
         else if (minute<0){
            errorMsg+="Minutes can't be negative\n";
         }
      } catch(NumberFormatException e){
         errorMsg+="Minute Not Entered or value isn't an integer\n";
      }

      //no errors in the submitted inputs
      if (errorMsg.equals("")){
         return true;
      }

      //there is an error in the inputs
      new Alert(Alert.AlertType.ERROR, "FAILED TO ADD TASK\n\n"+errorMsg).show();
      return false;
   }
}
