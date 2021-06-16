package WaterDistibution.Scenes.DashboardView.View;

import WaterDistibution.DataStorage;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class DialogRemoveArea extends Dialog<String> {

   private GridPane grid = new GridPane();
   private HBox hBoxAreaLayout = new HBox();
   private Label lblArea = new Label("Area: ");
   private ComboBox<String> cmbArea = new ComboBox();
   private ButtonType btnSubmit = new ButtonType("Submit", ButtonBar.ButtonData.OK_DONE);

   public DialogRemoveArea(String title) {
      this.setTitle(title);
      setupLayout();
      setupEvents();
   }

   private void setupLayout() {
      //add the grid to dialog box
      this.getDialogPane().setContent(grid);

      //setup the task type Combobox
      cmbArea.getItems().addAll(DataStorage.getDistributionAreas());

      GridPane.setFillHeight(hBoxAreaLayout, true);
      hBoxAreaLayout.setAlignment(Pos.CENTER);

      //setup the grid
      ColumnConstraints cc = new ColumnConstraints();
      cc.setHgrow(Priority.ALWAYS);
      cc.setFillWidth(true);
      grid.getColumnConstraints().add(cc);

      //populate the grid
      hBoxAreaLayout.getChildren().add(lblArea);
      hBoxAreaLayout.getChildren().add(cmbArea);

      grid.add(hBoxAreaLayout,0,0);

      this.getDialogPane().getButtonTypes().add(btnSubmit);
   }

   private void setupEvents() {
      this.setResultConverter(buttonType -> {
         if (buttonType == btnSubmit) {
            if (validInput()){
               return cmbArea.getValue();
            }
         }
         return null;
      });
   }

   private boolean validInput(){
      //Error message content
      String errorMsg = "";

      //presence check
      if (cmbArea.getValue() == null){
         errorMsg+=("No Area Selected\n");
      }

      //no errors in the submitted inputs
      if (errorMsg.equals("")){
         return true;
      }

      //there is an error in the inputs
      new Alert(Alert.AlertType.ERROR, "FAILED TO REMOVE AREA\n\n"+errorMsg).show();
      return false;
   }
}
