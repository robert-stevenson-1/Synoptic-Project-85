/**
 * Class: ScheduleTile
 * Author: Robert Stevenson
 * Contributing Author(s):
 *
 * Date Created: 09/06/2021
 *
 * Description:
 *
 */
package WaterDistibution.Scenes.DashboardView.View.Schedule;

import WaterDistibution.ScheduleStorage.Task;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class ScheduleTile extends Pane {
   private static final double MIN_WIDTH = 100;
   private static final double MIN_HEIGHT = 100;
   private static final double PREF_WIDTH = 300;
   private static final double PREF_HEIGHT = 400;
   private static final double MAX_WIDTH = 400;
   private static final double MAX_HEIGHT = 720;

   private int intDay;

   private BorderPane primaryBox = new BorderPane();
   private BorderPane header = new BorderPane();
   private Label lblIntDay = new Label();
   private Label lblStrDay = new Label();
   private ListView<TaskTile> taskList = new ListView<>();


   public ScheduleTile(int intDay) {
      this.intDay = intDay;
      setupLayout();
      setupEvents();
   }

   private void setupLayout() {
      //set the tile size
      this.setMinWidth(MIN_WIDTH);
      this.setMinHeight(MIN_HEIGHT);
      this.setPrefWidth(PREF_WIDTH);
      this.setPrefHeight(PREF_HEIGHT);
      this.setWidth(PREF_WIDTH);
      this.setHeight(PREF_WIDTH);
      this.setMaxWidth(MAX_WIDTH);
      this.setMaxHeight(MAX_HEIGHT);

      this.getChildren().add(primaryBox);

      primaryBox.prefHeightProperty().bind(this.heightProperty());
      primaryBox.prefWidthProperty().bind(this.widthProperty());


      //setup the task list display
      //makeTaskList();

      //setup label intDay
      setDay(intDay);

      //setup the primary box
      primaryBox.setTop(header);
      primaryBox.setCenter(taskList);

      //setup the header
      header.setLeft(lblIntDay);
      header.setRight(lblStrDay);
   }

   private void setupEvents() {

   }

   public void addTasks(ArrayList<Task> tasks){
      ObservableList<TaskTile> data = FXCollections.observableArrayList();
      for (Task t :
              tasks) {
         if (t.getDay() == intDay){
            data.add(new TaskTile(t));
         }
      }
      taskList.setItems(data);
   }

   public void setDay(int intDay) {
      Date now = new Date();
      this.lblIntDay.setText(String.valueOf(intDay));
      this.lblStrDay.setText(getDayString(now, Locale.getDefault()));
   }

   //link reference:https://www.baeldung.com/java-get-day-of-week
   private String getDayString(Date date, Locale locale){
      DateFormat dateFormat = new SimpleDateFormat("EEEE", locale);
      date.setDate(intDay);
      return dateFormat.format(date);
   }
}
