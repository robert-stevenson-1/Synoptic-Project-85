package WaterDistibution.Scenes.DashboardView.View;

import WaterDistibution.DataStorage;
import WaterDistibution.ScheduleStorage.Task;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class DialogAddArea extends Dialog<String> {

   private GridPane grid = new GridPane();
   private HBox hBoxAreaLayout = new HBox();
   private Label lblArea = new Label("Area: ");
   private TextField txtArea = new TextField();
   private ButtonType btnSubmit = new ButtonType("Submit", ButtonBar.ButtonData.OK_DONE);

   public DialogAddArea(String title) {
      this.setTitle(title);
      setupLayout();
      setupEvents();
   }

   private void setupLayout() {
      //add the grid to dialog box
      this.getDialogPane().setContent(grid);

      txtArea.maxWidthProperty().bind(grid.widthProperty());

      //setup the grid
      ColumnConstraints cc = new ColumnConstraints();
      cc.setHgrow(Priority.ALWAYS);
      cc.setFillWidth(true);
      grid.getColumnConstraints().add(cc);

      grid.add(hBoxAreaLayout,0,0);

      hBoxAreaLayout.getChildren().add(lblArea);
      hBoxAreaLayout.getChildren().add(txtArea);

      this.getDialogPane().getButtonTypes().add(btnSubmit);
   }

   private void setupEvents() {
      this.setResultConverter(buttonType -> {
         if (buttonType == btnSubmit) {
            return txtArea.getText();
         }
         return null;
      });
   }

}
