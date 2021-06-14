/**
 * Class: ViewSchedule
 * Author: Robert Stevenson
 * Contributing Author(s):
 *
 * Date Created: 08/06/2021
 *
 * Description:
 *
 */
package WaterDistibution.Scenes.DashboardView.View.Schedule;

import WaterDistibution.Scenes.DashboardView.Controller.ViewScheduleController;
import WaterDistibution.Update;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class ViewSchedule extends Pane implements Update {

   private static final double GRID_X_GAP = 10;
   private static final double GRID_Y_GAP = 10;

   private int intMonth = LocalDate.now().getMonthValue();
   private Month month = Month.of(intMonth);
   private ArrayList<ScheduleTile> tiles = new ArrayList<>();

   private BorderPane primaryBox = new BorderPane();
   private BorderPane header = new BorderPane();
   private GridPane grid = new GridPane();
   private Label lblMonth = new Label("Month");
   private HBox hBoxNavButtons = new HBox();
   private Button btnPrevMonth = new Button("Previous Month");
   private Button btnNextMonth = new Button("Next Month");


   public ViewSchedule() {
      setupLayout();
      setupEvents();
   }

   private void setupLayout() {
      primaryBox.prefHeightProperty().bind(this.heightProperty());
      primaryBox.prefWidthProperty().bind(this.widthProperty());

      //add the UI components to the dashboard view
      this.getChildren().add(primaryBox);

      //setup grid
      //set grid line visible (debugging only)
      grid.setGridLinesVisible(true);
      grid.prefHeightProperty().bind(this.heightProperty());
      grid.prefWidthProperty().bind(this.widthProperty());
      grid.maxHeightProperty().bind(this.heightProperty());
      grid.maxWidthProperty().bind(this.widthProperty());
      grid.setAlignment(Pos.CENTER);
      grid.setVgap(GRID_X_GAP);
      grid.setHgap(GRID_Y_GAP);
      buildScheduleGrid();

      //setup header
      header.setPadding(new Insets(5));

      //setup the month label
      lblMonth.setText(month.toString());

      //setup prevMonth button
      btnPrevMonth.setPadding(new Insets(15));
      btnPrevMonth.setMinWidth(125);
      btnPrevMonth.setMaxWidth(125);

      //setup nextMonth button
      btnNextMonth.setPadding(new Insets(15));
      btnNextMonth.setMinWidth(125);
      btnNextMonth.setMaxWidth(125);

      //add the UI components to the view
      primaryBox.setTop(header);
      primaryBox.setCenter(grid);

      hBoxNavButtons.getChildren().add(btnPrevMonth);
      hBoxNavButtons.getChildren().add(btnNextMonth);

      header.setRight(hBoxNavButtons);
      header.setCenter(lblMonth);

   }

   private void setupEvents() {
      btnNextMonth.setOnAction(ViewScheduleController::btnNextMonthClicked);
      btnPrevMonth.setOnAction(ViewScheduleController::btnPrevMonthClicked);
   }

   @Override
   public void update() {
      lblMonth.setText(month.toString());
      buildScheduleGrid();
   }

   public void incrementMonth(){
      //increase month
      intMonth++;
      //check to see if month is put out of bounds
      if (intMonth>12){
         intMonth = 1;
      }
      //get the schedule month value
      month = Month.of(intMonth);
   }

   public void decrementMonth(){
      //decrease month
      intMonth--;
      //check to see if month is put out of bounds
      if (intMonth<1){
         intMonth = 12;
      }
      //get the schedule month value
      month = Month.of(intMonth);
   }

   private void buildScheduleGrid(){
      //TODO:adjust to build blank or load schedule when approriate.

      //TODO:Save any changes to this Schedule before changes.
      //reset the schedules grid and tiles
      grid.getChildren().clear();
      tiles.clear();

      //build the schedule grid with tiles
      int day = 1;
      int row = 0;

/*      grid.add(new ScheduleTile(1),0,0);
      grid.add(new ScheduleTile(2),0,1);
      grid.add(new ScheduleTile(3),1,0);
      grid.add(new ScheduleTile(4),1,1);*/

      //loop for however many days are in the current month
      while (day <= month.length(LocalDate.now().isLeapYear())){
         //every 7 days (a week) is one row
         for (int i = 0; i < 7 && day <= month.length(LocalDate.now().isLeapYear()); i++) {
            //get the schedule data and display the tasks in the tile

            //random example data:
            ScheduleTile tile = new ScheduleTile(day);
            tiles.add(tile);
            grid.add(tile,i, row);

            day++;
         }
         row++;
      }
      //set the tile scaling
      for (ScheduleTile t: tiles) {
         t.prefHeightProperty().bind(grid.heightProperty().divide(grid.getRowCount()));
         t.prefWidthProperty().bind(grid.widthProperty().divide(grid.getColumnCount()));
      }
   }
}
