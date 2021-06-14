/**
 * Class: ViewOverview
 * Author: Robert Stevenson
 * Contributing Author(s):
 *
 * Date Created: 08/06/2021
 *
 * Description:
 *
 */
package WaterDistibution.Scenes.DashboardView.View;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.awt.font.NumericShaper;

public class ViewOverview extends Pane {
   private static final double GRID_X_GAP = 10;
   private static final double GRID_Y_GAP = 10;

   private GridPane grid = new GridPane();

   //chart 1
   private NumberAxis xAxislineChart1 = new NumberAxis();
   private NumberAxis yAxislineChart1 = new NumberAxis();
   private LineChart<Number, Number> lineChart1 = new LineChart<>(xAxislineChart1,yAxislineChart1);

   //chart 2
   private NumberAxis xAxislineChart2 = new NumberAxis();
   private NumberAxis yAxislineChart2 = new NumberAxis();
   private LineChart<Number, Number> lineChart2 = new LineChart<>(xAxislineChart2,yAxislineChart2);

   //chart 3
   private NumberAxis xAxislineChart3 = new NumberAxis();
   private NumberAxis yAxislineChart3 = new NumberAxis();
   private LineChart<Number, Number> lineChart3 = new LineChart<>(xAxislineChart3,yAxislineChart3);

   //task list (next tasks to do)
   private ListView<String> taskList = new ListView<>();

   public ViewOverview() {
      setupLayout();
      setupEvents();
   }

   private void setupLayout() {
      //setup grid
      //set grid line visible (debugging only)
      grid.setGridLinesVisible(true);
      grid.prefHeightProperty().bind(this.heightProperty());
      grid.prefWidthProperty().bind(this.widthProperty());
      grid.setAlignment(Pos.CENTER);
      grid.setVgap(GRID_X_GAP);
      grid.setHgap(GRID_Y_GAP);

      //populate the the task list
      makeTaskList();

      //add the UI components to the dashboard view
      this.getChildren().add(grid);

      grid.add(taskList, 0,0);
      grid.add(lineChart1,0,1);
      grid.add(lineChart2,1,0);
      grid.add(lineChart3,1,1);
   }

   private void setupEvents() {

   }

   private void makeTaskList() {
      ObservableList<String> data = FXCollections.observableArrayList();
      data.addAll("Task Example 1","Task Example 2","Task Example 3","Task Example 4",
                      "Task Example 5","Task Example 6","Task Example 7","Task Example 8");

      taskList.setItems(data);
   }
}
