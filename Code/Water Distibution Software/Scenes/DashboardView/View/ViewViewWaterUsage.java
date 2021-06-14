/**
 * Class: ViewViewWaterUsage
 * Author: Robert Stevenson
 * Contributing Author(s):
 *
 * Date Created: 10/06/2021
 *
 * Description:
 *
 */
package WaterDistibution.Scenes.DashboardView.View;

import WaterDistibution.DataStorage;
import WaterDistibution.Model.LogUsage;
import WaterDistibution.Scenes.DashboardView.Controller.ViewViewWaterUsageController;
import WaterDistibution.Update;
import javafx.geometry.Insets;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.awt.geom.Area;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class ViewViewWaterUsage extends Pane implements Update {

   private BorderPane primaryBox = new BorderPane();
   private GridPane grid = new GridPane();

   private BorderPane header = new BorderPane();
   private HBox hBoxNavButtons = new HBox();
   private Button btnPrevMonth = new Button("Previous Month");
   private Button btnNextMonth = new Button("Next Month");

   private CategoryAxis xAxis = new CategoryAxis();
   private NumberAxis yAxis = new NumberAxis();
   private LineChart<String, Number> graph = new LineChart<>(xAxis, yAxis);
   private XYChart.Series series  = new XYChart.Series<String, Number>();

   private int intMonth = LocalDate.now().getMonthValue();
   private String strMonth = Month.of(intMonth).toString();

   public ViewViewWaterUsage() {
      setupLayout();
      setupEvents();
   }

   private void setupLayout() {
      primaryBox.prefHeightProperty().bind(this.heightProperty());
      primaryBox.prefWidthProperty().bind(this.widthProperty());

      //add the UI components to the dashboard view
      this.getChildren().add(primaryBox);

      //setup header
      header.setPadding(new Insets(5));

      //setup the line chart (graph)
      graph.setAnimated(false);
      graph.setTitle("Water usage, " + strMonth);
      graph.prefHeightProperty().bind(primaryBox.heightProperty());
      graph.prefWidthProperty().bind(primaryBox.widthProperty());

      //setup graph data
      loadGraphData(DataStorage.getWaterUsageLogs(), strMonth);

      //add the UI components to the view
      primaryBox.setTop(header);
      primaryBox.setCenter(graph);

      hBoxNavButtons.getChildren().add(btnPrevMonth);
      hBoxNavButtons.getChildren().add(btnNextMonth);

      header.setRight(hBoxNavButtons);
   }

   private void setupEvents() {
      btnPrevMonth.setOnAction(ViewViewWaterUsageController::btnPrevMonthClicked);
      btnNextMonth.setOnAction(ViewViewWaterUsageController::btnNextMonthClicked);
   }

   @Override
   public void update() {
      graph.setTitle("Water usage, " + strMonth);
      loadGraphData(DataStorage.getWaterUsageLogs(), strMonth);
   }

   public void incrementMonth(){
      //increase month
      intMonth++;
      //check to see if month is put out of bounds
      if (intMonth>12){
         intMonth = 1;
      }
      //get month string value
      strMonth = Month.of(intMonth).toString();
   }

   public void decrementMonth(){
      //decrease month
      intMonth--;
      //check to see if month is put out of bounds
      if (intMonth<1){
         intMonth = 12;
      }
      //get month string value
      strMonth = Month.of(intMonth).toString();
   }

   private void loadGraphData(ArrayList<LogUsage> data, String month){
      //reset graph
      graph.getData().clear();
      //reset graph data series
      series.getData().clear();
      series.setName("Example Series");

      data.sort(Comparator.comparing(LogUsage::getDate));
      for (LogUsage l: data) {
         System.out.println("Log month: " + l.getDate().getMonth().getValue() +
                 "String Month value: "+Month.valueOf(month).getValue());
         //only load logs for the month selected to view
         if (l.getDate().getMonth().getValue() == Month.valueOf(month).getValue()){
            //add the log to the graph series
            series.getData().add(new XYChart.Data<>(l.getDate().toString(), l.getWaterUsaged()));
         }
      }
      graph.getData().add(series);
   }
}
