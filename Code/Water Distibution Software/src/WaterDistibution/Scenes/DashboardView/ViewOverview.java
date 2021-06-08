package WaterDistibution.Scenes.DashboardView;

import javafx.geometry.Pos;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.awt.font.NumericShaper;

public class ViewOverview extends Pane {
   private GridPane grid = new GridPane();

   //chart 1
   private NumberAxis xAxis = new NumberAxis();
   private NumberAxis yAxis = new NumberAxis();
   private LineChart<Number, Number> LineChart = new LineChart<Number, Number>(xAxis,yAxis);

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
      grid.setVgap(25);
      grid.setHgap(25);

      this.getChildren().add(grid);
   }

   private void setupEvents() {

   }
}
