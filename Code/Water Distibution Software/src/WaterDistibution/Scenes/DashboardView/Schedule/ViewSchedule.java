package WaterDistibution.Scenes.DashboardView.Schedule;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;

public class ViewSchedule extends Pane {

   private static final double GRID_X_GAP = 10;
   private static final double GRID_Y_GAP = 10;

//   //calendar variable to get the systems date and time
//   // information used for setting up the schedule display
//   private Calendar calendar = Calendar.getInstance();

   private Month curMonth = Month.of(LocalDate.now().getMonthValue());
   private ArrayList<ScheduleTile> tiles = new ArrayList<>();

   private GridPane grid = new GridPane();

   public ViewSchedule() {
      setupLayout();
      setupEvents();
   }

   private void setupLayout() {

      //add the UI components to the dashboard view
      this.getChildren().add(grid);

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
      //build the schedule grid with tiles
      int day = 1;
      int row = 0;

/*      grid.add(new ScheduleTile(1),0,0);
      grid.add(new ScheduleTile(2),0,1);
      grid.add(new ScheduleTile(3),1,0);
      grid.add(new ScheduleTile(4),1,1);*/
      while (day <= curMonth.length(LocalDate.now().isLeapYear())){
         for (int i = 0; i < 7 && day <= curMonth.length(LocalDate.now().isLeapYear()); i++) {
            ScheduleTile tile = new ScheduleTile(day);
            tiles.add(tile);
            grid.add(tile,i, row);
            day++;
         }
         row++;
      }

      for (ScheduleTile t: tiles) {
         t.prefHeightProperty().bind(grid.heightProperty().divide(grid.getRowCount()));
         t.prefWidthProperty().bind(grid.widthProperty().divide(grid.getColumnCount()));
      }
      
   }

   private void setupEvents() {
   }
}
