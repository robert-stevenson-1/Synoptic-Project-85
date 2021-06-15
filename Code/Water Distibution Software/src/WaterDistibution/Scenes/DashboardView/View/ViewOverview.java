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

import WaterDistibution.DataStorage;
import WaterDistibution.Model.LogLevel;
import WaterDistibution.Model.LogPressure;
import WaterDistibution.Model.LogUsage;
import WaterDistibution.Update;
import javafx.geometry.Pos;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;

public class ViewOverview extends Pane implements Update {
   private static final double GRID_X_GAP = 10;
   private static final double GRID_Y_GAP = 10;

   private int intMonth = LocalDate.now().getMonthValue();
   private String strMonth = Month.of(intMonth).toString();

   private GridPane grid = new GridPane();

   //waterUsageGraph
   private CategoryAxis xAxisWaterUsage = new CategoryAxis();
   private NumberAxis yAxisWaterUsage = new NumberAxis();
   private LineChart<String, Number> waterUsageGraph = new LineChart<>(xAxisWaterUsage, yAxisWaterUsage);
   private ArrayList<XYChart.Series> seriesUsageList = new ArrayList<>();

   //waterPressureGraph
   private CategoryAxis xAxisWaterPressure = new CategoryAxis();
   private NumberAxis yAxisWaterPressure = new NumberAxis();
   private LineChart<String, Number> waterPressureGraph = new LineChart<>(xAxisWaterPressure, yAxisWaterPressure);
   private ArrayList<XYChart.Series> seriesPressureList = new ArrayList<>();

   //waterLevelGraph
   private CategoryAxis xAxisWaterLevel = new CategoryAxis();
   private NumberAxis yAxisWaterLevel = new NumberAxis();
   private LineChart<String, Number> waterLevelGraph = new LineChart<>(xAxisWaterLevel, yAxisWaterLevel);
   private XYChart.Series seriesLevel  = new XYChart.Series<String, Number>();

   //task list (next tasks to do)
   //private ListView<String> taskList = new ListView<>();

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
      //makeTaskList();

      //setup the graph properties
      waterLevelGraph.setAnimated(false);
      waterLevelGraph.setTitle("Water Level, " + strMonth);
      waterUsageGraph.setAnimated(false);
      waterUsageGraph.setTitle("Water Usage, " + strMonth);
      waterPressureGraph.setAnimated(false);
      waterPressureGraph.setTitle("Water Pressure, " + strMonth);

      //populate the graphs with the current systems month's logged data
      loadUsageGraph(DataStorage.getWaterUsageLogs(), strMonth);
      loadPressureGraph(DataStorage.getWaterPressureLogs(), strMonth);
      loadLevelGraph(DataStorage.getWaterLevelLogs(), strMonth);

      //add the UI components to the dashboard view
      this.getChildren().add(grid);

      grid.add(waterUsageGraph, 0,0);
      grid.add(waterPressureGraph,0,1);
      grid.add(waterLevelGraph,1,0);
      //grid.add(taskList,1,1);
   }

   private void setupEvents() {

   }

   @Override
   public void update() {
      intMonth = LocalDate.now().getMonthValue();
      strMonth = Month.of(intMonth).toString();
      loadUsageGraph(DataStorage.getWaterUsageLogs(), strMonth);
      loadPressureGraph(DataStorage.getWaterPressureLogs(), strMonth);
      loadLevelGraph(DataStorage.getWaterLevelLogs(), strMonth);
   }

   private void loadUsageGraph(ArrayList<LogUsage> data, String month){
      //reset graph
      waterUsageGraph.getData().clear();
      //reset graph data series
      seriesUsageList.clear();
      //create a series for every distribution area
      for (String a :
              DataStorage.getDistributionAreas()) {
         XYChart.Series series = new XYChart.Series();
         series.setName(a);
         seriesUsageList.add(series);
      }

      data.sort(Comparator.comparing(LogUsage::getDate));
      for (LogUsage l: data) {
         System.out.println("Log month: " + l.getDate().getMonth().getValue() +
                 "String Month value: "+ Month.valueOf(month).getValue());
         //only load logs for the month selected to view
         if (l.getDate().getMonth().getValue() == Month.valueOf(month).getValue()){
            //add the log to the graph series for that area
            for (XYChart.Series s :
                    seriesUsageList) {
               if (s.getName().equals(l.getDistributionArea())){
                  s.getData().add(new XYChart.Data<>(l.getDate().toString(), l.getWaterUsaged()));
               }
            }
         }
      }
      //add the series to the chart
      for (XYChart.Series s:
              seriesUsageList) {
         waterUsageGraph.getData().add(s);
      }
   }

   private void loadPressureGraph(ArrayList<LogPressure> data, String month) {
      //reset graph
      waterPressureGraph.getData().clear();
      //reset graph data series
      seriesPressureList.clear();
      //create a series for every distribution area
      for (String a :
              DataStorage.getDistributionAreas()) {
         XYChart.Series series = new XYChart.Series();
         series.setName(a);
         seriesPressureList.add(series);
      }

      data.sort(Comparator.comparing(LogPressure::getDate));
      for (LogPressure l: data) {
         System.out.println("Log month: " + l.getDate().getMonth().getValue() +
                 "String Month value: "+ Month.valueOf(month).getValue());
         //only load logs for the month selected to view
         if (l.getDate().getMonth().getValue() == Month.valueOf(month).getValue()){
            //add the log to the graph series for that area
            for (XYChart.Series s :
                    seriesPressureList) {
               if (s.getName().equals(l.getDistributionArea())){
                  s.getData().add(new XYChart.Data<>(l.getDate().toString(), l.getWaterPressure()));
               }
            }
         }
      }
      //add the series to the chart
      for (XYChart.Series s:
              seriesPressureList) {
         waterPressureGraph.getData().add(s);
      }
   }

   private void loadLevelGraph(ArrayList<LogLevel> data, String month) {
      //reset graph
      waterLevelGraph.getData().clear();
      //reset graph data series
      seriesLevel.getData().clear();
      seriesLevel.setName("Water Level");

      data.sort(Comparator.comparing(LogLevel::getDate));
      for (LogLevel l : data) {
         System.out.println("Log month: " + l.getDate().getMonth().getValue() +
                 "String Month value: " + Month.valueOf(month).getValue());
         //only load logs for the month selected to view
         if (l.getDate().getMonth().getValue() == Month.valueOf(month).getValue()) {
            //add the log to the graph series
            seriesLevel.getData().add(new XYChart.Data<>(l.getDate().toString(), l.getWaterLevel()));
         }
      }
      waterLevelGraph.getData().add(seriesLevel);
   }

/*   private void makeTaskList() {
      ObservableList<String> data = FXCollections.observableArrayList();
      data.addAll("Task Example 1","Task Example 2","Task Example 3","Task Example 4",
                      "Task Example 5","Task Example 6","Task Example 7","Task Example 8");

      taskList.setItems(data);
   }*/
}
