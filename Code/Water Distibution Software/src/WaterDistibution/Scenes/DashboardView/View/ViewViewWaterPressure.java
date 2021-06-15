package WaterDistibution.Scenes.DashboardView.View;

import WaterDistibution.DataStorage;
import WaterDistibution.Model.LogPressure;
import WaterDistibution.Scenes.DashboardView.Controller.ViewViewWaterPressureController;
import WaterDistibution.Update;
import javafx.geometry.Insets;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;

public class ViewViewWaterPressure extends Pane implements Update {

   private BorderPane primaryBox = new BorderPane();

   private BorderPane header = new BorderPane();
   private HBox hBoxNavButtons = new HBox();
   private Button btnPrevMonth = new Button("Previous Month");
   private Button btnNextMonth = new Button("Next Month");

   private CategoryAxis xAxis = new CategoryAxis();
   private NumberAxis yAxis = new NumberAxis();
   private LineChart<String, Number> graph = new LineChart<>(xAxis, yAxis);
   private ArrayList<XYChart.Series> seriesArrayList = new ArrayList<>();

   private int intMonth = LocalDate.now().getMonthValue();
   private int intYear = LocalDate.now().getYear();
   private String strMonth = Month.of(intMonth).toString();

   public  ViewViewWaterPressure() {
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
      graph.setTitle("Water pressure, " + strMonth);
      graph.prefHeightProperty().bind(primaryBox.heightProperty());
      graph.prefWidthProperty().bind(primaryBox.widthProperty());

      //setup graph data
      loadGraphData(DataStorage.getWaterPressureLogs(), strMonth);

      //add the UI components to the view
      primaryBox.setTop(header);
      primaryBox.setCenter(graph);

      hBoxNavButtons.getChildren().add(btnPrevMonth);
      hBoxNavButtons.getChildren().add(btnNextMonth);

      header.setRight(hBoxNavButtons);
   }

   private void setupEvents() {
      btnPrevMonth.setOnAction(ViewViewWaterPressureController::btnPrevMonthClicked);
      btnNextMonth.setOnAction(ViewViewWaterPressureController::btnNextMonthClicked);
   }

   @Override
   public void update() {
      graph.setTitle("Water Pressure - " + strMonth + ", " + intYear);
      loadGraphData(DataStorage.getWaterPressureLogs(), strMonth);
   }

   public void incrementMonth(){
      //increase month
      intMonth++;
      //check to see if month is put out of bounds
      if (intMonth>12){
         intMonth = 1;
         intYear++;
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
          intYear--;
      }
      //get month string value
      strMonth = Month.of(intMonth).toString();
   }

   private void loadGraphData(ArrayList<LogPressure> data, String month){
     //reset graph
     graph.getData().clear();
     //reset graph data series
     seriesArrayList.clear();
     //create a series for every distribution area
     for (String a :
             DataStorage.getDistributionAreas()) {
        XYChart.Series series = new XYChart.Series();
        series.setName(a);
        seriesArrayList.add(series);
     }

     data.sort(Comparator.comparing(LogPressure::getDate));
     for (LogPressure l: data) {
        System.out.println("Log month: " + l.getDate().getMonth().getValue() +
                "String Month value: "+Month.valueOf(month).getValue());
        //only load logs for the month selected to view
        if (l.getDate().getMonth().getValue() == Month.valueOf(month).getValue()
                && (l.getDate().getYear() == intYear)){
           //add the log to the graph series for that area
           for (XYChart.Series s :
                   seriesArrayList) {
              if (s.getName().equals(l.getDistributionArea())){
                 s.getData().add(new XYChart.Data<>(l.getDate().toString(), l.getWaterPressure()));
              }
           }
        }
     }
     //add the series to the chart
     for (XYChart.Series s:
             seriesArrayList) {
        graph.getData().add(s);
     }
   }
}
