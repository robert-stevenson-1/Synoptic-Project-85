package WaterDistibution.Scenes.DashboardView.View;

import WaterDistibution.DataStorage;
import WaterDistibution.Model.LogUsage;
import WaterDistibution.Update;
import javafx.geometry.Insets;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.awt.geom.Area;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

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
   private XYChart.Series series  = new XYChart.Series();

   private String strMonth = "Month";
   private String strArea = "Area";

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
      graph.setTitle("Water usage, " + strArea + ", " + strMonth);

      //setup graph data
      loadGraphData(DataStorage.getWaterUsageLogs());
      graph.getData().add(series);

      //add the UI components to the view
      primaryBox.setTop(header);
      primaryBox.setCenter(graph);

      hBoxNavButtons.getChildren().add(btnPrevMonth);
      hBoxNavButtons.getChildren().add(btnNextMonth);

      header.setRight(hBoxNavButtons);
   }

   private void setupEvents() {

   }


   @Override
   public void update() {

   }

   private void loadGraphData(ArrayList<LogUsage> data){
      data.sort(Comparator.comparing(LogUsage::getDate));
      for (LogUsage l: data) {
         series.getData().add(new XYChart.Data<>(l.getDate(), l.getWaterUsaged()));
      }
   }
}
