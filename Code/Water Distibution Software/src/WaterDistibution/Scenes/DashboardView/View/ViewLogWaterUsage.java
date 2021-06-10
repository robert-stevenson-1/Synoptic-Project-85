/**
 * Class: ViewLogWaterUsage
 * Author: Robert Stevenson
 * Contributing Author(s):
 *
 * Date Created: 09/06/2021
 *
 * Description:
 *
 */
package WaterDistibution.Scenes.DashboardView.View;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class ViewLogWaterUsage extends Pane {

   private BorderPane primaryBox = new BorderPane();
   private GridPane grid = new GridPane();
   private Label lblNamePreview = new Label("Log Name:");
   private TextField txtLogNamePreview = new TextField();
   private Label lblArea = new Label("Distributed Area:");
   private ComboBox cmbArea = new ComboBox();
   private Label lblDate = new Label("Date:");
   private DatePicker datePickerLogDate = new DatePicker();
   private Label lblTime = new Label("Time:");
   private TextField txtTimeInput = new TextField();
   private HBox hBoxUsageLayout = new HBox();
   private Label lblUsage = new Label("Water Usage:");
   private Label lblUsageUnit = new Label("L");
   private TextField txtUsage = new TextField();
   private Button btnSubmit = new Button("Submit Water Usage Log");

   public ViewLogWaterUsage() {
      setupLayout();
      setupEvents();
   }

   private void setupLayout() {
      //set the parent primary Box that contains the components of the view
      this.getChildren().add(primaryBox);

      //setup the primary containing box
      primaryBox.prefHeightProperty().bind(this.heightProperty());
      primaryBox.prefWidthProperty().bind(this.widthProperty());
      primaryBox.setPadding(new Insets(15));


      //bind the scaling of the grid to the primary parent node component
      grid.prefHeightProperty().bind(primaryBox.heightProperty());
      grid.prefWidthProperty().bind(primaryBox.widthProperty());
      grid.maxHeightProperty().bind(primaryBox.maxHeightProperty());
      grid.maxWidthProperty().bind(primaryBox.maxHeightProperty());

      //setup the grid used to UI component alignment and positioning
      //set grid line visible (debugging only)
      ColumnConstraints cc = new ColumnConstraints();
      cc.setHgrow(Priority.ALWAYS);
      cc.setFillWidth(true);
      RowConstraints rc = new RowConstraints();
      rc.setVgrow(Priority.ALWAYS);
      rc.setFillHeight(true);
      grid.getColumnConstraints().addAll(cc,cc,cc, cc);
      grid.getRowConstraints().addAll(rc,rc,rc,rc);
      grid.setGridLinesVisible(true);
      grid.setAlignment(Pos.CENTER);
      grid.setVgap(10);
      grid.setHgap(10);

      //add the UI components to the primary container
      // box of the view
      primaryBox.setCenter(grid);

      hBoxUsageLayout.getChildren().add(txtUsage);
      hBoxUsageLayout.getChildren().add(lblUsageUnit);

      grid.add(lblNamePreview,0,0);
      grid.add(txtLogNamePreview,1,0);
      grid.add(lblArea,2,0);
      grid.add(cmbArea,3,0);
      grid.add(lblDate,0,1);
      grid.add(datePickerLogDate,1,1);
      grid.add(lblTime,2,1);
      grid.add(txtTimeInput,3,1);
      grid.add(lblUsage,0,2);
      grid.add(hBoxUsageLayout,1,2);
      grid.add(btnSubmit,1,3);

   }

   private void setupEvents() {
   }
}
